package com.toursandtravels.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.toursandtravels.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByCustomerCredentialsUserName(String userName);
}
