package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Airport;
import com.demo.spring.Application.model.Registration;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
	
	Airport findByAirportCode(String airportCode);
	 
}
