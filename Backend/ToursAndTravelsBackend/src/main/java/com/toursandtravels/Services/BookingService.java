package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Booking;

public interface BookingService {
	ApiResponse bookPackage(int packageId,Booking booking,Integer custId);
	ApiResponse deletePackage(int bookingId);
	List<Booking> AllBooking();
}
