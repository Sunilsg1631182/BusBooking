package com.jsp.exception;

public class BusNotFoundException extends RuntimeException {
	private String message;

	public BusNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
