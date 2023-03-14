package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.CredentialRepository;
import com.toursandtravels.Repositories.OTPRepository;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.UserCredential;
import com.toursandtravels.entities.custom_enum.UserRoles;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	private CredentialRepository credRepo;

	@Autowired
	private OTPRepository otpRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<UserCredential> getAllCredentials() {
		// TODO Auto-generated method stub
		return credRepo.findAll();
	}

	@Override
	public UserRoles getUserRole(String userName) {
		// TODO Auto-generated method stub
		return credRepo.findByUserName(userName).get().getUserRole();
	}

	
	public ApiResponse createUserCredentials(UserCredential cred) {
		// Save Applicant Credentials To database after encoding User Password
		cred.setPassword(encoder.encode(cred.getPassword()));
		credRepo.save(cred);
		return new ApiResponse("UserCredentials Saved Sucessfully");
	}

	@Override
	public ApiResponse updateUserPassword(String userName, String password) {
		UserCredential cred = credRepo.findByUserName(userName).get();
		System.out.println("Password   ------  "+password);
		cred.setPassword(encoder.encode(password));
		credRepo.save(cred);
		otpRepo.deleteById(userName);
		return new ApiResponse("Updated Password Sucessfully");
	}



}
