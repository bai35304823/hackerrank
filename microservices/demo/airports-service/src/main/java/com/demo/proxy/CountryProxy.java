package com.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Country;

//Directly invoking a service instance
@FeignClient(name="country-service")
public interface CountryProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();
	@PostMapping("/api/v2/country/getOne/{countryId}")
	public Country getByCountryId(@PathVariable(value = "countryId") String countryId); 
}