package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
	Plane findByPlaneRegNo(String planeRegNo);
	void deleteByPlaneRegNo(String planeRegNo);
}
