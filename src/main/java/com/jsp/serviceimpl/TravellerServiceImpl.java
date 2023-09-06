package com.jsp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dto.TravellerRequest;
import com.jsp.dto.TravellerResponse;
import com.jsp.entity.Traveller;
import com.jsp.exception.TravellerNotFoundException;
import com.jsp.repo.TravellerRepo;
import com.jsp.service.TravellerService;
import com.jsp.util.ResponseStructure;
@Service
public class TravellerServiceImpl implements TravellerService {
	
	@Autowired
	TravellerRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<TravellerResponse>> saveTraveller(TravellerRequest travellerRequest) {
		Traveller traveller=new Traveller();
		traveller.setTravellerId(travellerRequest.getTravellerId());
		traveller.setTravellerName(travellerRequest.getTravellerName());
		traveller.setTravellerEmail(travellerRequest.getTravellerEmail());
		traveller.setTravellerAddress(travellerRequest.getTravellerAddress());
		traveller.setTravellerPassword(travellerRequest.getTravellerPassword());
		traveller.setBooks(travellerRequest.getBooks());
		
	       Traveller traveller1=repo.save(traveller);
		
		
		TravellerResponse response=new TravellerResponse();
		
		response.setTravellerId(traveller1.getTravellerId());
		response.setTravellerName(traveller1.getTravellerName());
		response.setTravellerEmail(traveller1.getTravellerEmail());
		response.setTravellerAddress(traveller1.getTravellerAddress());
		response.setTravellerPassword(traveller1.getTravellerPassword());
		response.setBooks(traveller1.getBooks());
		
		ResponseStructure<TravellerResponse> structure=new ResponseStructure<TravellerResponse>();
		structure.setData(response);
		structure.setMessage("traveller data saved");
		structure.setStatus(HttpStatus.OK.value());
		
	return new ResponseEntity<ResponseStructure<TravellerResponse>>(structure,HttpStatus.CREATED);
		}

	@Override
	public ResponseEntity<ResponseStructure<TravellerResponse>> updateTravellerById(TravellerRequest travellerRequest,
			int travellerId) {
		
		Traveller traveller=repo.getById(travellerId);
		if(traveller!=null) {
			traveller.setTravellerId(travellerRequest.getTravellerId());
			traveller.setTravellerName(travellerRequest.getTravellerName());
			traveller.setTravellerEmail(travellerRequest.getTravellerEmail());
			traveller.setTravellerAddress(travellerRequest.getTravellerAddress());
			traveller.setTravellerPassword(travellerRequest.getTravellerPassword());
			traveller.setBooks(travellerRequest.getBooks());
			
		       Traveller traveller1=repo.save(traveller);
			
			
			TravellerResponse response=new TravellerResponse();
			
			response.setTravellerId(traveller1.getTravellerId());
			response.setTravellerName(traveller1.getTravellerName());
			response.setTravellerEmail(traveller1.getTravellerEmail());
			response.setTravellerAddress(traveller1.getTravellerAddress());
			response.setTravellerPassword(traveller1.getTravellerPassword());
			response.setBooks(traveller1.getBooks());
			
			ResponseStructure<TravellerResponse> structure=new ResponseStructure<TravellerResponse>();
			structure.setData(response);
			structure.setMessage("traveller data updated");
			structure.setStatus(HttpStatus.OK.value());
			
		return new ResponseEntity<ResponseStructure<TravellerResponse>>(structure,HttpStatus.OK);
			
		}
		else
		{
			throw new TravellerNotFoundException("traveller not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<TravellerResponse>> findTravellerById(int travellerId) {
		Traveller traveller=repo.getById(travellerId);
		if(traveller!=null)
		{
			TravellerResponse response=new TravellerResponse();
			response.setTravellerId(traveller.getTravellerId());
			response.setTravellerName(traveller.getTravellerName());
			response.setTravellerEmail(traveller.getTravellerEmail());
			response.setTravellerAddress(traveller.getTravellerAddress());
			response.setTravellerPassword(traveller.getTravellerPassword());
			response.setBooks(traveller.getBooks());
			
			ResponseStructure<TravellerResponse> structure=new ResponseStructure<TravellerResponse>();
			structure.setData(response);
			structure.setMessage("traveller data updated");
			structure.setStatus(HttpStatus.OK.value());
			
		return new ResponseEntity<ResponseStructure<TravellerResponse>>(structure,HttpStatus.OK);
			
		}
		else
		{
			throw new TravellerNotFoundException("traveller not found");
		}
			
		
			
	}

	@Override
	public ResponseEntity<ResponseStructure<List<TravellerResponse>>> findAllTravellers() {
		List<Traveller> travellers = repo.findAll();
		List<TravellerResponse> responses=new ArrayList<TravellerResponse>();
		for(Traveller traveller:travellers)
		{
			TravellerResponse response=new TravellerResponse();
			response.setTravellerId(traveller.getTravellerId());
			response.setTravellerName(traveller.getTravellerName());
			response.setTravellerEmail(traveller.getTravellerEmail());
			response.setTravellerAddress(traveller.getTravellerAddress());
			response.setTravellerPassword(traveller.getTravellerPassword());
			response.setBooks(traveller.getBooks());
			
			responses.add(response);
			
			
		}
			
			ResponseStructure<List<TravellerResponse>> structure=new ResponseStructure<List<TravellerResponse>>();
			structure.setData(responses);
			structure.setMessage("traveller data updated");
			structure.setStatus(HttpStatus.OK.value());
			
		return new ResponseEntity<ResponseStructure<List<TravellerResponse>>>(structure,HttpStatus.OK);
			
			
		}
		
	

	@Override
	public ResponseEntity<ResponseStructure<TravellerResponse>> deleteTravellerById(int travellerId) {
		Traveller traveller=repo.getById(travellerId);
		if(traveller!=null)
		{
	    repo.deleteById(traveller.getTravellerId());
	    
	    ResponseStructure<TravellerResponse> structure=new ResponseStructure<TravellerResponse>();
		structure.setData(null);
		structure.setMessage("traveller data updated");
		structure.setStatus(HttpStatus.OK.value());
		
	   return new  ResponseEntity<ResponseStructure<TravellerResponse>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new TravellerNotFoundException("traveller not found");
		}
	
		
	}

}
