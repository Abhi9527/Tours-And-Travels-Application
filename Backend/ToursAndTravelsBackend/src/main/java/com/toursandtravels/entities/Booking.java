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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
//@ToString(callSuper = true)
@JsonIgnoreProperties(value = { "packageId", "custId" })
public class Booking {

	@Id
	@Column(name = "booking_id")
	@SequenceGenerator(name = "booking_id_generator", sequenceName = "booking_id_seq", initialValue = 9320230, allocationSize = 1)
	@GeneratedValue(generator = "booking_id_generator")
	private int booking_id;
	@Column(name = "BookingDate")
	private LocalDate bookdate;
	@Column(name = "PackageCost")
	private double packagecost;
	@Column(name = "Tax")
	private String Tax;
	@Column(name = "ToatalCost")
	private String TotalCost;

	@OneToOne
	@JoinColumn(name = "package_Booked")
	private Packages packageId;

	public void addPackage(Packages packages) {
		packageId = packages;
	}

	@OneToMany(mappedBy = "bookingId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Passanger> passanger = new ArrayList<Passanger>();

	public void addPassangers(Passanger passanger) {
		this.passanger.add(passanger);	
		passanger.setBookingid(this);
	}

	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer custId;

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public LocalDate getBookdate() {
		return bookdate;
	}

	public void setBookdate(LocalDate bookdate) {
		this.bookdate = bookdate;
	}

	public double getPackagecost() {
		return packagecost;
	}

	public void setPackagecost(double packagecost) {
		this.packagecost = packagecost;
	}

	public String getTax() {
		return Tax;
	}

	public void setTax(String tax) {
		Tax = tax;
	}

	public String getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(String totalCost) {
		TotalCost = totalCost;
	}

	public Booking(int booking_id, LocalDate bookdate, int cust_Id, double packagecost, String tax, String totalCost) {
		super();
		this.booking_id = booking_id;
		this.bookdate = bookdate;
		this.packagecost = packagecost;
		this.Tax = tax;
		this.TotalCost = totalCost;
	}

	public Customer getCustId() {
		return custId;
	}

	public void setCustId(Customer custId) {
		this.custId = custId;
	}

}
