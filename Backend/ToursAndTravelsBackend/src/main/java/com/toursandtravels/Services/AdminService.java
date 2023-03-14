package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Admin;

public interface AdminService {
	List<Admin> getAdminDetails();
	Admin getAdminDetails(String userName);
	ApiResponse addAdminDetails(Admin admin, String userName);
}
