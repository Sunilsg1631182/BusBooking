package com.jsp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dto.SeatRequest;
import com.jsp.dto.SeatResponse;
import com.jsp.entity.Seat;
import com.jsp.exception.SeatNotFoundException;
import com.jsp.repo.SeatRepo;
import com.jsp.service.SeatService;
import com.jsp.util.ResponseStructure;
@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	SeatRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<SeatResponse>> saveSeat(SeatRequest seatRequest) {
		Seat seat=new Seat();
		seat.setSeatId(seatRequest.getSeatId());
		seat.setSeatNumber(seatRequest.getSeatNumber());
		seat.setSeatType(seatRequest.getSeatType());
		seat.setBus(seatRequest.getBus());
		seat.setBookings(seatRequest.getBookings());
		
		Seat seat1 = repo.save(seat);
		
		SeatResponse response=new SeatResponse();
		
		response.setSeatId(seat1.getSeatId());
		response.setSeatNumber(seat1.getSeatNumber());
		response.setSeatType(seat1.getSeatType());
		response.setBus(seat1.getBus());
		response.setBookings(seat1.getBookings());
		
		ResponseStructure<SeatResponse> structure=new ResponseStructure<SeatResponse>();
		structure.setData(response);
		structure.setMessage("seat data saved");
		structure.setStatus(HttpStatus.CREATED.value());
		
	return new	ResponseEntity<ResponseStructure<SeatResponse>>(structure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<SeatResponse>> updateSeatById(SeatRequest seatRequest, int seatId) {
		Seat seat=repo.getById(seatId);
		if(seat!=null)
		{
			
			seat.setSeatId(seatRequest.getSeatId());
			seat.setSeatNumber(seatRequest.getSeatNumber());
			seat.setSeatType(seatRequest.getSeatType());
			seat.setBus(seatRequest.getBus());
			seat.setBookings(seatRequest.getBookings());
			
			Seat seat1 = repo.save(seat);
			
			SeatResponse response=new SeatResponse();
			
			response.setSeatId(seat1.getSeatId());
			response.setSeatNumber(seat1.getSeatNumber());
			response.setSeatType(seat1.getSeatType());
			response.setBus(seat1.getBus());
			response.setBookings(seat1.getBookings());
			
			
			ResponseStructure<SeatResponse> structure=new ResponseStructure<SeatResponse>();
			structure.setData(response);
			structure.setMessage("seat data updated");
			structure.setStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<SeatResponse>>(structure,HttpStatus.OK);
			
		}
		   else
		   {
			   throw new SeatNotFoundException("Seat not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<SeatResponse>> findSeatById(int seatId) {
	Seat seat=repo.getById(seatId);
	
	if(seat!=null)
	{
		SeatResponse response=new SeatResponse();
		
		response.setSeatId(seat.getSeatId());
		response.setSeatNumber(seat.getSeatNumber());
		response.setSeatType(seat.getSeatType());
		response.setBus(seat.getBus());
		response.setBookings(seat.getBookings());
	
		ResponseStructure<SeatResponse> structure=new ResponseStructure<SeatResponse>();
		structure.setData(response);
		structure.setMessage("seat data found");
		structure.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<SeatResponse>>(structure,HttpStatus.FOUND);
	}
	else
	{
		throw new SeatNotFoundException("Seat not found");
	}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<SeatResponse>>> findAllSeats() {
		List<Seat> seats = repo.findAll();
		List<SeatResponse> responses=new ArrayList<>();
		for(Seat seat:seats)
		{
			SeatResponse response=new SeatResponse();
			response.setSeatId(seat.getSeatId());
			response.setSeatNumber(seat.getSeatNumber());
			response.setSeatType(seat.getSeatType());
			response.setBus(seat.getBus());
			response.setBookings(seat.getBookings());
			
			responses.add(response);
			
		}
		
		ResponseStructure<List<SeatResponse>> structure=new ResponseStructure<List<SeatResponse>>();
		structure.setData(responses);
		structure.setMessage("seat data found");
		structure.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<List<SeatResponse>>>(structure,HttpStatus.FOUND);
		
		
	}

	@Override
	public ResponseEntity<ResponseStructure<SeatResponse>> deleteSeatById(int seatId) {
		Seat seat=repo.getById(seatId);
		
		if(seat!=null) {
			
			repo.deleteById(seat.getSeatId());
			
			ResponseStructure<SeatResponse> structure=new ResponseStructure<SeatResponse>();
			structure.setData(null);
			structure.setMessage("seat data deleted");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<SeatResponse>>(structure,HttpStatus.OK);
			
		}
		else
		{
			throw new SeatNotFoundException("Seat not found");
		}
		
	}

}
