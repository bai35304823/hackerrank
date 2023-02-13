package com.demo.controller;

import java.util.List;

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

import com.demo.entity.Country;
import com.demo.repository.CountryRepository;

@RestController
@RequestMapping("/api/v2")
public class CountryController {
	private static final Log logger = LogFactory.getLog(CountryController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private CountryRepository countryRepository;

	@PostMapping("/country/addOne")
	public Country addCountry(@RequestBody Country country) {
		logger.info("Country :  " + country);
		validateParams(country.getCountryId(), country.getCountryName());

		return countryRepository.save(country);
	}

	@PostMapping("/country/delOne")
	@Transactional
	public ResponseEntity<String> deleteCountry(@RequestBody Country country) {
		validateParams(country.getCountryId());

		countryRepository.deleteByCountryId(country.getCountryId());

		return ResponseEntity.status(HttpStatus.OK).body("Delete success for Country " + country.getCountryId());
	}

	@PostMapping("/country/getOne/{countryId}")
	public Country getByCountryId(@PathVariable(value = "countryId") String countryId) {
		return countryRepository.findByCountryId(countryId);
	}

	@GetMapping("/country/getAll")
	public List<Country> getAll() {
		return countryRepository.findAll();
	}

	private void validateParams(String countryId, String countryName) {
		if (StringUtils.isEmpty(countryId) || StringUtils.isEmpty(countryName)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The country Id, country name" + " must be provided");
		}

		if (!countryId.matches("^[a-zA-Z0-9]*$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The country Id should be letters or digits");
		}

		if (!countryName.matches("^[ a-zA-Z0-9]*$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The country name should be letters or digits");
		}

		logger.debug("Country -> Valid params given");
	}

	private void validateParams(String countryId) {
		if (StringUtils.isEmpty(countryId)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The country Id" + " must be provided");
		}

		if (!countryId.matches("^[a-zA-Z0-9]*$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The country Id should be letters or digits");
		}
		logger.debug("Country -> Valid params given");
	}
}
