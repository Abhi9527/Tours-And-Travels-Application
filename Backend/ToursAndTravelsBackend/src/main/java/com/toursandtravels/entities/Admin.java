package com.toursandtravels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Admin")
@ToString(callSuper = true)
public class Admin {
	@Id
	@Column(name = "admin_id")
//	Created a sequence generator for employee id 
//	where initial value is 4122180, here 4122 is company id, 18 tells that these ids are for employees and 0 is the employee id
	@SequenceGenerator(name = "admin_id_generator", sequenceName = "admin_id_seq", initialValue = 412218000, allocationSize = 1)
	@GeneratedValue(generator = "admin_id_generator")
	private int adminId;
	@Column(name="FirstName")
	private String firstname;
	@Column(name="LastName")
	private String lastname;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="Gender")
	private String gender;
	@Column(name="Mobile")
	private String mobile;
	@Column(name="DateOfBirth")
	private String DateOfBirth;
	
	@OneToOne
	@JoinColumn(name = "user_name")
	private UserCredential adminCredentials;
		
	
	public Admin(int admin_Id, String firstname, String lastname, String email, String password, String gender,
			String mobile) {
		super();
		this.adminId = admin_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.mobile = mobile;
	}
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dob) {
		this.DateOfBirth = dob;
	}


	public void setadminCredentials(UserCredential adminCredentials) {
		this.adminCredentials = adminCredentials;
	}
	public void getadminCredentials(UserCredential adminCredentials) {
		this.adminCredentials=adminCredentials;
	}
	
	}
