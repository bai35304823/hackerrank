package com.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	
	Airport findByAirportCode(String airportCode);
	
	Airport findByAirportName(String airportName);
	
	Airport findByCountryId(String countryId);
	
	void deleteByAirportCode(String airportCode);
}
