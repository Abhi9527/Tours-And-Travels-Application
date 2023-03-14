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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toursandtravels.Services.CustomerService;
import com.toursandtravels.dto.CustomerDto;
import com.toursandtravels.entities.Customer;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@Autowired
	private ModelMapper mapper;

	

	public CustomerController() {
		System.out.println("In default Constructor of" + getClass());
	}

	@GetMapping("/view")
	public List<Customer> getAllCustomers() {
		return custService.getAllCustomerDetails();
	}

	@PostMapping("/{userName}/createprofile")
	public ResponseEntity<?> createCustomerDetails(@PathVariable String userName, @RequestBody CustomerDto cust) {
		Customer custDetails = mapper.map(cust, Customer.class);
		return ResponseEntity.ok(custService.addCustomerDetails(custDetails, userName));
	}

	@GetMapping("/profile")
	public Customer getCustomersDetails(@RequestParam String userName) {
		return custService.getCustomerDetails(userName);
	}

	@GetMapping("/name/{userName}")
	public String getCustomerName(@PathVariable String userName) {
		return custService.getCustomerDetails(userName).getFirstname() + " "
				+ custService.getCustomerDetails(userName).getLastname();
	}



}
