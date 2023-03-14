package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.AdminRepository;
import com.toursandtravels.Repositories.CredentialRepository;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Admin;
import com.toursandtravels.entities.UserCredential;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CredentialRepository credRepo;
	
	@Override
	public List<Admin> getAdminDetails() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin getAdminDetails(String userName) {
		// TODO Auto-generated method stub
		return adminRepo.findByAdminCredentialsUserName(userName).get();
	}
	@Override
	public ApiResponse addAdminDetails(Admin admin, String userName) {
		UserCredential cred = credRepo.findByUserName(userName).get();
		cred.setAdminCredentials(admin);
		adminRepo.save(admin);
		return new ApiResponse("Admin Added Sucessfully");
	}

}
