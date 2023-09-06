package com.jsp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dto.BusRequest;
import com.jsp.dto.BusResponse;
import com.jsp.util.ResponseStructure;

public interface BusService {
	
    public ResponseEntity<ResponseStructure<BusResponse>> saveBus(BusRequest busRequest);
	
	public ResponseEntity<ResponseStructure<BusResponse>> updateBusById(BusRequest busRequest,int busId);
	
	public ResponseEntity<ResponseStructure<BusResponse>> findBusById(int busId);
	
	public ResponseEntity<ResponseStructure<List<BusResponse>>> findAllBuses();
	
	public ResponseEntity<ResponseStructure<BusResponse>> deleteBusById(int busId);

}
