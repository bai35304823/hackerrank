package com.demo.spring.Application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Airport> airports;

	@OneToMany(mappedBy = "destCountry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Flight> departFlights;

	@OneToMany(mappedBy = "departCountry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Flight> destFlights;
}
