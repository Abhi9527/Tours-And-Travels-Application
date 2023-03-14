package com.toursandtravels.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toursandtravels.Services.AdminService;
import com.toursandtravels.dto.AdminDto;
import com.toursandtravels.entities.Admin;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ModelMapper mapper;

	public AdminController() {
		System.out.println("In default Constructor of" + getClass());
	}
	
	@PostMapping("/{userName}/createprofile")
	public ResponseEntity<?> createCustomerDetails(@PathVariable String userName, @RequestBody AdminDto admin) {
		Admin adminDetails = mapper.map(admin, Admin.class);
		return ResponseEntity.ok(adminService.addAdminDetails(adminDetails, userName));
	}

	@GetMapping("/alladmindetails")
	public List<Admin> getAllAdmin() {
		return adminService.getAdminDetails();
		
		
	}
	@GetMapping("/profile/{userName}")
	public Admin getadminDetails(@PathVariable String userName) {
		return adminService.getAdminDetails(userName);
	}
	
	@GetMapping("/name/{userName}")
	public String getadminName(@PathVariable String userName) {
		return adminService.getAdminDetails(userName).getFirstname()+" "+adminService.getAdminDetails(userName).getLastname();
	}
	
	
}
