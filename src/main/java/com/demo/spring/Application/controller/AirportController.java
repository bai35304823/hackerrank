package com.demo.spring.Application.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.spring.Application.model.Airport;
import com.demo.spring.Application.repository.AirportRepository;
import com.demo.spring.Application.repository.CountryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2")
public class AirportController {
	private static final Log logger = LogFactory.getLog(AirportController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private AirportRepository airportRepository;
	@Autowired
	private CountryRepository countryRepository;

	@PostMapping("/airport/addOne")
	public Airport addAirport(@RequestBody Airport airport) {
		logger.info("Airport :  " + airport);
		validateParams(airport.getCountryId(), airport.getAirportName());
		airport.setCountry(countryRepository.findByCountryId(airport.getCountryId()));
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

	@DeleteMapping("/airport/{id}")
    public Airport deleteAirportById(@PathVariable(value = "id") Long idFromClient) {

        Optional<Airport> airportEntityOptional = airportRepository.findById(idFromClient);
        Airport deleteAirport = new Airport();
        if(airportEntityOptional.isPresent()){
             deleteAirport = airportEntityOptional.get();
        }
        airportRepository.delete(deleteAirport);
        return deleteAirport;
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
		airportDB.setCountry(countryRepository.findByCountryId(airport.getCountryId()));
		return airportRepository.save(airportDB);
	}
	
	@PutMapping("/airport/updateById/{id}")
	public Airport updateById(@PathVariable(value = "id") Long id, @RequestBody Airport airport) {
		logger.info("Airport :  " + airport);
		validateParams(airport.getCountryId(), airport.getAirportName());
		Optional<Airport> airportDB = airportRepository.findById(id);
		if (!airportDB.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The airport cannot found");
		}
	
		return airportRepository.save(airport);
	}

	@PostMapping("/airport/getOne/{airportCode}")
	public Airport getByAirportCode(@PathVariable(value = "airportCode") String airportCode) {
		return airportRepository.findByAirportCode(airportCode);
	}
	
	@GetMapping("/airport/getById/{id}")
	public Airport getByAirportCode(@PathVariable(value = "id") Long id) {
		return airportRepository.findById(id).get();
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

		if (!airportName.matches("^[ a-zA-Z0-9]*$")) {
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
