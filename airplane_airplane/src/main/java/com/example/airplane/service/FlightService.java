package com.example.airplane.service;

	import com.example.airplane.model.Flight;
import com.example.airplane.model.SearchRequest;
//import com.ins.web.vo.Project;
//
//import java.time.LocalDateTime;
import java.util.List;

	public interface FlightService {
		List<Flight> searchFlights(SearchRequest searchRequest);
		List<Flight> getAllFlights();
	    
	    Flight getFlightByFlightnumber(Long flightnumber);
	//	List<Flight> searchFlightsByCities(String departureCity, String arrivalCity);

		//List<Flight> executeCriteriaQuery();
//		  List<Flight> getProjectsByProjectKey(Long projectkey);
//		    
//		    List<Flight> getProjectsByProjectName(String projectName);
//		    
//		    List<Flight> getProjectsByProjectManager(String projectManager);
//		    
//		    List<Flight> getProjectsByCreatedBy(String createdby);
//		    List<Flight> getProjectsByStatus(String status);
//		    
//		   
//		    List<Project> getProjectsByProjectStartDate(LocalDateTime projectStartDate);
//		  
//		    List<Project> getProjectsByApprovedCapex(Long approvedCapex);

		

		

		
	}


