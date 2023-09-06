package com.jsp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.dto.RideRequest;
import com.jsp.dto.RideResponse;
import com.jsp.util.ResponseStructure;

public interface RideService {
	public ResponseEntity<ResponseStructure<RideResponse>> saveRide(RideRequest rideRequest);
	
	public ResponseEntity<ResponseStructure<RideResponse>> updateRideById(RideRequest rideRequest,int rideId);
	
	public ResponseEntity<ResponseStructure<RideResponse>> findRideById(int rideId);
	
	public ResponseEntity<ResponseStructure<List<RideResponse>>> findAllRides();
	
	public ResponseEntity<ResponseStructure<RideResponse>> deleteRideById(int rideId);

}
