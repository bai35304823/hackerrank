package com.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "PASSENGERS")
public class Passengers {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
    private String passengerID;
    private String passengerName;
    private String contactNo;
    
	/*
	 * @OneToMany(mappedBy = "passengers" , fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Booking> bookings;
	 */
    
	@Override
	public String toString() {
		return "Passengers [passengerID=" + passengerID + ", passengerName=" + passengerName + ", contactNo="
				+ contactNo + "]";
	}
	public String getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
    
}
