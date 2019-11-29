package com.s2.travelmgt.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "trip_info")
public class TripDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
	
	String empName;
	BigInteger empMobile;
	
	String custName;
	BigInteger custMobile;
	String source;
	String destination;
	Date pickupTime ;
	Date dropTime;
	
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public BigInteger getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(BigInteger empMobile) {
		this.empMobile = empMobile;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public BigInteger getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(BigInteger custMobile) {
		this.custMobile = custMobile;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	public Date getDropTime() {
		return dropTime;
	}
	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}
	
	
}
