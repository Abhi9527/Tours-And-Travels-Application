package com.toursandtravels.entities;

import static com.toursandtravels.entities.custom_enum.UserRoles.valueOf;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.toursandtravels.entities.custom_enum.UserRoles;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_credentials")
@ToString(exclude ="userRole")
@NoArgsConstructor
public class UserCredential {
	@Id
	@NotBlank(message = "UserName should be provided")
	private String userName;
	
	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Password should be provided")
	private String password;
	
	@Column(name = "user_role", length = 50)
	@Enumerated(value = EnumType.STRING)
	private UserRoles userRole;
	
	 //For pointing username from Admin
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(mappedBy = "adminCredentials", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Admin admin_id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(mappedBy = "customerCredentials", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Customer cust_Id;
	

	public void setAdminCredentials(Admin admin) {
		admin_id = admin;
		admin.setadminCredentials(this);
	}
	public void setcustomerCredentials(Customer cust) {
		cust_Id = cust;
		cust.setcustomerCredentials(this);
	}


	public UserCredential(@NotBlank(message = "UserName should be provided") String userName,
			@NotBlank(message = "Password should be provided") String password, UserRoles userRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public UserRoles getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = valueOf(userRole);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Admin admin_id) {
		this.admin_id = admin_id;
	}
//	public Customer getCust_Id() {
//		return cust_Id;
//	}
//	public void setCust_Id(Customer cust_Id) {
//		this.cust_Id = cust_Id;
//	}
	
	
}
