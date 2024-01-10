package com.example.airplane.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airplane.model.Flight;

	@Repository
	public interface FlightRepository extends JpaRepository<Flight, Long> {

	    List<Flight> findByFlightnumberAndFlightname(Long flightnumber, String flightname);

		Optional<Flight> findByFlightnumber(Long flightnumber);
		
		List<Flight> findByFlightname(String flightname);
		
	   // List<Flight> findByDeparture_cityAndArrival_city(String departure_city, String arrival_city);

	}


