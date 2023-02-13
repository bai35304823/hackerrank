package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Passengers;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
	Passengers findByPassengerID(String passengerID); 
}
