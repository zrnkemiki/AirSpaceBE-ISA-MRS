package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Airline;

public class AirlineFrontDTO {
	
	private String name;
    private String description;
    private String street;
	private String city;
	private String state;
	private double rating;
	
	public AirlineFrontDTO(Airline airline) {
		this.name =  airline.getName();
		this.description = airline.getDescription();
		this.street = airline.getLocation().getAddress().getStreet();
		this.city = airline.getLocation().getAddress().getCity();
		this.state = airline.getLocation().getAddress().getState();
		this.rating = airline.getRating();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	

}
