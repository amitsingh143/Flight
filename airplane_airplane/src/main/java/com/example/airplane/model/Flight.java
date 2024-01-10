package com.example.airplane.model;


import jakarta.annotation.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long flightnumber;
    private String flightname;
    public Flight(Long flightnumber, String flightname, String departure_city, String arrival_city,
			String departure_time, String arrival_time, Long capacity) {
		super();
		this.flightnumber = flightnumber;
		this.flightname = flightname;
		this.departure_city = departure_city;
		this.arrival_city = arrival_city;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.capacity = capacity;
	}


	public Long getFlightnumber() {
		return flightnumber;
	}


	public void setFlightnumber(Long flightnumber) {
		this.flightnumber = flightnumber;
	}


	public String getFlightname() {
		return flightname;
	}


	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	private String departure_city;
    private String arrival_city;
    private String departure_time;
    private String arrival_time;
    private Long capacity;
    
    
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Flight [flightnumber=" + flightnumber + ", flightname=" + flightname + ", departure_city="
				+ departure_city + ", arrival_city=" + arrival_city + ", departure_time=" + departure_time
				+ ", arrival_time=" + arrival_time + ", capacity=" + capacity + ", getFlightnumber()="
				+ getFlightnumber() + ", getFlightname()=" + getFlightname() + ", getDeparture_city()="
				+ getDeparture_city() + ", getArrival_city()=" + getArrival_city() + ", getDeparture_time()="
				+ getDeparture_time() + ", getArrival_time()=" + getArrival_time() + ", getCapacity()=" + getCapacity()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	
}
