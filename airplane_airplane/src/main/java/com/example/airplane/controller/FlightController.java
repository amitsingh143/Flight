package com.example.airplane.controller;

import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.airplane.model.Flight;
import com.example.airplane.service.FlightService;
import com.example.airplane.service.exception.NoMatchingDataException;


import java.util.Collections;
import java.util.List;
	
	
	import org.springframework.web.bind.annotation.*;
	import com.example.airplane.model.SearchRequest;
import com.example.airplane.repository.FlightRepository;

	@RestController
	@RequestMapping("/api/Flight")
	public class FlightController {

		private static final Logger logger = LogManager.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

   @Autowired
    private FlightRepository flightRepository;

	

   @PostMapping("/{flightnumber}")
	public Flight getFlightByFlightnumber(@PathVariable Long flightnumber) {
		logger.log(Level.INFO, "API hitting from controller to getFlightByFlightnumber");
		return flightService.getFlightByFlightnumber(flightnumber);
	}
  
   
    
    @PostMapping
    public List<Flight> getAllFlights() {
    	logger.log(Level.INFO, "API hitting from controller to getAllFlights");
        return  flightService.getAllFlights();
    }
    

   
    
    //enhance searching
    
    @PostMapping("/search")
	public ResponseEntity<Object> searchFlights(@RequestBody SearchRequest searchRequest) {
		logger.log(Level.INFO, "API hitting from controller to searchFlights");

		try {
			System.out.println("Enter");
			List<Flight> result = flightService.searchFlights(searchRequest);
			System.out.println("gfg");
			if (result.isEmpty()) {
				// Return a specific response for not found with a custom message
				String message = "No matching data found for the provided criteria.";
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", message));
			}
			System.out.println("gfg exit");

		    return ResponseEntity.ok(result);
		
		} catch (NoMatchingDataException e) {
			// Log the exception
			logger.error("NoMatchingDataException: " + e.getMessage());

			// Return a specific response for not found with a custom message
			String message = "No matching data found for the given criteria.";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", message));
		} catch (Exception e) {
			// Log unexpected exceptions
			logger.error("Unexpected exception: " + e.getMessage(), e);

			// Return a specific response for other exceptions with a custom message
			String message = "An unexpected error occurred.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.singletonMap("message", message));
		}
	}

}
