package com.jsp.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.util.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		// TODO Auto-generated method stub
		List<ObjectError> allErrors = ex.getAllErrors();
		Map<String,String> errors=new HashMap<String,String>();
		for(ObjectError error:allErrors)
		{
			FieldError fieldError=(FieldError)error;
			String message=fieldError.getDefaultMessage();
			String field=fieldError.getField();
			errors.put(field, message);
		}
		
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> busNotFoundById(BusNotFoundException ex)
	{
		
		ErrorStructure structure=new ErrorStructure();
		structure.setRootCause("bus is not present with the request id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> rideNotFoundById(RideNotFoundException ex)
	{
		
		ErrorStructure structure=new ErrorStructure();
		structure.setRootCause("ride is not present with the request id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> seatNotFoundById(SeatNotFoundException ex)
	{
		
		ErrorStructure structure=new ErrorStructure();
		structure.setRootCause("seat is not present with the request id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> travellerNotFoundById(TravellerNotFoundException ex)
	{
		
		ErrorStructure structure=new ErrorStructure();
		structure.setRootCause("traveller is not present with the request id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> bookingNotFoundById(BookingNotFoundException ex)
	{
		
		ErrorStructure structure=new ErrorStructure();
		structure.setRootCause("booking is not present with the request id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.NOT_FOUND);
	}

}
