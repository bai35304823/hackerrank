package com.demo.spring.Application.model;

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
    private String customerName;
    private Date dateOfFlight;
    private String departure;
    private String destination;
    private String seatNo;
    private String costOfFlight;
    private String flightId;
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerName=" + customerName + ", dateOfFlight=" + dateOfFlight
				+ ", departure=" + departure + ", destination=" + destination + ", seatNo=" + seatNo + ", costOfFlight="
				+ costOfFlight + ", flightId=" + flightId + "]";
	}
    
}
