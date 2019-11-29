package com.s2.travelmgt.model;

import java.math.BigInteger;

public class TripResponse {
	 private int tripId;
		
	private	String empName;
	private	BigInteger empMobile;
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
	
	
}
