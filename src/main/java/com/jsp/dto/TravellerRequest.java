package com.jsp.dto;

import java.util.List;

import com.jsp.entity.Booking;

public class TravellerRequest {
	private int travellerId;
	private String travellerName;
	private String travellerEmail;
	private String travellerPassword;
	private String travellerAddress;
	private List<Booking> books;
	public int getTravellerId() {
		return travellerId;
	}
	public void setTravellerId(int travellerId) {
		this.travellerId = travellerId;
	}
	public String getTravellerName() {
		return travellerName;
	}
	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}
	public String getTravellerEmail() {
		return travellerEmail;
	}
	public void setTravellerEmail(String travellerEmail) {
		this.travellerEmail = travellerEmail;
	}
	public String getTravellerPassword() {
		return travellerPassword;
	}
	public void setTravellerPassword(String travellerPassword) {
		this.travellerPassword = travellerPassword;
	}
	public String getTravellerAddress() {
		return travellerAddress;
	}
	public void setTravellerAddress(String travellerAddress) {
		this.travellerAddress = travellerAddress;
	}
	public List<Booking> getBooks() {
		return books;
	}
	public void setBooks(List<Booking> books) {
		this.books = books;
	}

}
