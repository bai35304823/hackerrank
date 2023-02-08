package com.demo.spring.Application.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.spring.Application.model.Airport;
import com.demo.spring.Application.model.Flight;
import com.demo.spring.Application.repository.FlightRepository;




@RestController
@RequestMapping("/api/v2")
public class FlightController {
	 private static final Log logger = LogFactory.getLog(FlightController.class);
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private FlightRepository flightRepository;
    
    @PostMapping("/flight/addOne")
    public Flight addFlight(@RequestBody Flight flight) {
    	logger.info("Schedule :  " + flight);
    	validateParams(flight.getDepartCountry(), flight.getDestCountry(),flight.getDepartureTime(), flight.getArrivalTime());	
    	Flight flight_db = flightRepository.save(flight);
    	flight_db.setScheduleId(new StringBuffer(environment.getProperty("schedule.prefix")).append(
    			StringUtils.leftPad(String.valueOf(flight_db.getId()), 4, "0")).toString());
    	logger.info("New generated schedule id -> " + flight.getScheduleId());
    	return flightRepository.save(flight_db);
    }
    
    @PostMapping("/flight/delByScheduleId")
    public ResponseEntity<String> deleteFlightByScheduleId(@RequestBody Flight flight) {
    	validateParams(flight.getScheduleId());	
    	flightRepository.deleteByScheduleId(flight.getScheduleId());
    	return ResponseEntity.status(HttpStatus.OK)
    	        .body("Delete success for Schedule " + flight.getScheduleId());
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
    
    
    private void validateParams(String departure,
            String arrival,
            Timestamp departureDateTime,
            Timestamp arrivalDateTime) {
		if (departureDateTime == null || arrivalDateTime == null) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departure/arrival date-times must be provided");
		}
		
		if (departure == null || arrival == null) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid departure or arrival codes");
		}
		
		
		LocalDate today = LocalDate.now();
		if (departureDateTime.toLocalDateTime().toLocalDate().isBefore(today)) {
		// Use date instead of date-time as if the user submits the current minute, it may be a valid request
		// but by the time this code is reached, LocalDateTime.now() might be in the next minute. This will happen
		// much less with LocalDate and only potentially near when midnight occurs.
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departure date is in the past");
		}
		
		if (departure.toUpperCase().equals(arrival.toUpperCase())) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departure and arrival codes are the same");
		}
		
		// There was previously a condition here that arrivalDateTime.isAfter(departureDateTime), but as they are
		// *local* time-zones for each airport, it is possible that local time at arrival can be before the local time
		// you departed at. Eg if a flight takes 30 minutes but you fly into a timezone 1 hour earlier than the departure
		// airport's timezone.
		
		logger.debug("Valid params given");
}
    
    private void validateParams(String scheduleId) {
  		if (StringUtils.isEmpty(scheduleId) ) {
  			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The schedule Id" + 
  					" must be provided");
  		}
  		
  		if (Objects.isNull(getByScheduleId(scheduleId))) {
  			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The schedule cannot be found!");
  		}
  		logger.debug("Flight -> Valid params given");
      }
}
