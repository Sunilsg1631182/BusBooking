package com.jsp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.dto.BookingRequest;
import com.jsp.dto.BookingResponse;
import com.jsp.util.ResponseStructure;

public interface BookingService {
	
	public ResponseEntity<ResponseStructure<BookingResponse>> saveBooking(BookingRequest bookingRequest);
	
	public ResponseEntity<ResponseStructure<BookingResponse>> updateBooking(BookingRequest bookingRequest,int bookingId);
	
	public ResponseEntity<ResponseStructure<BookingResponse>> findBookingById(int bookingId);
	
	public ResponseEntity<ResponseStructure<List<BookingResponse>>> findAllBookings();
	
	public ResponseEntity<ResponseStructure<BookingResponse>> deleteBookingById(int bookingId);

}
