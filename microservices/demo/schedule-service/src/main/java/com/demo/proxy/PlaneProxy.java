package com.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Plane;

//Directly invoking a service instance
@FeignClient(name="plane-service")
public interface PlaneProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();
	@PostMapping("/api/v2/plane/getOne/{planeRegNo}")
	public Plane findByPlaneRegNo(@PathVariable(value = "planeRegNo") String planeRegNo); 
}