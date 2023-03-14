package com.toursandtravels.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDto {

	private int package_id;
	private String packagename;
	private LocalDate startDate;
	private LocalDate endDate;
	private String destinations;
	private String transportType;
	private double packagecost;
	private int noofdays;
//	public int getPackage_id() {
//		return package_id;
//	}
//	public void setPackage_id(int package_id) {
//		this.package_id = package_id;
//	}
//	public String getPackagename() {
//		return packagename;
//	}
//	public void setPackagename(String packagename) {
//		this.packagename = packagename;
//	}
//	public LocalDate getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(LocalDate startDate) {
//		this.startDate = startDate;
//	}
//	public LocalDate getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}
//	public String getDestinations() {
//		return destinations;
//	}
//	public void setDestinations(String destinations) {
//		this.destinations = destinations;
//	}
//	public String getTransportType() {
//		return transportType;
//	}
//	public void setTransportType(String transportType) {
//		this.transportType = transportType;
//	}
//	public double getPackagecost() {
//		return packagecost;
//	}
//	public void setPackagecost(double packagecost) {
//		this.packagecost = packagecost;
//	}
//	public int getNoofdays() {
//		return noofdays;
//	}
//	public void setNoofdays(int noofdays) {
//		this.noofdays = noofdays;
//	}
	
	
	
}

