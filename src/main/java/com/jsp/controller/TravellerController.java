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

import com.jsp.dto.TravellerRequest;
import com.jsp.dto.TravellerResponse;
import com.jsp.service.TravellerService;
import com.jsp.util.ResponseStructure;
@RestController
public class TravellerController  {
	
	@Autowired
	TravellerService service;

@PostMapping("/saveTraveller")
	public ResponseEntity<ResponseStructure<TravellerResponse>> saveTraveller(@RequestBody TravellerRequest travellerRequest) {
		return service.saveTraveller(travellerRequest);
	}

	@PutMapping("/updateTraveller/{travellerId}")
	public ResponseEntity<ResponseStructure<TravellerResponse>> updateTravellerById(@RequestBody TravellerRequest travellerRequest,
		@PathVariable	int travellerId) {
		return service.updateTravellerById(travellerRequest, travellerId);
	}

@GetMapping("/findTraveller/{travellerId}")
	public ResponseEntity<ResponseStructure<TravellerResponse>> findTravellerById(@PathVariable int travellerId) {
		return service.findTravellerById(travellerId);
	}

	@GetMapping("/findAllTravellers")
	public ResponseEntity<ResponseStructure<List<TravellerResponse>>> findAllTravellers() {
		return service.findAllTravellers();
	}

@DeleteMapping("/deleteTraveller/{travellerId}")
	public ResponseEntity<ResponseStructure<TravellerResponse>> deleteTravellerById(@PathVariable int travellerId) {
		return service.deleteTravellerById(travellerId);
	}

}
