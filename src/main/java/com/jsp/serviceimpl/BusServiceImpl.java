package com.jsp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dto.BusRequest;
import com.jsp.dto.BusResponse;
import com.jsp.entity.Bus;
import com.jsp.exception.BusNotFoundException;
import com.jsp.repo.BusRepo;
import com.jsp.service.BusService;
import com.jsp.util.ResponseStructure;
@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	BusRepo repo;

	@Override
	public ResponseEntity<ResponseStructure<BusResponse>> saveBus(BusRequest busRequest) {
		Bus bus=new Bus();
		bus.setBusId(busRequest.getBusId());
		bus.setBusNumber(busRequest.getBusNumber());
		bus.setRides(busRequest.getRides());
		bus.setSeats(busRequest.getSeats());
		
	     Bus bus1=repo.save(bus);
		
		BusResponse response =new BusResponse();
		response.setBusId(bus1.getBusId());
		response.setBusNumber(bus1.getBusNumber());
		response.setRides(bus1.getRides());
		response.setSeats(bus1.getSeats());
		
		ResponseStructure<BusResponse> structure=new ResponseStructure<BusResponse>();
		structure.setData(response);
		structure.setMessage("bus data saved");
		structure.setStatus(HttpStatus.CREATED.value());
		
	return new	ResponseEntity<ResponseStructure<BusResponse>>(structure,HttpStatus.CREATED);
}

	@Override
	public ResponseEntity<ResponseStructure<BusResponse>> updateBusById(BusRequest busRequest, int busId)
	{
	 Bus bus	= repo.getById(busId);
	    if(bus!=null) {
		bus.setBusId(busRequest.getBusId());
		bus.setBusNumber(busRequest.getBusNumber());
		bus.setRides(busRequest.getRides());
		bus.setSeats(busRequest.getSeats());
		
	     Bus bus1=repo.save(bus);
		
		BusResponse response =new BusResponse();
		response.setBusId(bus1.getBusId());
		response.setBusNumber(bus1.getBusNumber());
		response.setRides(bus1.getRides());
		response.setSeats(bus1.getSeats());
		
		ResponseStructure<BusResponse> structure=new ResponseStructure<BusResponse>();
		structure.setData(response);
		structure.setMessage("bus data updated");
		structure.setStatus(HttpStatus.OK.value());
		
	    return new	ResponseEntity<ResponseStructure<BusResponse>>(structure,HttpStatus.OK);
	   }
	else{
		throw new BusNotFoundException("bus not found");
	}
}

	@Override
	public ResponseEntity<ResponseStructure<BusResponse>> findBusById(int busId) {
		Bus bus=repo.getById(busId);
		if(bus!=null)
		{
		BusResponse response =new BusResponse();
		response.setBusId(bus.getBusId());
		response.setBusNumber(bus.getBusNumber());
		response.setRides(bus.getRides());
		response.setSeats(bus.getSeats());
		
		ResponseStructure<BusResponse> structure=new ResponseStructure<BusResponse>();
		structure.setData(response);
		structure.setMessage("bus data found");
		structure.setStatus(HttpStatus.CREATED.value());
		
		return new	ResponseEntity<ResponseStructure<BusResponse>>(HttpStatus.CREATED);
	}else
	{
		throw new BusNotFoundException("bus not found");
	}
	}
	
	
	@Override
	public ResponseEntity<ResponseStructure<List<BusResponse>>> findAllBuses() {
		List<Bus> buses = repo.findAll();
		List<BusResponse> responses=new ArrayList<>();
		for(Bus bus:buses)
		{
			BusResponse response=new BusResponse();
			
			response.setBusId(bus.getBusId());
			response.setBusNumber(bus.getBusNumber());
			response.setRides(bus.getRides());
			response.setSeats(bus.getSeats());
			
			responses.add(response);
		}
			
			ResponseStructure<List<BusResponse>> structure=new ResponseStructure<List<BusResponse>>();
			structure.setData(responses);
			structure.setMessage("bus data found");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new	ResponseEntity<ResponseStructure<List<BusResponse>>>(HttpStatus.CREATED);
			
		}
		
	

	@Override
	public ResponseEntity<ResponseStructure<BusResponse>> deleteBusById(int busId) {
	Bus bus	=repo.getById(busId);
	if(bus!=null) {
		
		repo.deleteById(bus.getBusId());
		
		ResponseStructure<List<BusResponse>> structure=new ResponseStructure<List<BusResponse>>();
		structure.setData(null);
		structure.setMessage("bus data found");
		structure.setStatus(HttpStatus.CREATED.value());
		
		return new	ResponseEntity<ResponseStructure<BusResponse>>(HttpStatus.CREATED);
		
	}
	else {
		throw new BusNotFoundException("bus not found");
	}
	}
	

}
