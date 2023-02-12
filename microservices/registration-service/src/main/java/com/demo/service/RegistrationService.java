package com.demo.service;

import com.demo.entity.Registration;

public interface RegistrationService {
    Registration save(Registration registration);
    Registration findByEmailAndPassword(String email, String password);
    Boolean isValidUser(String email, String password);
}
