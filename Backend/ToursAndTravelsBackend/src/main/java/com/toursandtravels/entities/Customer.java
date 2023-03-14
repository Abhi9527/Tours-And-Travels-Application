package com.toursandtravels.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Customer")
public class Customer{
	

	@Id
	@Column(name = "cust_id")
	@SequenceGenerator(name = "cust_id_generator", sequenceName = "cust_id_seq", initialValue = 412291000, allocationSize = 1)
	@GeneratedValue(generator = "cust_id_generator")
	private int cust_Id;
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
	@Column(name="DOB")
	private LocalDate dob;
	
	
	@OneToOne
	@JoinColumn(name = "user_name")
	private UserCredential customerCredentials;
	

    @OneToOne(mappedBy = "custId",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	private Booking booking;
    
    
    public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void addBookings(Booking booking) {
    	this.booking=booking;
    	booking.setCustId(this);
    }
	
    
    @JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne
    private Packages packages ;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Passanger> passangers;
    
    public void addPassenger(Passanger passanger) {
    	this.passangers.add(passanger);
    	passanger.setCustomer(this);
    }
    
    public List<Passanger> getPassengers() {
        return passangers;
    }
    
    public void setPassengers(List<Passanger> passengers) {
        this.passangers = passengers;
    }
    
   
	
	public Packages getPackages() {
		return packages;
	}
	public void setPackages(Packages packages) {
		this.packages = packages;
	}
	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Customer(int cust_Id, String firstname, String lastname, String email, String password, String gender,
			String mobile, LocalDate dob) {
		super();
		this.cust_Id = cust_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.mobile = mobile;
	}
	
	
	public Customer() {
		super();
	}
	
	public  UserCredential getcustomerCredentials() {
		return customerCredentials;
	}

	public void setcustomerCredentials(UserCredential customerCredentials) {
		this.customerCredentials = customerCredentials;
	}
	
	
	
	
	}
	
	
	
	
	
	
	



