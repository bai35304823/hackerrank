package com.demo.spring.Application.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "FLIGHT")
public class Flight {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String scheduleId;
    private String destCountry;
    private String departCountry;
    private String destAirport;
    private String departAirport;
    private String capacity;
   // private String planeRegNo;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;
    @Transient
    private String planeRegNo;
	
	public String getDestCountry() {
		return destCountry;
	}
	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}
	public String getDepartCountry() {
		return departCountry;
	}
	public void setDepartCountry(String departCountry) {
		this.departCountry = departCountry;
	}
	public String getDestAirport() {
		return destAirport;
	}
	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}
	public String getDepartAirport() {
		return departAirport;
	}
	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public Timestamp getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}
	public Timestamp getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public String getPlaneRegNo() {
		return planeRegNo;
	}
	public void setPlaneRegNo(String planeRegNo) {
		this.planeRegNo = planeRegNo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
	
    
    
}
