package com.demo.spring.Application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter 
@Setter 
@Table(name = "COUNTRY")
public class Country {
	@Id
    private String countryId;
    private String countryName;
    private String countryCity;
    private String countryState;
}
