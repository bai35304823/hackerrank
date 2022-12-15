package com.demo.spring.Application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "PLANE")
public class Plane {
	@Id
    private String id;
    private String planeMaker;
    private String planeModel;
    private String planeCapacity;
    private String planeRegNo;
}
