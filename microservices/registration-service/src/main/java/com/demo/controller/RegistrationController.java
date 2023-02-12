package com.demo.controller;

import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;
import com.demo.service.RegistrationService;



@RestController
@RequestMapping("/api/v2")
public class RegistrationController {
	private static final Log logger = LogFactory.getLog(RegistrationController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private RegistrationRepository registrationRepository;

	@GetMapping("/instance")
	public String getInstancePort() {
		String microservicePort = environment.getProperty("local.server.port");
		return "Microservie running on port : " + microservicePort;
	}

	@PostMapping("/registrations/register")
	public Registration createRegistration(@RequestBody Registration registration) {
		logger.info("Registration : " + registration);
		validateParams(registration.getAdminName(), registration.getEmail(), registration.getPassword(),
				registration.getPhone());
		Registration savedRegistration = registrationService.save(registration);
		return savedRegistration;
	}

	@PostMapping("/registrations/{email}/{password}")
	public ResponseEntity<String> authenticate(@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password) {
		Boolean authenticatedBoolean = registrationService.isValidUser(email, password);
		logger.info("Registration Controller - authenticate : " + authenticatedBoolean);
		return ResponseEntity.status(HttpStatus.OK).body(authenticatedBoolean ? "Login success for application."
				: "Invalid email address/password. Maximum of three times to re-enter the "
						+ "credentials, left times : " + (Long.parseLong(environment.getProperty("max.try.count"))
								- registrationRepository.findByEmail(email).getAccessCount()));
	}

	private void validateParams(String adminName, String email, String password, String phone) {
		if (!StringUtils.hasLength(adminName) || !StringUtils.hasLength(email) || !StringUtils.hasLength(password)
				|| !StringUtils.hasLength(phone)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"AdminName/email/password/phone must be provided");
		}

		if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email address");
		}

		if (Objects.nonNull(registrationRepository.findByEmail(email))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email id is already use by some other user");
		}

		if (!adminName.matches(environment.getProperty("regex.name"))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Invalid name contains numbers or special characters");
		}
		/*
		 * (?=.*[0-9]) means that the password must contain a single digit from 1 to 9.
		 * 
		 * 
		 * (?=.*[a-z]) means that the password must contain one lowercase letter.
		 * 
		 * 
		 * (?=.*[A-Z]) means that the password must contain one uppercase letter.
		 * 
		 * 
		 * (?=.*\W) means that the password must contain one special character.
		 */
		if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_])(?!.* ).{8,16}$")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Password should be a combination of at least an uppercase alphabet, lowercase\r\n"
							+ "alphabets, a digit, and a special character");
		}

		if (Objects.nonNull(registrationRepository.findByPhone(phone))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"The phone number is already in use by some other\r\n" + "user");
		}

		logger.debug("Registration -> Valid params given");
	}
}
