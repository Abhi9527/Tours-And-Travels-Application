package com.toursandtravels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toursandtravels.entities.OTP;

public interface OTPRepository extends JpaRepository<OTP, String> {

}
