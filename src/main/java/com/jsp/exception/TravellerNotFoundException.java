package com.jsp.exception;

public class TravellerNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TravellerNotFoundException(String message) {
		super();
		this.message = message;
	}

}
