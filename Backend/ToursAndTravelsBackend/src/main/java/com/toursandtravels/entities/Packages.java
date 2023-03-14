package com.toursandtravels.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Packages")
//@ToString(callSuper = true)
@NoArgsConstructor
public class Packages {

	@Id
	@Column(name = "package_id")
	@SequenceGenerator(name = "package_id_generator", sequenceName = "package_id_seq", initialValue = 8320230, allocationSize = 1)
	@GeneratedValue(generator = "package_id_generator")
	private int package_id;
	@Column(name="PackageName")   
	private String packagename;
	@Column(name="StartDate")
	private LocalDate startDate;
	@Column(name="EndDate")
	private LocalDate endDate;
	@Column(name="TourDate")
	private LocalDate tourDate;
	@Column(name="Destinations")
	private String destinations;
	@Column(name="TransportType")
	private String transportType;
	@Column(name="PackageCost")
	private double packagecost;
	@Column(name="NoOfDays")
	private int noofdays;
	@Column(name = "NoOfPassengers")
	private int noofpassengers;

	
	
	@OneToMany(mappedBy = "packageId",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	private List<Booking> bookId=new ArrayList<Booking>();
	
	public void addBooking(Booking bookId) {
		this.bookId.add(bookId);
		bookId.addPackage(this);
	}
	
	
	
	
	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getTourDate() {
		return tourDate;
	}

	public void setTourDate(LocalDate tourDate) {
		this.tourDate = tourDate;
	}

	public String getDestinations() {
		return destinations;
	}

	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}

	public double getPackagecost() {
		return packagecost;
	}

	public void setPackagecost(double packagecost) {
		this.packagecost = packagecost;
	}

	public int getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}

	public Packages(int package_id, String packagename, LocalDate startDate, LocalDate endDate,
			String destinations, double packagecost, int noofdays) {
		super();
		this.package_id = package_id;
		this.packagename = packagename;
		this.startDate = startDate;
		this.endDate = endDate;
		this.destinations = destinations;
		this.packagecost = packagecost;
		this.noofdays = noofdays;
	}


	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "")
	private List<Customer> customer = new ArrayList<>();
	
	//Helper Method for applications
	public void addCustomer(Customer cust) {
		customer.add(cust);
		cust.setPackages(this);
	}

//	


	
	}
	
	
	
	

