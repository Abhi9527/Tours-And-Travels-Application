package com.toursandtravels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toursandtravels.entities.Packages;

public interface PackagesRepositories extends JpaRepository<Packages, Integer> {
}
