package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.dto.SeatRequest;
import com.jsp.dto.SeatResponse;
import com.jsp.service.SeatService;
import com.jsp.util.ResponseStructure;
@RestController
public class SeatController  {
	
	@Autowired
	SeatService service;

	@PostMapping("/saveSeat")
	public ResponseEntity<ResponseStructure<SeatResponse>> saveSeat(@RequestBody SeatRequest seatRequest) {
		return service.saveSeat(seatRequest);
	}

	@PutMapping("/update/{seatId}")
	public ResponseEntity<ResponseStructure<SeatResponse>> updateSeatById(@RequestBody SeatRequest seatRequest,@PathVariable int seatId) {
		return service.updateSeatById(seatRequest, seatId);
	}

    @GetMapping("/findSeat/{seatId}")
	public ResponseEntity<ResponseStructure<SeatResponse>> findSeatById(@PathVariable int seatId) {
		return service.findSeatById(seatId);
	}

    @GetMapping("/findAllSeats")
	public ResponseEntity<ResponseStructure<List<SeatResponse>>> findAllSeats() {
		return service.findAllSeats();
	}

	@DeleteMapping("/delete/{seatId}")
	public ResponseEntity<ResponseStructure<SeatResponse>> deleteSeatById(@PathVariable int seatId) {
		return service.deleteSeatById(seatId);
	}

}
