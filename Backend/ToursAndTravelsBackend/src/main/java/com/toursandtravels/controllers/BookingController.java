package com.toursandtravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toursandtravels.Services.BookingService;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Booking;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost/3000")
public class BookingController {
	
	@Autowired
	private BookingService bookService;
	
	@PostMapping("/bookpackage/{packageId}/{custId}")
	public ApiResponse bookPackage(@PathVariable int packageId,@RequestBody Booking booking,@PathVariable Integer custId ) {
		return bookService.bookPackage(packageId,booking,custId);
	}
	
	@DeleteMapping("/deletepackage/{bookingId}")
	public ApiResponse deletePackage(@PathVariable int bookingId ) {
		return bookService.deletePackage(bookingId);
	}
	
	@GetMapping("/allbookings")
	public List<Booking> allBookings(){
		return bookService.AllBooking();
	}

}
