package com.demo.spring.Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Airport;
import com.demo.spring.Application.repository.AirportRepository;

@RestController
@RequestMapping("/api/v2")
public class AirportController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private AirportRepository airportRepository;
    
    @PostMapping("/airport/addOne")
    public Airport addAirport(@RequestBody Airport airport) {
    	return airportRepository.save(airport);
    }
    
    @PostMapping("/airport/delOne")
    public void deleteAirport(@RequestBody Airport airport) {
    	airportRepository.deleteById(airport.getAirportCode());
    }
    
    @PostMapping("/airport/getOne/{airportCode}")
    public Airport getOne(@PathVariable(value="airportCode") String airportCode) {
    	return airportRepository.findByAirportCode(airportCode);
    }
    
    @GetMapping("/airport/getAll")
    public List<Airport> getAll() {
    	return airportRepository.findAll();
    }
}
