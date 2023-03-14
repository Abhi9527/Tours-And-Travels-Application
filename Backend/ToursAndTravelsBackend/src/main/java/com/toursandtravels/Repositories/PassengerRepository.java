package com.toursandtravels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toursandtravels.entities.Passanger;

public interface PassengerRepository extends JpaRepository<Passanger, Integer> {}
