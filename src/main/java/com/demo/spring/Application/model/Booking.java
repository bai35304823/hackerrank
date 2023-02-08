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
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public Date getDateOfFlight() {
		return dateOfFlight;
	}
	public void setDateOfFlight(Date dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public BigDecimal getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(BigDecimal ticketCost) {
		this.ticketCost = ticketCost;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	
    
}
