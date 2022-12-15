package com.demo.spring.Application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
/*
 * @Getter
 * 
 * @Setter
 */ 
@Table(name = "AIRPORT")
public class Airport {
	@Id
    private String airportId;
    private String airportCode;
    private String airportName;
    private String countryId;
	public String getAirportId() {
		return airportId;
	}
	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
    
    
}
