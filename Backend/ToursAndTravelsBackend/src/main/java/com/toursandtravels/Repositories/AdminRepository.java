package com.toursandtravels.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toursandtravels.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByAdminCredentialsUserName(String userName);
	List<Admin> findAllByAdminId(Long admin_id);
}
