package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.dto.RideRequest;
import com.jsp.dto.RideResponse;
import com.jsp.service.RideService;
import com.jsp.util.ResponseStructure;

@RestController
public class RideController {
	@Autowired
	RideService service;

	@PostMapping("/saveRide")
	public ResponseEntity<ResponseStructure<RideResponse>> saveRide(RideRequest rideRequest) {
		return service.saveRide(rideRequest);
		
	}

	@PutMapping("/updateRide/{rideId}")
	public ResponseEntity<ResponseStructure<RideResponse>> updateRideById(RideRequest rideRequest, int rideId) {
		return service.updateRideById(rideRequest, rideId);
		
	}

@GetMapping("/findRide/{rideId}")
	public ResponseEntity<ResponseStructure<RideResponse>> findRideById(@PathVariable int rideId) {
		return service.findRideById(rideId);
	}

@GetMapping("/findAllRides")
	public ResponseEntity<ResponseStructure<List<RideResponse>>> findAllRides() {
		return service.findAllRides();
	}

@DeleteMapping("/deleteRide/{rideId}")
	public ResponseEntity<ResponseStructure<RideResponse>> deleteRideById(@PathVariable int rideId) {
		return service.deleteRideById(rideId);
	}

}
