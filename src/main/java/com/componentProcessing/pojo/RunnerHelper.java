package com.componentProcessing.pojo;

public class RunnerHelper {
	
	private Service service;

	public RunnerHelper(Service service ) {
		this.service=service;
	}

	public int getProcessingDays() {
		
		return service.getProcessingDays();
	}
	
	public double getProcessingAmount() {
		return service.getProcessingAmount();
	}
	
	

}
