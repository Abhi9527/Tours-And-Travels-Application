package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.CredentialRepository;
import com.toursandtravels.Repositories.CustomerRepository;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Customer;
import com.toursandtravels.entities.UserCredential;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private CredentialRepository credRepo;
	
	@Override
	public List<Customer> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return custRepo.findAll();
	}

	@Override
	public Customer getCustomerDetails(String userName) {
		// TODO Auto-generated method stub
		return custRepo.findByCustomerCredentialsUserName(userName).get();
	}

	@Override
	public ApiResponse addCustomerDetails(Customer cust, String userName) {
		UserCredential cred = credRepo.findByUserName(userName).get();
		cred.setcustomerCredentials(cust);
		custRepo.save(cust);
		return new ApiResponse("Customer Added Sucessfully");
	}


	

}
