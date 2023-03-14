package com.toursandtravels.dto;

import java.time.LocalDate;
public class BookingDto {

	private int booking_id;
	private LocalDate bookdate;
	private int flag;	
	private double packagecost;
	private String Tax;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	private String TotalCost;
}
