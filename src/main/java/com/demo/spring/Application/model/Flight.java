package com.demo.spring.Application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "FLIGHT")
public class Flight {
	@Id
    private String scheduleId;
    private String destCountry;
    private String departCountry;
    private String destAirport;
    private String departAirport;
    private String capacity;
    private String planeRegNo;
    private String departureTime;
    private String arrivalTime;
}
