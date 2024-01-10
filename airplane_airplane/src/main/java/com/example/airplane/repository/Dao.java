package com.example.airplane.repository;

import java.util.List;

import com.example.airplane.model.Flight;


import com.example.airplane.model.SearchRequest;

public interface Dao {

	List<Flight> searchFlights(SearchRequest searchRequest);
	public static final String ID = "id";
	public static final String KEY = "key";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";
	public static final String ACCOUNT_TYPE = "account_type";
	public static final String AFE_NUMBER = "afe_number";
	public static final String APPROVED_CAPEX = "approved_capex";
	public static final String APPROVED_OPEX = "approved_opex";
	public static final String USER_NAME = "user_name";
	public static final String START_DATE = "start_date";
	public static final String END_DATE = "end_date";
	public static final String PROJECT_MANGER = "project_manager";
	public static final String CREATE_USER = "create_user";
	public static final String CREATE_DATETIME = "create_datetime";
	public static final String LAST_UPDATE_USER = "last_update_user";
	public static final String LAST_UPDATE_DATETIME = "last_update_datetime";
	public static final String COMMA = ", ";
	public static final String SET = " SET ";
	public static final String AND = " AND ";
	public static final String WHERE = " WHERE ";
	public static final String COUNT = "count";

	
}
