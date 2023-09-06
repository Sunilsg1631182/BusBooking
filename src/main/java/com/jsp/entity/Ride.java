package com.jsp.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Ride {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
private int rideId;
private LocalDateTime rideStartDateTime;
private LocalDateTime rideEndDateTime;

	
@OneToMany(mappedBy="ride")
private	List<Booking> bookings;

@ManyToOne
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
