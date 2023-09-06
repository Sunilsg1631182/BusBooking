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

import com.jsp.dto.BookingRequest;
import com.jsp.dto.BookingResponse;
import com.jsp.service.BookingService;
import com.jsp.util.ResponseStructure;
@RestController
public class BookingController {
	
@Autowired
BookingService service;

	@PostMapping("/saveBooking")
	public ResponseEntity<ResponseStructure<BookingResponse>> saveBooking(@PathVariable BookingRequest bookingRequest) {
		return service.saveBooking(bookingRequest);
		
	}

	@PutMapping("updateBooking/{bookingId}")
	public ResponseEntity<ResponseStructure<BookingResponse>> updateBooking(@RequestBody BookingRequest bookingRequest,
		@PathVariable	int bookingId) {
		return service.updateBooking(bookingRequest, bookingId);
	}

	@GetMapping("/findBooking/{bookingId}")
	public ResponseEntity<ResponseStructure<BookingResponse>> findBookingById(@PathVariable int bookingId) {
		return service.findBookingById(bookingId);
	}

	@GetMapping("/findAllBooking")
	public ResponseEntity<ResponseStructure<List<BookingResponse>>> findAllBookings() {
	return service.findAllBookings();
	}
     
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<ResponseStructure<BookingResponse>> deleteBookingById(@PathVariable int bookingId) {
		return service.deleteBookingById(bookingId);
	}

}
