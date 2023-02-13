package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String countryId;
	private String countryName;
	private String countryCity;
	private String countryState;
	/*
	 * @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Airport> airports;
	 * 
	 * @OneToMany(mappedBy = "destCountry", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Flight> departFlights;
	 * 
	 * @OneToMany(mappedBy = "departCountry", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Flight> destFlights;
	 */
}
