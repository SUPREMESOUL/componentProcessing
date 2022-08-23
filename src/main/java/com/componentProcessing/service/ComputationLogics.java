package com.componentProcessing.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.componentProcessing.Dao.ProcessRequestRepo;
import com.componentProcessing.Models.ProcessRequest;
import com.componentProcessing.Models.ProcessResponse;
import com.componentProcessing.Openfeign.PackingAndDeliveryProxy;
import com.componentProcessing.pojo.RepairData;
import com.componentProcessing.pojo.ReplacementData;
import com.componentProcessing.pojo.RunnerHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ComputationLogics {
	@Autowired
	public RepairData repair;
	
	@Autowired
	public ReplacementData replacement;

	@Autowired
	public ProcessRequestRepo repo;
	
	@Autowired
	private PackingAndDeliveryProxy pdproxy;
	
	
	public ProcessResponse getTheComputation(ProcessRequest request) {
		RunnerHelper runner;
	    ProcessResponse processResponse;
		double packagingAndDeliveryCharge;
		Date dateOfDelivery = new Date();
		Calendar calender = Calendar.getInstance();
		
		if(request.getQuantity()<0) {
			log.error("Quantity getting from front client is less than 1");
			throw new InvalidRequestDetails("Invalid Quantity(less than 1)");
		}
		
		
		calender.setTime(dateOfDelivery);
		switch(request.getComponentType().toLowerCase()) {
		case "integral":
			runner=new RunnerHelper(repair);
			
			break;
		case "accessory":
			runner=new RunnerHelper(replacement);
			
		
			
			break;
		default:
			log.warn("Entered invalid Component type");
			throw new InvalidRequestDetails("Invalid Component");
		}
		
		request = repo.save(request);
		
			log.debug("order request is saved");
		
		log.info("Fetching package and shipping charges from PandD Feign Client");
		packagingAndDeliveryCharge = pdproxy
				. getAllCharges(request.getComponentType(), request.getQuantity()).getBody();
		
		
		log.info("packagingAndDeliveryCharge is {}", packagingAndDeliveryCharge);
		
		
		log.info("runner processing days are {}", runner.getProcessingDays());
		log.info("runner processing amount is {}",runner.getProcessingAmount());
		//System.out.println(  runner.getProcessingDays());
		calender.add(Calendar.DATE,  runner.getProcessingDays());
		dateOfDelivery = calender.getTime();
		
		 processResponse = new ProcessResponse(request.getRequestId(),
				request.getQuantity() *  runner.getProcessingAmount(), packagingAndDeliveryCharge,dateOfDelivery);
		
		
		
		
		
		

	
		//log.debug("order request is saved");
		//log.info("Fetching package and shipping charges from PandD Feign Client");

	//	double panddcharges = pdproxy
				//. getAllCharges(request.getComponentType(), request.getQuantity()).getBody();
		//log.info("Fetching package and shipping charges from PandD Feign Client");
		//ProcessResponse processResponse = new ProcessResponse(request.getRequestId(),
			//	request.getQuantity() * repairReplacement.getProcessingAmount(), panddcharges,dateOfDelivery);

		//.save(processResponse);
		//log.debug("Stored the order Response");

		return processResponse;
		
		
		
		
		
		
	}
	
}
