package com.s2.travelmgt.model;
public class TripRequest {

	String source;
	String destination;
	String vehicleType;
	
	public TripRequest(String source, String destination, String vehicleType) {
		this.source = source;
		this.destination = destination;
		this.vehicleType = vehicleType;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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
}
