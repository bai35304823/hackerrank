package com.demo.controller;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.entity.Passengers;
import com.demo.repository.PassengersRepository;

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
		Passengers passenger = passengersRepository.save(passengers);
		passenger.setPassengerID(new StringBuffer(environment.getProperty("passenger.prefix"))
				.append(StringUtils.leftPad(String.valueOf(passenger.getId()), 4, "0")).toString());
		logger.info("New generated passenger id -> " + passenger.getPassengerID());
		return passengersRepository.save(passenger);
	}
	@PostMapping("/passengers/getOne/{passengerID}")
	public Passengers getByPassengerID(@PathVariable(value = "passengerID") String passengerID) {
		return passengersRepository.findByPassengerID(passengerID);
	}
	
	@PostMapping("/passengers/updateBy")
	public Passengers updateByPassengerID(@RequestBody Passengers passengers) {
		logger.info("Passengers : " + passengers);
		validateParams(passengers.getPassengerName(), passengers.getContactNo());
		Passengers passengers_db = passengersRepository.findByPassengerID(passengers.getPassengerID());

		if (Objects.isNull(passengers_db)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The passengers cannot found");
		}

		passengers_db.setContactNo(passengers.getContactNo());
		passengers_db.setPassengerName(passengers.getPassengerName());
		// spring data save() method will help you to perform both:
		// adding new item and updating an existed item.
		return passengersRepository.save(passengers_db);

	}

	@GetMapping("/passengers/getAll")
	public List<Passengers> getAll() {
		return passengersRepository.findAll();
	}

	private void validateParams(String name, String phone) {
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(phone)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Passenger name / contact\r\n" + "number must be provided");
		}

		if (!name.matches(environment.getProperty("regex.name"))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Invalid passenger name contains numbers or special characters");
		}
		// The contact number should be 10 digits.
		if (!phone.matches("^[0-9]{10}$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The passenger contact number should be 10 digits");
		}

		logger.debug("Passengers -> Valid params given");
	}
}
