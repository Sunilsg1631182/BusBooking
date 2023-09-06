package com.jsp.exception;

public class SeatNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SeatNotFoundException(String message) {
		super();
		this.message = message;
	}

}
