package com.demo.spring.Application.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "BOOKING")
public class Booking {
	@Id
    private String bookingId;
    private String passengerId;
    private Date dateOfFlight;
    private String departure;
    private String destination;
    private String seatNo;
    private BigDecimal ticketCost;
    private BigDecimal totalAmt;
    private String flightId;
	
    
}
