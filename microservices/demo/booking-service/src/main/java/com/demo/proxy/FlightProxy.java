package com.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Flight;

//Directly invoking a service instance
@FeignClient(name="schedule-service")
public interface FlightProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();
	@PostMapping("/api/v2/flight/getByScheduleId/{scheduleId}")
	public Flight getByScheduleId(@PathVariable(value = "scheduleId") String scheduleId); 
}