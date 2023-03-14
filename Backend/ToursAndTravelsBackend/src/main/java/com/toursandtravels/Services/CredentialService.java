package com.toursandtravels.Services;

import java.util.List;

import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.UserCredential;
import com.toursandtravels.entities.custom_enum.UserRoles;


public interface CredentialService {
	
	List<UserCredential> getAllCredentials();
	UserRoles getUserRole(String userName);
	ApiResponse createUserCredentials(UserCredential cred);
	ApiResponse updateUserPassword(String userName,String password);
	
}
