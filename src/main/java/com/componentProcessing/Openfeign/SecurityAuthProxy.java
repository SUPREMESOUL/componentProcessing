package com.componentProcessing.Openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="securityAuth")
public interface SecurityAuthProxy {
     
	
	@GetMapping("/validate")
	 public boolean validateToken(@RequestHeader(value="Authorization") String token);
}
