package com.example.airplane.repository;
import com.example.airplane.model.Flight;
import com.example.airplane.model.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl implements Dao{

	    private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public DaoImpl(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    @Override
	    public List<Flight> searchFlights(SearchRequest searchRequest) {
	        String sql = constructSearchQuery(searchRequest);
	        Object[] queryParams = getQueryParameters(searchRequest);
	        return jdbcTemplate.query(sql, queryParams, (resultSet, rowNum) -> mapFlight(resultSet));
	    }

	    private Flight mapFlight(ResultSet resultSet) throws SQLException {
	        Flight flight = new Flight();
	        flight.setFlightnumber(resultSet.getLong("flightnumber"));
	        flight.setFlightname(resultSet.getString("flightname"));
	        // Set other fields as needed
	        return flight;
	    }

	    private String constructSearchQuery(SearchRequest searchRequest) {
	        StringBuilder sql = new StringBuilder("SELECT * FROM flights WHERE 1=1");

	        if (searchRequest.getFlightnumber() != null) {
	            sql.append(" AND flightnumber = ").append(searchRequest.getFlightnumber());
	        }
	        if (searchRequest.getFlightname() != null) {
	            // Use parameterized query to prevent SQL injection
	            sql.append(" AND flightname = ?");
	        }
	        if (searchRequest.getArrival_city() != null) {
	            sql.append(" AND arrival_city = ?");
	        }
	        if (searchRequest.getDeparture_city() != null) {
	            sql.append(" AND departure_city = ?");
	        }
	        if (searchRequest.getArrival_city() != null) {
	            sql.append(" AND arrival_time = ?");
	        }
	        if (searchRequest.getDeparture_time() != null) {
	            sql.append(" AND departure_time = ?");
	        }
	        if (searchRequest.getCapacity() != null) {
	            sql.append(" AND capacity = ?");
	        }
	        // Add more conditions for other fields as needed

	        return sql.toString();
	    }

	    private Object[] getQueryParameters(SearchRequest searchRequest) {
	        // Create an array of query parameters based on search criteria
	        List<Object> params = new ArrayList<>();

	        if (searchRequest.getFlightname() != null) {
	            params.add(searchRequest.getFlightname());
	        }
	        if (searchRequest.getArrival_city() != null) {
	            params.add(searchRequest.getArrival_city());
	        }
	        if (searchRequest.getDeparture_city() != null) {
	            params.add(searchRequest.getDeparture_city());
	        }
	        if (searchRequest.getArrival_time() != null) {
	            params.add(searchRequest.getArrival_time());
	        }
	        if (searchRequest.getDeparture_time() != null) {
	            params.add(searchRequest.getDeparture_time());
	        }
	        if (searchRequest.getCapacity() != null) {
	            params.add(searchRequest.getCapacity());
	        }
	        // Add more parameters for other fields as needed

	        return params.toArray();
	    }
	}
	

