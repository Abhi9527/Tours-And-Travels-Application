package com.toursandtravels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toursandtravels.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
