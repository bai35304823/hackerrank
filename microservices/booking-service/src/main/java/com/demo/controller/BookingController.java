package com.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.demo.entity.Booking;
import com.demo.proxy.FlightProxy;
import com.demo.proxy.PassengersProxy;
import com.demo.repository.BookingRepository;

@RestController
@RequestMapping("/api/v2")
public class BookingController {
	private static final Log logger = LogFactory.getLog(BookingController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private PassengersProxy passengersProxy;
	@Autowired
	private FlightProxy flightProxy;

	@PostMapping("/booking/addOne")
	public Booking addBooking(@RequestBody Booking booking) {
		logger.info("Booking :  " + booking);
		validateParams(booking);
		booking.setPassengers(passengersProxy.findByPassengerID(booking.getPassengerId()));
		booking.setFlight(flightProxy.getByScheduleId(booking.getScheduleId()));
		Booking book = bookingRepository.save(booking);
		book.setBookingId(new StringBuffer(environment.getProperty("booking.prefix"))
				.append(StringUtils.leftPad(String.valueOf(book.getId()), 4, "0")).toString());
		logger.info("New generated booking id -> " + book.getBookingId());
		return bookingRepository.save(book);
	}

	@PostMapping("/booking/delOne")
	@Transactional
	public ResponseEntity<String> deleteBooking(@RequestBody Booking booking) {
		validateParams(booking.getBookingId());
		bookingRepository.deleteByBookingId(booking.getBookingId());
		return ResponseEntity.status(HttpStatus.OK).body("Delete success for Booking " + booking.getBookingId());
	}

	@PostMapping("/booking/getOne/{bookingId}")
	public Booking getByBookingId(@PathVariable(value = "bookingId") String bookingId) {
		Booking book = bookingRepository.findByBookingId(bookingId);
		if (Objects.isNull(book)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The booking cannot be found!");
		}
		return book;
	}

	@PostMapping("/booking/getByBookingDate/{bookingDate}")
	public List<Booking> getByDateOfFlight(
			@PathVariable(value = "bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dateOfFlight) {
		List<Booking> book = bookingRepository.findByDateOfFlight(java.sql.Date.valueOf(dateOfFlight));
		if (Objects.isNull(book)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The booking cannot be found!");
		}
		return book;
	}

	@GetMapping("/booking/getAll")
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	private void validateParams(String booking) {
		if (StringUtils.isEmpty(booking)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The booking code" + " must be provided");
		}

		if (Objects.isNull(bookingRepository.findByBookingId(booking))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The booking cannot be found!");
		}
		logger.debug("Booking -> Valid params given");
	}

	private void validateParams(Booking booking) {
		if (StringUtils.isEmpty(booking.getPassengerId()) || StringUtils.isEmpty(booking.getScheduleId())
				|| Objects.isNull(booking.getDateOfFlight()) || Objects.isNull(booking.getTicketCost())
				|| Objects.isNull(booking.getTotalAmt())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The passenger id/schedule id/booking date/seat number/ ticket\r\n" + "cost and total amount"
							+ " must be provided");
		}

		if (booking.getDateOfFlight().toLocalDate().isBefore(LocalDate.now())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The booking date is in the past");
		}

		if (!booking.getPassengerId().matches("^[a-zA-Z0-9]*$") || !booking.getScheduleId().matches("^[a-zA-Z0-9]*$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The passenger/schedule id should be letters or digits");
		}

		if (Objects.isNull(passengersProxy.findByPassengerID(booking.getPassengerId()))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The passenger cannot be found!");
		}

		if (Objects.isNull(flightProxy.getByScheduleId(booking.getScheduleId()))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The schedule cannot be found!");
		}
		logger.debug("Booking -> Valid params given");
	}
}
