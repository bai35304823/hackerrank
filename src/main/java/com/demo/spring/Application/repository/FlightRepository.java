package com.demo.spring.Application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Country;
import com.demo.spring.Application.model.Flight;
import com.demo.spring.Application.model.Plane;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	Flight findByScheduleId(String scheduleId);
	Flight findByPlaneRegNo(String planeRegNo);
	List<Flight> findByDepartCountryAndDestCountry(Country source, Country destination);
	List<Flight> findByPlane(Plane plane);
	void deleteByScheduleId(String scheduleId);
}
