package com.demo.spring.Application.controller;

import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.spring.Application.model.Airport;
import com.demo.spring.Application.model.Passengers;
import com.demo.spring.Application.repository.PassengersRepository;





@RestController
@RequestMapping("/api/v2")
public class PassengerController {
	 private static final Log logger = LogFactory.getLog(PassengerController.class);
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private PassengersRepository passengersRepository;
    
    @PostMapping("/passengers/addOne")
    public Passengers addPassengers(@RequestBody Passengers passengers) {
    	logger.info("Passengers : " + passengers);
    	validateParams(passengers.getPassengerName(), passengers.getContactNo());
    	return passengersRepository.save(passengers);
    }
    
    @PostMapping("/passengers/delOne")
    public void deletePassengers(@RequestBody Passengers passengers) {
    	passengersRepository.deleteById(passengers.getPassengerID());
    }
    
    @PostMapping("/passengers/updateBy")
    public void updateByPassengerID(@RequestBody Passengers passengers) {
    	logger.info("Passengers : " + passengers);
    	validateParams(passengers.getPassengerName(), passengers.getContactNo());
    	Optional<Passengers> passengers_op = passengersRepository.findById(passengers.getPassengerID());
    	if (passengers_op.isPresent()) {
    		Passengers passengersDB = passengers_op.get();
    		passengersDB.setContactNo(passengers.getContactNo());
    		passengersDB.setPassengerName(passengers.getPassengerName());
        	// spring data save() method will help you to perform both: 
            // adding new item and updating an existed item.	
        	passengersRepository.save(passengersDB);
    	}
    	
    }
    
    @GetMapping("/Passengers/getAll")
    public List<Passengers> getAll() {
    	return passengersRepository.findAll();
    }
    
    private void validateParams(String name,
            String phone) {
		if (!StringUtils.hasLength(name) || !StringUtils.hasLength(phone)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passenger name / contact\r\n" + 
					"number must be provided");
		}
		
		if (!name.matches(environment.getProperty("regex.name"))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid passenger name contains numbers or special characters");
		}
		// The contact number should be 10 digits.
		if (!phone.matches("^[0-9]{10}$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The passenger contact number should be 10 digits");
		}
		
		logger.debug("Passengers -> Valid params given");
    }
}
