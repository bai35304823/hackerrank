package com.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
	Plane findByPlaneRegNo(String planeRegNo);
	void deleteByPlaneRegNo(String planeRegNo);
}
