package com.componentProcessing.pojo;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;




@Component
@Data
@NoArgsConstructor
public class ReplacementData implements Service {

	private int processingDays=2;
	private double processingAmount=300;
	
	
	
	
}
