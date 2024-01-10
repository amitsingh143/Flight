package com.example.airplane.model;

public class SearchRequest {
	private Long flightnumber;
    private String flightname;
    private String departure_city;
    private String arrival_city;
    private String departure_time;
    private String arrival_time;
    private Long capacity;
private String sortColumn;


	
	

	
    public String getSortColumn() {
	return sortColumn;
}


public void setSortColumn(String sortColumn) {
	this.sortColumn = sortColumn;
}


public String getSortOrder() {
	return sortOrder;
}


public void setSortOrder(String sortOrder) {
	this.sortOrder = sortOrder;
}


public int getLimit() {
	return limit;
}


public void setLimit(int limit) {
	this.limit = limit;
}
	private String sortOrder;
    private int limit;

	
	public SearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SearchRequest(Long flightnumber, String flightname, String departure_city, String arrival_city,
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
	
}
