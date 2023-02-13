package com.demo.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Airport;

//Directly invoking a service instance
@FeignClient(name="airports-service")
public interface AirportProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();
	@PostMapping("/api/v2/airport/getOne/{airportCode}")
	public Airport findByAirportCode(@PathVariable(value = "airportCode") String airportCode); 
}