package com.demo.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Passengers;

//Directly invoking a service instance
@FeignClient(name="passenger-service")
public interface PassengersProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();
	@PostMapping("/api/v2//passengers/getOne/{passengerID}")
	public Passengers findByPassengerID(@PathVariable(value = "passengerID") String passengerID); 
}