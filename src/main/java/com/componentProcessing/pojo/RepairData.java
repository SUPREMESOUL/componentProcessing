package com.componentProcessing.pojo;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class RepairData implements Service{
	
	private int processingDays= 5;
	private double processingAmount=500;
		
}
