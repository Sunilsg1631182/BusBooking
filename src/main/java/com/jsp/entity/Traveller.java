package com.jsp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Traveller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travellerId;
	private String travellerName;
	private String travellerEmail;
	private String travellerPassword;
	private String travellerAddress;

	@OneToMany(mappedBy = "traveller")
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
