package com.toursandtravels.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toursandtravels.Repositories.BookingRepository;
import com.toursandtravels.Repositories.CustomerRepository;
import com.toursandtravels.Repositories.PackagesRepositories;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Booking;
import com.toursandtravels.entities.Customer;
import com.toursandtravels.entities.Packages;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Autowired
	private PackagesRepositories packRepo;
	
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public ApiResponse bookPackage(int packageId,Booking booking,Integer custId) {
		// TODO Auto-generated method stub
		Packages pack = packRepo.findById(packageId).get();
		Customer cust = custRepo.findById(custId).get();
		pack.addBooking(booking);
		cust.addBookings(booking);
		bookRepo.save(booking);
		return new ApiResponse("Booked Package");
	}

	@Override
	public ApiResponse deletePackage(int bookingId) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(bookingId);
		return new ApiResponse("Booking Cancled Sucessfully");
	}

	@Override
	public List<Booking> AllBooking() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}
	
	
	
	
	
}
