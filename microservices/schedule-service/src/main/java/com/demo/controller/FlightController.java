package com.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
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

import com.demo.entity.Flight;
import com.demo.entity.Plane;
import com.demo.proxy.AirportProxy;
import com.demo.proxy.CountryProxy;
import com.demo.proxy.PlaneProxy;
import com.demo.repository.FlightRepository;

@RestController
@RequestMapping("/api/v2")
public class FlightController {
	private static final Log logger = LogFactory.getLog(FlightController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private PlaneProxy planeProxy;
	@Autowired
	private AirportProxy airportProxy;
	@Autowired
	private CountryProxy countryProxy;

	@PostMapping("/flight/addOne")
	public Flight addFlight(@RequestBody Flight flight) {
		logger.info("Schedule :  " + flight);
		validateParams(flight.getDepartCountryId(), flight.getDepartAirportCode(), flight.getDestCountryId(),
				flight.getDestAirportCode(), flight.getDepartureTime(), flight.getArrivalTime());
		flight.setDepartCountry(countryProxy.findByCountryId(flight.getDepartCountryId()));
		flight.setDepartAirport(airportProxy.findByAirportCode(flight.getDepartAirportCode()));
		flight.setDestCountry(countryProxy.findByCountryId(flight.getDestCountryId()));
		flight.setDestAirport(airportProxy.findByAirportCode(flight.getDestAirportCode()));
		flight.setPlane(planeProxy.findByPlaneRegNo(flight.getPlaneRegNo()));
		Flight flight_db = flightRepository.save(flight);
		flight_db.setScheduleId(new StringBuffer(environment.getProperty("schedule.prefix"))
				.append(StringUtils.leftPad(String.valueOf(flight_db.getId()), 4, "0")).toString());
		logger.info("New generated schedule id -> " + flight.getScheduleId());
		return flightRepository.save(flight_db);
	}

	@PostMapping("/flight/delByScheduleId")
	@Transactional
	public ResponseEntity<String> deleteFlightByScheduleId(@RequestBody Flight flight) {
		validateParams(flight.getScheduleId());
		flightRepository.deleteByScheduleId(flight.getScheduleId());
		return ResponseEntity.status(HttpStatus.OK).body("Delete success for Schedule " + flight.getScheduleId());
	}

	@PostMapping("/flight/getByScheduleId/{scheduleId}")
	public Flight getByScheduleId(@PathVariable(value = "scheduleId") String scheduleId) {
		return flightRepository.findByScheduleId(scheduleId);
	}

	@PostMapping("/flight/getByPlaneRegNo/{planeRegNo}")
	public List<Flight> getByPlaneRegNo(@PathVariable(value = "planeRegNo") String planeRegNo) {
		Plane plane = planeProxy.findByPlaneRegNo(planeRegNo);
		if (Objects.isNull(plane)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The plane cannot found");
		}
		return flightRepository.findByPlaneRegNo(planeRegNo);
	}

	@PostMapping("/flight/getBySourceAndDestination/{source}/{destination}")
	public List<Flight> getBySourceAndDestination(@PathVariable(value = "source") String source,
			@PathVariable(value = "destination") String destination) {
		return flightRepository.findByDepartCountryAndDestCountry(countryProxy.findByCountryId(source),
				countryProxy.findByCountryId(destination));
	}

	@PostMapping("/flight/updateByScheduleNumber")
	public Flight updateByScheduleNumber(@RequestBody Flight flight) {
		logger.info("Schedule :  " + flight);
		validateParams(flight.getDepartCountryId(), flight.getDepartAirportCode(), flight.getDestCountryId(),
				flight.getDestAirportCode(), flight.getDepartureTime(), flight.getArrivalTime());
		Flight flightDB = flightRepository.findByScheduleId(flight.getScheduleId());
		if (Objects.isNull(flightDB)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Schedule cannot found");
		}
		flightDB.setDepartCountry(countryProxy.findByCountryId(flight.getDepartCountryId()));
		flightDB.setDepartAirport(airportProxy.findByAirportCode(flight.getDepartAirportCode()));
		flightDB.setDestCountry(countryProxy.findByCountryId(flight.getDestCountryId()));
		flightDB.setDestAirport(airportProxy.findByAirportCode(flight.getDestAirportCode()));
		flightDB.setDepartureTime(flight.getDepartureTime());
		flightDB.setArrivalTime(flight.getArrivalTime());
		// spring data save() method will help you to perform both:
		// adding new item and updating an existed item.
		return flightRepository.save(flightDB);
	}

	@GetMapping("/flight/getAll")
	public List<Flight> getAll() {
		return flightRepository.findAll();
	}

	private void validateParams(String departure, String departureAirport, String arrival, String destAirport,
			Timestamp departureDateTime, Timestamp arrivalDateTime) {
		if (StringUtils.isEmpty(departure) || StringUtils.isEmpty(departureAirport) || StringUtils.isEmpty(arrival)
				|| StringUtils.isEmpty(destAirport)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The country code/airport code" + " must be provided");
		}

		if (!departure.matches("^[a-zA-Z0-9]{1,5}$") || !arrival.matches("^[a-zA-Z0-9]{1,5}$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The country code should be minimum 1 character and maximum 5 characters");
		}

		if (!departureAirport.matches("^[a-zA-Z0-9]*$") || !destAirport.matches("^[a-zA-Z0-9]*$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The airport code should be letters or digits");
		}

		if (departureDateTime == null || arrivalDateTime == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departure/arrival date-times must be provided");
		}

		if (departure == null || arrival == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid departure or arrival codes");
		}

		LocalDate today = LocalDate.now();
		if (departureDateTime.toLocalDateTime().toLocalDate().isBefore(today)) {
			// Use date instead of date-time as if the user submits the current minute, it
			// may be a valid request
			// but by the time this code is reached, LocalDateTime.now() might be in the
			// next minute. This will happen
			// much less with LocalDate and only potentially near when midnight occurs.
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departure date is in the past");
		}

		if (departure.toUpperCase().equals(arrival.toUpperCase())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departure and arrival codes are the same");
		}

		// There was previously a condition here that
		// arrivalDateTime.isAfter(departureDateTime), but as they are
		// *local* time-zones for each airport, it is possible that local time at
		// arrival can be before the local time
		// you departed at. Eg if a flight takes 30 minutes but you fly into a timezone
		// 1 hour earlier than the departure
		// airport's timezone.

		logger.debug("Valid params given");
	}

	private void validateParams(String scheduleId) {
		if (StringUtils.isEmpty(scheduleId)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The schedule Id" + " must be provided");
		}

		if (Objects.isNull(getByScheduleId(scheduleId))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The schedule cannot be found!");
		}
		logger.debug("Flight -> Valid params given");
	}
}
