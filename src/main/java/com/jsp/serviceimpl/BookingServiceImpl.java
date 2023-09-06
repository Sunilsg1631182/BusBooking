package com.jsp.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dto.BookingRequest;
import com.jsp.dto.BookingResponse;
import com.jsp.entity.Booking;
import com.jsp.exception.BookingNotFoundException;
import com.jsp.repo.BookingRepo;
import com.jsp.service.BookingService;
import com.jsp.util.ResponseStructure;
@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepo repo;
	

	@Override
	public ResponseEntity<ResponseStructure<BookingResponse>> saveBooking(BookingRequest bookingRequest) {
		
		Booking booking=new Booking();
		booking.setBookingId(bookingRequest.getBookingId());
		booking.setBookingDateTime(bookingRequest.getBookingDateTime());
		booking.setBookingSeatNo(bookingRequest.getBookingSeatNo());
		booking.setFromAddress(bookingRequest.getDestination());
		booking.setDestination(bookingRequest.getDestination());
		booking.setPaymentStatus(bookingRequest.getPaymentStatus());
		booking.setRide(bookingRequest.getRide());
		booking.setSeat(bookingRequest.getSeat());
		
	    Booking booking1 =  repo.save(booking);
	    
	    BookingResponse response=new BookingResponse();
	    
	   response.setBookingId(booking1.getBookingId());
	    response.setBookingDateTime(booking1.getBookingDateTime());
		response.setBookingSeatNo(booking1.getBookingSeatNo());
		response.setFromAddress(booking1.getDestination());
		response.setDestination(booking1.getDestination());
		response.setPaymentStatus(booking1.getPaymentStatus());
		response.setRide(booking1.getRide());
		response.setSeat(booking1.getSeat());
		
		ResponseStructure<BookingResponse> structure=new ResponseStructure<BookingResponse>();
		structure.setData(response);
		structure.setMessage("booking data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
	    
	    return new 	ResponseEntity<ResponseStructure<BookingResponse>>(structure,HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<ResponseStructure<BookingResponse>> updateBooking(BookingRequest bookingRequest,
			int bookingId) {
		Booking booking=repo.getById(bookingId);
		if(booking!=null)
		{
		booking.setBookingId(bookingRequest.getBookingId());
		booking.setBookingDateTime(bookingRequest.getBookingDateTime());
		booking.setBookingSeatNo(bookingRequest.getBookingSeatNo());
		booking.setFromAddress(bookingRequest.getDestination());
		booking.setDestination(bookingRequest.getDestination());
		booking.setPaymentStatus(bookingRequest.getPaymentStatus());
		booking.setRide(bookingRequest.getRide());
		booking.setSeat(bookingRequest.getSeat());
		
	Booking booking1 =  repo.save(booking);
	    
	    BookingResponse response=new BookingResponse();
	    
	   response.setBookingId(booking1.getBookingId());
	    response.setBookingDateTime(booking1.getBookingDateTime());
		response.setBookingSeatNo(booking1.getBookingSeatNo());
		response.setFromAddress(booking1.getDestination());
		response.setDestination(booking1.getDestination());
		response.setPaymentStatus(booking1.getPaymentStatus());
		response.setRide(booking1.getRide());
		response.setSeat(booking1.getSeat());
		
		ResponseStructure<BookingResponse> structure=new ResponseStructure<BookingResponse>();
		structure.setData(response);
		structure.setMessage("booking data updated successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new	ResponseEntity<ResponseStructure<BookingResponse>>(structure,HttpStatus.OK);
		}
		
		else
		{
			throw new BookingNotFoundException("booking not found");
		}
		
		}


	@Override
	public ResponseEntity<ResponseStructure<BookingResponse>> findBookingById(int bookingId) {
		Booking booking = repo.getById(bookingId);
		
		if(booking!=null)
		{
		BookingResponse response=new BookingResponse();
	    
		    response.setBookingId(booking.getBookingId());
		    response.setBookingDateTime(booking.getBookingDateTime());
			response.setBookingSeatNo(booking.getBookingSeatNo());
			response.setFromAddress(booking.getDestination());
			response.setDestination(booking.getDestination());
			response.setPaymentStatus(booking.getPaymentStatus());
			response.setRide(booking.getRide());
			response.setSeat(booking.getSeat());
			
			ResponseStructure<BookingResponse> structure=new ResponseStructure<BookingResponse>();
			structure.setData(response);
			structure.setMessage("booking data found successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new	ResponseEntity<ResponseStructure<BookingResponse>>(structure,HttpStatus.OK);
			}
			
			else
			{
				throw new BookingNotFoundException("booking not found");
			}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<BookingResponse>>> findAllBookings() {
		
	List<Booking> bookings = repo.findAll();
	List<BookingResponse> responses=new ArrayList<>();
	
	for(Booking booking:bookings)
	{
	BookingResponse response=new BookingResponse();
	    response.setBookingId(booking.getBookingId());
	    response.setBookingDateTime(booking.getBookingDateTime());
		response.setBookingSeatNo(booking.getBookingSeatNo());
		response.setFromAddress(booking.getDestination());
		response.setDestination(booking.getDestination());
		response.setPaymentStatus(booking.getPaymentStatus());
		response.setRide(booking.getRide());
		response.setSeat(booking.getSeat());
		
		responses.add(response);
	}
		ResponseStructure<List<BookingResponse>> structure=new ResponseStructure<List<BookingResponse>>();
		structure.setData(responses);
		structure.setMessage("booking data list found successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		
		return new	ResponseEntity<ResponseStructure<List<BookingResponse>>>(structure,HttpStatus.FOUND);
	
}
	
		
		
	
	@Override
	public ResponseEntity<ResponseStructure<BookingResponse>> deleteBookingById(int bookingId) {
	Booking booking	=repo.getById(bookingId);
	if(booking!=null)
	{
		repo.deleteById(booking.getBookingId());
		
		ResponseStructure<BookingResponse> structure=new ResponseStructure<BookingResponse>();
		structure.setData(null);
		structure.setMessage("booking data deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		
		return new	ResponseEntity<ResponseStructure<BookingResponse>>(structure,HttpStatus.OK);
	}
	else
	{
		throw new BookingNotFoundException("booking not found");
	}
		
	}



}
