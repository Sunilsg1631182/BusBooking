package com.jsp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private int bookingSeatNo;
	private String fromAddress;
	private String destination;
	private String paymentStatus;
	private LocalDateTime bookingDateTime;
	
	@ManyToOne
    private	Traveller traveller;
	
	
	@ManyToOne
	private Ride ride;
	
	
	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public int getBookingSeatNo() {
		return bookingSeatNo;
	}


	public void setBookingSeatNo(int bookingSeatNo) {
		this.bookingSeatNo = bookingSeatNo;
	}


	public String getFromAddress() {
		return fromAddress;
	}


	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}


	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}


	public Traveller getTraveller() {
		return traveller;
	}


	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}


	public Ride getRide() {
		return ride;
	}


	public void setRide(Ride ride) {
		this.ride = ride;
	}


	public Seat getSeat() {
		return seat;
	}


	public void setSeat(Seat seat) {
		this.seat = seat;
	}


	@ManyToOne
	private Seat seat;
	
	
	
	

}
