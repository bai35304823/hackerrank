package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {
	// @Query(value = "select * from REGISTRATIONS tu where tu.EMAIL= ?1", nativeQuery = true)
	//Plane findByEmail(String email);
	Plane findByPlaneRegNo(String planeRegNo);
	void deleteByPlaneRegNo(String planeRegNo);
}
