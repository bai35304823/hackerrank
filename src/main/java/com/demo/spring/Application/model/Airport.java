package com.demo.spring.Application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="airport_seq", allocationSize=1)
	private int id;
	//@Formula("'C' + RIGHT('000000' + CAST(ID AS VARCHAR(10)), 6)")
    private String airportCode;
    @PreUpdate
   	@PrePersist
   	public void calc() {
    	airportCode = StringUtils.leftPad(String.valueOf(id), 6, "0");
   	}
   
    
    private String airportName;
    private String countryId;
	
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
