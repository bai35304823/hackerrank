package com.demo.spring.Application.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Registration;
import com.demo.spring.Application.service.RegistrationService;

@RestController
public class JpaController {
	@Autowired
	private Environment environment;
	@Autowired
	@Lazy
	RegistrationService registrationService;

	@GetMapping("/instance")
	public String getInstancePort() {
		String microservicePort = environment.getProperty("local.server.port");
		return "Microservie running on port : " + microservicePort;
	}

	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/test")
	public String test() {
		return "hello world test";
	}

	@PostMapping("/register")
	public Registration register(@RequestBody Registration registration) {
		return registrationService.save(registration);
	}
	/*
	 * @PostMapping("/authenticate") public boolean authenticate(@RequestBody
	 * Registration registration) { return
	 * registrationService.isValidUser(registration.getEmail(),
	 * registration.getPassword()); }
	 */

}