package com.toursandtravels.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toursandtravels.entities.UserCredential;

public interface CredentialRepository extends JpaRepository<UserCredential, String>  {
	Optional<UserCredential> findByUserNameAndPassword(String userName, String password);
	Optional<UserCredential> findByUserName(String userName );
}
