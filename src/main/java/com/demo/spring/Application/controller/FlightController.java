package com.demo.spring.Application.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Flight;
import com.demo.spring.Application.repository.FlightRepository;




@RestController
@RequestMapping("/api/v2")
public class FlightController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private FlightRepository flightRepository;
    
    @PostMapping("/flight/addOne")
    public Flight addFlight(@RequestBody Flight flight) {
    	return flightRepository.save(flight);
    }
    
    @PostMapping("/flight/delByScheduleId")
    public void deleteAirport(@RequestBody Flight flight) {
    	flightRepository.deleteByScheduleId(flight.getScheduleId());
    }
    
    @PostMapping("/flight/getByScheduleId/{scheduleId}")
    public Flight getByScheduleId(@PathVariable(value="scheduleId") String scheduleId) {
    	return flightRepository.findByScheduleId(scheduleId);
    }
    
    @PostMapping("/flight/getByPlaneRegNo/{planeRegNo}")
    public Flight getByPlaneRegNo(@PathVariable(value="planeRegNo") String planeRegNo) {
    	return flightRepository.findByPlaneRegNo(planeRegNo);
    }
    
    @PostMapping("/flight/getBySourceAndDestination/{source}/{destination}")
    public List<Flight> getBySourceAndDestination(@PathVariable(value="source") String source, @PathVariable(value="destination") String destination) {
    	return flightRepository.findByDepartCountryAndDestCountry(source, destination);
    }
    
    @GetMapping("/flight/getAll")
    public List<Flight> getAll() {
    	return flightRepository.findAll();
    }
}
