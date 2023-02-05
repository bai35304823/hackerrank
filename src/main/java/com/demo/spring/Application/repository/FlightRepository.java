package com.demo.spring.Application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
	// @Query(value = "select * from REGISTRATIONS tu where tu.EMAIL= ?1", nativeQuery = true)
	 //Flight findById(String id);
	Flight findByScheduleId(String scheduleId);
	Flight findByPlaneRegNo(String planeRegNo);
	List<Flight> findByDepartCountryAndDestCountry(String source, String destination);
	void deleteByScheduleId(String scheduleId);
}
