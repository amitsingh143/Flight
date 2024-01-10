package com.example.airplane.service.exception;

public class NoMatchingDataException  extends RuntimeException{
	public NoMatchingDataException(String message) {
        super(message);
	}
}
