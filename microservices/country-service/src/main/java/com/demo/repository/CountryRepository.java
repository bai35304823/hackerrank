package com.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {	
	Country findByCountryId(String countryId);	 
	void deleteByCountryId(String countryId);
}
