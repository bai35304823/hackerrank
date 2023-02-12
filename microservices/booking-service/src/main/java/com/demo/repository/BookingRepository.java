package com.demo.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	Booking findByBookingId(String bookingId);
	List<Booking> findByDateOfFlight(Date dateOfFlight);
	void deleteByBookingId(String bookingId);
}
