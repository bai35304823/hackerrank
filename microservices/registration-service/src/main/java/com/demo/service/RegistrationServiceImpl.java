package com.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;
import com.demo.spring.Application.util.Crypt;


//https://stackoverflow.com/questions/16351780/where-should-service-annotation-be-kept-interface-or-implementation
//@Service on Concrete Classes for SpringBootApplication
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Resource
	RegistrationRepository registrationRepository;
	@Autowired
	private Environment environment;

	@Override
	public Registration save(Registration registration) {
		byte[] salt = Crypt.generateSalt();
		registration.setSalt(salt);
		registration.setPassword(Crypt.hashWithPBKDF2(registration.getPassword(), salt));
		return registrationRepository.save(registration);
	}

	public Registration findByEmail(String email) {
		return registrationRepository.findByEmail(email);
	}

	@Override
	public Registration findByEmailAndPassword(String email, String password) {
		return null;
	}

	@Override
	public Boolean isValidUser(String email, String password) {
		Registration registration = findByEmail(email);
		if (Objects.isNull(registration)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email address cannot be found");
		}
		disbaleAccount(registration);
		boolean authenticated = StringUtils.equalsIgnoreCase(Crypt.hashWithPBKDF2(password, registration.getSalt()),
				registration.getPassword());

		if (authenticated) {
			registration.setAccessCount(0);
		} else {
			if (registration.getAccessCount() >= 3) {
				registration.setAccessCount(0);
			}
			registration.setAccessCount(registration.getAccessCount() + 1);
		}
		registration.setAccessTime(new Timestamp(System.currentTimeMillis()));
		registrationRepository.save(registration);

		disbaleAccount(registration);
		return authenticated;
	}

	private void disbaleAccount(Registration registration) {
		if (registration.getAccessCount() == Long.parseLong(environment.getProperty("max.try.count"))
				&& registration.getAccessTime().toLocalDateTime()
						.plusMinutes(Long.parseLong(environment.getProperty("invalid.login.disabled.minutes")))
						.isAfter(LocalDateTime.now())) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The account has been disabled.");
		}
	}
}
