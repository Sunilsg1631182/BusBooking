package com.jsp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dto.RideRequest;
import com.jsp.dto.RideResponse;
import com.jsp.entity.Ride;
import com.jsp.exception.RideNotFoundException;
import com.jsp.repo.RideRepo;
import com.jsp.service.RideService;
import com.jsp.util.ResponseStructure;
@Service
public class RideServiceImpl implements RideService  {
	
	@Autowired
	RideRepo repo;
	
	    public ResponseEntity<ResponseStructure<RideResponse>> saveRide(RideRequest rideRequest){
	    	Ride ride=new Ride();
	    	ride.setRideId(rideRequest.getRideId());
	    	ride.setRideStartDateTime(rideRequest.getRideStartDateTime());
	    	ride.setRideEndDateTime(rideRequest.getRideEndDateTime());
	    	ride.setBookings(rideRequest.getBookings());
	    	ride.setBus(rideRequest.getBus());
	    	
	        Ride ride1=repo.save(ride);
	        
	        RideResponse response=new RideResponse();
	        
	        response.setRideId(ride1.getRideId());
	    	response.setRideStartDateTime(ride1.getRideStartDateTime());
	    	response.setRideEndDateTime(ride1.getRideEndDateTime());
	    	response.setBookings(ride1.getBookings());
	    	response.setBus(ride1.getBus());
	    	
	    	ResponseStructure<RideResponse> structure=new ResponseStructure<RideResponse>();
	    	structure.setData(response);
	    	structure.setMessage("ride data saved");
	    	structure.setStatus(HttpStatus.CREATED.value());
	    	
	    return new ResponseEntity<ResponseStructure<RideResponse>>(structure,HttpStatus.CREATED);
	    	
	    }
		
		public ResponseEntity<ResponseStructure<RideResponse>> updateRideById(RideRequest rideRequest,int rideId)
		{
		  Ride ride=repo.getById(rideId);
		
		 if(ride!=null)
		 {
		  ride.setRideId(rideRequest.getRideId());
		  ride.setRideStartDateTime(rideRequest.getRideStartDateTime());
		  ride.setRideEndDateTime(rideRequest.getRideEndDateTime());
    	  ride.setBookings(rideRequest.getBookings());
    	  ride.setBus(rideRequest.getBus());
    	
          Ride ride1=repo.save(ride);
        
          RideResponse response=new RideResponse();
        
          response.setRideId(ride1.getRideId());
    	  response.setRideStartDateTime(ride1.getRideStartDateTime());
    	  response.setRideEndDateTime(ride1.getRideEndDateTime());
    	  response.setBookings(ride1.getBookings());
    	  response.setBus(ride1.getBus());
    	
    	   ResponseStructure<RideResponse> structure=new ResponseStructure<RideResponse>();
    	    structure.setData(response);
    	    structure.setMessage("ride data updated");
    	     structure.setStatus(HttpStatus.OK.value());
    	
        return new ResponseEntity<ResponseStructure<RideResponse>>(structure,HttpStatus.OK);
        
		}
		else
		{
			throw new RideNotFoundException("Ride not found");
		}
    }
		
		public ResponseEntity<ResponseStructure<RideResponse>> findRideById(int rideId)
		{
			Ride ride=repo.getById(rideId);
			if(ride!=null) {
				
				  RideResponse response=new RideResponse();
		        
		            response.setRideId(ride.getRideId());
		    	    response.setRideStartDateTime(ride.getRideStartDateTime());
		    	    response.setRideEndDateTime(ride.getRideEndDateTime());
		    	    response.setBookings(ride.getBookings());
		    	    response.setBus(ride.getBus());
		    	
		    	    ResponseStructure<RideResponse> structure=new ResponseStructure<RideResponse>();
		    	    structure.setData(response);
		    	    structure.setMessage("ride data found");
		    	    structure.setStatus(HttpStatus.FOUND.value());
		    	
		        return new ResponseEntity<ResponseStructure<RideResponse>>(structure,HttpStatus.OK);
				 }
			else
			{
				throw new RideNotFoundException("Ride not found");
			}
		}
		
	public ResponseEntity<ResponseStructure<List<RideResponse>>> findAllRides(){
		
		  List<Ride> rides=repo.findAll();
		  List<RideResponse> responses=new ArrayList<>();
		  
	
		  for(Ride ride:rides)
		  {
			RideResponse response=new RideResponse();
			
			 
	            response.setRideId(ride.getRideId());
	    	    response.setRideStartDateTime(ride.getRideStartDateTime());
	    	    response.setRideEndDateTime(ride.getRideEndDateTime());
	    	    response.setBookings(ride.getBookings());
	    	    response.setBus(ride.getBus());
	    	    
	    	    responses.add(response);
		  }
		  
		  ResponseStructure<List<RideResponse>> structure=new ResponseStructure<List<RideResponse>>();
  	       structure.setData(responses);
  	       structure.setMessage("ride data found");
  	       structure.setStatus(HttpStatus.FOUND.value());

	    return new ResponseEntity<ResponseStructure<List<RideResponse>>>(structure,HttpStatus.OK);
	}
		   
			
		
		public ResponseEntity<ResponseStructure<RideResponse>> deleteRideById(int rideId){
			Ride ride=repo.getById(rideId);
			if(ride!=null)
			{
				repo.deleteById(ride.getRideId());
				
				ResponseStructure<RideResponse> structure=new ResponseStructure<RideResponse>();
		  	       structure.setData(null);
		  	       structure.setMessage("ride data deleted");
		  	       structure.setStatus(HttpStatus.OK.value());

			    return new ResponseEntity<ResponseStructure<RideResponse>>(structure,HttpStatus.OK);
				
			}
			else
			{
				throw new RideNotFoundException("Ride not found");
			}
		}

}
