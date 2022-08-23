package com.componentProcessing.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.componentProcessing.Dao.ProcessRequestRepo;
import com.componentProcessing.Models.ProcessRequest;
import com.componentProcessing.Models.ProcessResponse;
import com.componentProcessing.Openfeign.SecurityAuthProxy;
import com.componentProcessing.service.ComputationLogics;

@RestController
@CrossOrigin
public class AllController {
	
	
	@Autowired
	public ComputationLogics logics;
	
	@Autowired
	private SecurityAuthProxy securityproxy;
	
	
	
	
	@GetMapping(path="/hell")
	public String hello() {
		return "got it bro";
	}
	//@Crossorigin
	@GetMapping("/processingcoms")
	public ResponseEntity<ProcessResponse> processing(@RequestHeader("Authorization") String authToken,ProcessRequest request) {
	
		
		securityproxy.validateToken(authToken);
		ProcessResponse response=logics.getTheComputation(request);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}

}
