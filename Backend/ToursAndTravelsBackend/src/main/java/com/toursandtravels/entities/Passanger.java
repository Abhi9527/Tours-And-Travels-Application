package com.toursandtravels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "passanger")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"customer","bookingId"})
@ToString
public class Passanger {

	@Id
	@SequenceGenerator(name = "Pass_Id_generator", sequenceName = "Pass_Id_seq", initialValue = 19990, allocationSize = 1)
	@GeneratedValue(generator = "Pass_Id_generator")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pass_Id")
	private int passengerid;
	@Column(name = "Firstname")
	private String firstname;
	@Column(name = "Lastname")
	private String lastname;
	@Column(name = "Address")
	private String address;
	@Column(name = "Passport")
	private String passport;
	@Column(name = "passport_path")
	private String passportPath;
	
	@Column(name = "Gender")
	private String gender;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "Booking_Id")
	@OneToOne
	private Booking bookingId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer customer;


	public Passanger(String firstname, String lastname, String address, String passport,
			String gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.passport = passport;
		this.gender = gender;
	}
	
	
	public String getPassportPath() {
		return passportPath;
	}

	public void setPassportPath(String passportPath) {
		this.passportPath = passportPath;
	}

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassangerid(int passangerid) {
		this.passengerid = passangerid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Booking getBookingid() {
		return bookingId;
	}

	public void setBookingid(Booking bookingid) {
		this.bookingId = bookingid;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
