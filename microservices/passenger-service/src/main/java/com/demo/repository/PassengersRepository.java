package com.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Passengers;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
	Passengers findByPassengerID(String passengerID); 
}
