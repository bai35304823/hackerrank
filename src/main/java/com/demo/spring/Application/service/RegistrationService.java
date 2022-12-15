package com.demo.spring.Application.service;

import org.springframework.stereotype.Service;

import com.demo.spring.Application.model.Registration;


public interface RegistrationService {
    Registration save(Registration registration);
    Registration findByEmailAndPassword(String email, String password);
    Boolean isValidUser(String email, String password);
}
