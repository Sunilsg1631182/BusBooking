package com.jsp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.dto.SeatRequest;
import com.jsp.dto.SeatResponse;
import com.jsp.util.ResponseStructure;

public interface SeatService {
	
	public ResponseEntity<ResponseStructure<SeatResponse>> saveSeat(SeatRequest seatRequest);
	
    public ResponseEntity<ResponseStructure<SeatResponse>> updateSeatById(SeatRequest seatRequest,int seatId);
	
	public ResponseEntity<ResponseStructure<SeatResponse>> findSeatById(int seatId);
	
	public ResponseEntity<ResponseStructure<List<SeatResponse>>> findAllSeats();
	
	public ResponseEntity<ResponseStructure<SeatResponse>> deleteSeatById(int seatId);

}
