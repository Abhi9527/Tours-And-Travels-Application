package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Customer;

public interface CustomerService {
	List<Customer> getAllCustomerDetails();
	Customer getCustomerDetails(String userName);
	ApiResponse addCustomerDetails(Customer cust,String userName);
}
