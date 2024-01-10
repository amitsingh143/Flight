package com.example.airplane.service;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.example.airplane.model.Flight;
import com.example.airplane.repository.FlightRepository;
import com.example.airplane.service.exception.NoMatchingDataException;


import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import com.example.airplane.model.SearchRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FlightServiceImpl implements FlightService {

	private static final Logger logger = LogManager.getLogger(FlightServiceImpl.class);
    @Autowired
    private FlightRepository flightRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Flight> getAllFlights() {
    	logger.log(Level.INFO, "Fetching all employees");
        return flightRepository.findAll();
    }
    
    @Override
	public Flight getFlightByFlightnumber(Long flightnumber) {
    	logger.log(Level.INFO, "Fetching employee by Flightnumber: {0}", flightnumber);
        Optional<Flight> optionalFlight = flightRepository.findByFlightnumber(flightnumber);
        return optionalFlight.orElse(null);
		
	}
    

   


//    public List<Flight> searchFlightsByCities(String departure_city, String arrival_city) {
//        return flightRepository.findByDeparture_cityAndArrival_city(departure_city, arrival_city);
//    }
    
         
         
         
         
       //enhancing the search operations
         @Override
         public List<Flight> searchFlights(SearchRequest searchRequest) {
 			System.out.println("Enter search flights");

             CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
             
             CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
             Root<Flight> root = criteriaQuery.from(Flight.class);
             
             List<Predicate> predicates = new ArrayList<Predicate>();
             

 			System.out.println("Performing search checks flightnumber");


     		if (searchRequest.getFlightnumber() != null) {
     			predicates.add(criteriaBuilder.equal(root.get("flightnumber"), searchRequest.getFlightnumber()));
     		}
     		
			System.out.println("checks for other" + searchRequest.getFlightnumber() + predicates.toString());


             if (!StringUtils.isEmpty(searchRequest.getFlightname())) {
                 predicates.add(criteriaBuilder.equal(root.get("flightname"), searchRequest.getFlightname()));
             }

             if (!StringUtils.isEmpty(searchRequest.getDeparture_time())) {
                 predicates.add(criteriaBuilder.equal(root.get("departure_time"), searchRequest.getDeparture_time()));
             }
             if (!StringUtils.isEmpty(searchRequest.getArrival_city())) {
                 predicates.add(criteriaBuilder.equal(root.get("arrival_city"), searchRequest.getArrival_city()));
             }
             if (!StringUtils.isEmpty(searchRequest.getDeparture_city())) {
                 predicates.add(criteriaBuilder.equal(root.get("departure_city"), searchRequest.getDeparture_city()));
             }
             if (!StringUtils.isEmpty(searchRequest.getArrival_time())) {
                 predicates.add(criteriaBuilder.equal(root.get("arrival_time"), searchRequest.getArrival_time()));
             }
             if (searchRequest.getCapacity()!= null) {
                 predicates.add(criteriaBuilder.equal(root.get("capacity"), searchRequest.getCapacity()));
             }
             
             
             criteriaQuery.where(predicates.toArray(new Predicate[0]));
             
             //sorting
 			System.out.println("Sorting");
 			 if (!StringUtils.isEmpty(searchRequest.getSortColumn())) {
 	            List<Order> orders = new ArrayList<>();
 	            if ("asc".equalsIgnoreCase(searchRequest.getSortOrder())) {
 	                orders.add(criteriaBuilder.asc(root.get(searchRequest.getSortColumn())));
 	            } else {
 	                orders.add(criteriaBuilder.desc(root.get(searchRequest.getSortColumn())));
 	            }
 	            criteriaQuery.orderBy(orders);
 	        }
 	        
 	        TypedQuery<Flight> query = entityManager.createQuery(criteriaQuery);
 	        //printing
 	       System.out.println("query :"+criteriaQuery.toString());
 	     // Apply limit
 	        query.setMaxResults(searchRequest.getLimit());
 	        
 	    // Example logging statements
 	   //    logger.info("Generated SQL query: {}", query.unwrap(org.hibernate.Query.class).getQueryString());
 	       logger.info("Parameters: {}", query.getParameters());

 	        
 	        List<Flight> result = query.getResultList();
 	        System.out.println(result.size());

 	        if (result.isEmpty()) {
 	            // Return a custom message when no matching data is found
 	            throw new NoMatchingDataException("Matching data not there");
 	        }

 	        return result;
 	    }
		     
    }

