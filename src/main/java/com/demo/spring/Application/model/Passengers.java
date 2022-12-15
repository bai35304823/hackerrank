package com.demo.spring.Application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "PASSENGERS")
public class Passengers {
	@Id
    private String passengerID;
    private String passengerName;
    private String contactNo;
	@Override
	public String toString() {
		return "Passengers [passengerID=" + passengerID + ", passengerName=" + passengerName + ", contactNo="
				+ contactNo + "]";
	}
    
}
