package com.toursandtravels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Iternery")
@NoArgsConstructor
public class Iternery {

@Id
@Column(name = "Tternery_Id")
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int itr_id;
@Column(name = "Destinations")
private String destinations;
@Column(name = "StartLoaction")
private String startloaction;
public int getItr_id() {
	return itr_id;
}
public void setItr_id(int itr_id) {
	this.itr_id = itr_id;
}
public String getDestinations() {
	return destinations;
}
public void setDestinations(String destinations) {
	this.destinations = destinations;
}
public String getStartloaction() {
	return startloaction;
}
public void setStartloaction(String startloaction) {
	this.startloaction = startloaction;
}
public Iternery(int itr_id, String destinations, String startloaction) {
	super();
	this.itr_id = itr_id;
	this.destinations = destinations;
	this.startloaction = startloaction;
}



}
