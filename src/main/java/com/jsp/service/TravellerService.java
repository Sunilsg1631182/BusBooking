package com.jsp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.dto.SeatRequest;
import com.jsp.dto.SeatResponse;
import com.jsp.dto.TravellerRequest;
import com.jsp.dto.TravellerResponse;
import com.jsp.util.ResponseStructure;

public interface TravellerService {
	
   public ResponseEntity<ResponseStructure<TravellerResponse>> saveTraveller(TravellerRequest travellerRequest);
	
    public ResponseEntity<ResponseStructure<TravellerResponse>> updateTravellerById(TravellerRequest travellerRequest,int travellerId);
	
	public ResponseEntity<ResponseStructure<TravellerResponse>> findTravellerById(int travellerId);
	
	public ResponseEntity<ResponseStructure<List<TravellerResponse>>> findAllTravellers();
	
	public ResponseEntity<ResponseStructure<TravellerResponse>> deleteTravellerById(int travellerId);

}
