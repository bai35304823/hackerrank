package com.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Country;
import com.demo.entity.Flight;
import com.demo.entity.Plane;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	Flight findByScheduleId(String scheduleId);
	List<Flight> findByPlaneRegNo(String planeRegNo);
	List<Flight> findByDepartCountryAndDestCountry(Country source, Country destination);
	List<Flight> findByPlane(Plane plane);
	void deleteByScheduleId(String scheduleId);
}
