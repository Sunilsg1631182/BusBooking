package com.jsp.dto;

import java.util.List;

import com.jsp.entity.Ride;
import com.jsp.entity.Seat;

public class BusResponse {
	private int busId;
	private String busNumber;
	private List<Seat> seats;
	private List<Ride> rides;
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public List<Ride> getRides() {
		return rides;
	}
	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

}
