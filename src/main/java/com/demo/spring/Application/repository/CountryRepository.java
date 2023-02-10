package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {	
	Country findByCountryId(String countryId);	 
}
