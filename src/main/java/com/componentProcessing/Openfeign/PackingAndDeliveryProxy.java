package com.componentProcessing.Openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*@FeignClient(name="packagingAndDelivery",url="localhost:8001")*/
@FeignClient(name="packagingAndDelivery")
public interface PackingAndDeliveryProxy {

	
	
	@GetMapping(path="/packdelivery")
	public ResponseEntity<Double> getAllCharges(@RequestParam String componentType ,@RequestParam int quantity);
}
