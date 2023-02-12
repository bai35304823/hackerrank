package com.demo.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "FLIGHT")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String scheduleId;
	@ManyToOne(cascade = {CascadeType.MERGE})
	// disable foreign key constraint
	@JoinColumn(name = "dest_country", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Country destCountry;
	@Transient
	private String destCountryId;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "depart_country", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Country departCountry;
	@Transient
	private String departCountryId;
	//detached entity passed to persist, use the CascadeType.MERGE instead of CascadeType.PERSIST or CascadeType.ALL.
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "dest_airport_id", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Airport destAirport;
	@Transient
	private String destAirportCode;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "depart_airport_id", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Airport departAirport;
	@Transient
	private String departAirportCode;

	private String capacity;
	// private String planeRegNo;
	private Timestamp departureTime;
	private Timestamp arrivalTime;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "plane_id", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Plane plane;
	@Transient
	private String planeRegNo;
	/*
	 * @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Booking> bookings;
	 */

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
