package com.jsp.exception;

public class RideNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RideNotFoundException(String message) {
		super();
		this.message = message;
	}

}
