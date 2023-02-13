package com.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
 
@Table(name = "PLANE")
public class Plane {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	private String planeRegNo;
    private String planeMaker;
    private String planeModel;
    private String planeCapacity;
	/*
	 * @OneToMany(mappedBy = "plane" , fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Flight> flights;
	 */
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaneMaker() {
		return planeMaker;
	}
	public void setPlaneMaker(String planeMaker) {
		this.planeMaker = planeMaker;
	}
	public String getPlaneModel() {
		return planeModel;
	}
	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}
	public String getPlaneCapacity() {
		return planeCapacity;
	}
	public void setPlaneCapacity(String planeCapacity) {
		this.planeCapacity = planeCapacity;
	}
	public String getPlaneRegNo() {
		return planeRegNo;
	}
	public void setPlaneRegNo(String planeRegNo) {
		this.planeRegNo = planeRegNo;
	}
    
    
}
