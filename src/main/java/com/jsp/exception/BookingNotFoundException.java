package com.jsp.exception;

public class BookingNotFoundException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookingNotFoundException(String message) {
		super();
		this.message = message;
	}

}
