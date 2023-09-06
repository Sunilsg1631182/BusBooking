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

import com.jsp.dto.BusRequest;
import com.jsp.dto.BusResponse;
import com.jsp.service.BusService;
import com.jsp.util.ResponseStructure;

@RestController
public class BusController implements BusService {
	
	@Autowired
	BusService service;

	@PostMapping("/saveBus")
	public ResponseEntity<ResponseStructure<BusResponse>> saveBus(@RequestBody BusRequest busRequest) {
		 return  service.saveBus(busRequest);
	}

	@PutMapping("/update/{busId}")
	public ResponseEntity<ResponseStructure<BusResponse>> updateBusById(@RequestBody BusRequest busRequest,@PathVariable int busId) {
	return service.updateBusById(busRequest, busId);
	}

	@GetMapping("/findBus/{busId}")
	public ResponseEntity<ResponseStructure<BusResponse>> findBusById(@RequestBody int busId) {
		return service.findBusById(busId);
	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<BusResponse>>> findAllBuses() {
		return service.findAllBuses();
	}

     @DeleteMapping("/deleteBus/{busId}")
	public ResponseEntity<ResponseStructure<BusResponse>> deleteBusById(@RequestBody  int busId) {
		return service.deleteBusById(busId);
	}

}
