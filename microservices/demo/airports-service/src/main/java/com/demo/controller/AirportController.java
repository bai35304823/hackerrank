package com.demo.controller;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.entity.Airport;
import com.demo.proxy.CountryProxy;
import com.demo.repository.AirportRepository;

@RestController
@RequestMapping("/api/v2")
public class AirportController {
	private static final Log logger = LogFactory.getLog(AirportController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private AirportRepository airportRepository;
	@Autowired
	private CountryProxy countryProxy;

	@PostMapping("/airport/addOne")
	public Airport addAirport(@RequestBody Airport airport) {
		logger.info("Airport :  " + airport);
		validateParams(airport.getCountryId(), airport.getAirportName());
		airport.setCountry(countryProxy.getByCountryId(airport.getCountryId()));
		Airport air = airportRepository.save(airport);
		air.setAirportCode(new StringBuffer(environment.getProperty("airport.prefix"))
				.append(StringUtils.leftPad(String.valueOf(air.getId()), 4, "0")).toString());
		logger.info("New generated airport code -> " + airport.getAirportCode());
		return airportRepository.save(air);
	}

	@PostMapping("/airport/delOne")
	@Transactional
	public ResponseEntity<String> deleteAirport(@RequestBody Airport airport) {
		validateParams(airport.getAirportCode());
		airportRepository.deleteByAirportCode(airport.getAirportCode());
		return ResponseEntity.status(HttpStatus.OK).body("Delete success for Airport " + airport.getAirportCode());
	}

	@PostMapping("/airport/updateByAirportCode")
	public Airport updateByAirportCode(@RequestBody Airport airport) {
		logger.info("Airport :  " + airport);
		validateParams(airport.getCountryId(), airport.getAirportName());
		Airport airportDB = airportRepository.findByAirportCode(airport.getAirportCode());
		if (Objects.isNull(airportDB)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The airport cannot found");
		}
		airportDB.setAirportName(airport.getAirportName());
		airportDB.setCountryId(airport.getCountryId());
		// spring data save() method will help you to perform both:
		// adding new item and updating an existed item.
		airportDB.setCountry(countryProxy.getByCountryId(airport.getCountryId()));
		return airportRepository.save(airportDB);
	}

	@PostMapping("/airport/getOne/{airportCode}")
	public Airport getByAirportCode(@PathVariable(value = "airportCode") String airportCode) {
		return airportRepository.findByAirportCode(airportCode);
	}

	@GetMapping("/airport/getAll")
	public List<Airport> getAll() {
		return airportRepository.findAll();
	}

	private void validateParams(String code, String airportName) {
		if (StringUtils.isEmpty(code) || StringUtils.isEmpty(airportName)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The country code/airport name" + " must be provided");
		}

		// The country code should be minimum 1 character and maximum 5 characters
		if (!code.matches("^[a-zA-Z0-9]{1,5}$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The country code should be minimum 1 character and maximum 5 characters");
		}

		if (!airportName.matches("^[a-zA-Z0-9]*$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The airport name should be letters or digits");
		}

		logger.debug("Airport -> Valid params given");
	}

	private void validateParams(String airportCode) {
		if (StringUtils.isEmpty(airportCode)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The airport code" + " must be provided");
		}

		if (Objects.isNull(getByAirportCode(airportCode))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The airport cannot be found!");
		}
		logger.debug("Plane -> Valid params given");
	}
}
