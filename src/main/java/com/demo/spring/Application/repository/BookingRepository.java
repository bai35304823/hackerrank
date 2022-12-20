package com.demo.spring.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Application.model.Booking;
import com.demo.spring.Application.model.Registration;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
	// @Query(value = "select * from REGISTRATIONS tu where tu.EMAIL= ?1", nativeQuery = true)
	Booking findByBookingId(String bookingId);
	 
}
