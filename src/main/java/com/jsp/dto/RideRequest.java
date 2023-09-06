package com.jsp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.jsp.entity.Booking;
import com.jsp.entity.Bus;


public class RideRequest {
	private int rideId;
	private LocalDateTime rideStartDateTime;
	private LocalDateTime rideEndDateTime;
	private	List<Booking> bookings;
    private Bus bus;
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public LocalDateTime getRideStartDateTime() {
		return rideStartDateTime;
	}
	public void setRideStartDateTime(LocalDateTime rideStartDateTime) {
		this.rideStartDateTime = rideStartDateTime;
	}
	public LocalDateTime getRideEndDateTime() {
		return rideEndDateTime;
	}
	public void setRideEndDateTime(LocalDateTime rideEndDateTime) {
		this.rideEndDateTime = rideEndDateTime;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}

}
