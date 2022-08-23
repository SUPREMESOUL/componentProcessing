package com.componentProcessing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.componentProcessing.Models.ProcessRequest;
import com.componentProcessing.Openfeign.PackingAndDeliveryProxy;


//@RunWith(SpringRunner.class)
@SpringBootTest
class ComponentProcessing1ApplicationTests {
	
	
	private ProcessRequest processRequest;    
	
	@Mock
	private PackingAndDeliveryProxy proxy; 

	@Test
	 void isProcessRequestSaved() {
		
		processRequest = new ProcessRequest("HeyUserIamDuplicate", "815487890", "Integral", "Lappy", 5);
	    double ans=(100.0+200.0+50.0)*5;
		Mockito.when(proxy.getAllCharges(processRequest.getComponentType(), processRequest.getQuantity()))
		.thenReturn(new ResponseEntity<>((100.0+200.0+50.0)*processRequest.getQuantity(),HttpStatus.OK));
		
		assertEquals(ans ,proxy.getAllCharges("Integral",5).getBody());
		
		
	}

}
