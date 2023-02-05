package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
	
	Airport findByAirportCode(String airportCode);
	
	Airport findByAirportName(String airportName);
	
	Airport findByCountryId(String countryId);
	
	void deleteByAirportCode(String airportCode);
	 
}
