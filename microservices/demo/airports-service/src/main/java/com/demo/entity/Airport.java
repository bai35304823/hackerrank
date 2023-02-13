package com.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
/*
 * @Getter
 * 
 * @Setter
 */
@Table(name = "AIRPORT")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @JsonIgnore
	private long id;
	private String airportCode;
	private String airportName;
	private String countryId;
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "country", foreignKey = @javax.persistence.ForeignKey(name = "none"))
	private Country country;
	/*
	 * @OneToMany(mappedBy = "destAirport", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Flight> destFlights;
	 * 
	 * @OneToMany(mappedBy = "departAirport", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<Flight> departFlights;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn private Country country;
	 */

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportName=" + airportName + ", countryId=" + countryId
				+ "]";
	}

}
