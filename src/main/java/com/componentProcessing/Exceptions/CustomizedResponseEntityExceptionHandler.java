package com.componentProcessing.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.componentProcessing.service.InvalidRequestDetails;


public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException
	(Exception ex, WebRequest request) throws Exception {
	
		ExceptionResponse exception=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		 return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(InvalidRequestDetails.class)
	public final ResponseEntity<Object> handleInvalidRequestDetailsException
	(Exception ex, WebRequest request) throws Exception {
	
		ExceptionResponse exception=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		 return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse exception=new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());
		
		return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
}