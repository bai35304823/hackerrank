package com.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "BOOKING")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bookingId;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "passengers_id", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Passengers passengers;
	@Transient
	private String passengerId;
	private Date dateOfFlight;
	private String departure;
	private String destination;
	private String seatNo;
	private BigDecimal ticketCost;
	private BigDecimal totalAmt;
	@Transient
	private String scheduleId;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "flight_id", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Flight flight;

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

}
