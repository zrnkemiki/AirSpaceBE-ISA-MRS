package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Rentacar;

public class RentacarDTO {
	
	private String name;
	private String description;
	private String street;
	private String city;
	private String state;
	private Long id;
	private String address;
	
	public RentacarDTO() {
		
	}
	public RentacarDTO(Rentacar rentacar) {
		this.name = rentacar.getName();
		this.description = rentacar.getDescription();
		this.id = rentacar.getId();
		/*this.street = rentacar.getLocation().getAddress().getStreet();
		this.city = rentacar.getLocation().getAddress().getCity();
		this.state = rentacar.getLocation().getAddress().getState();
		this.id = rentacar.getLocation().getAddress().getId();
		*/
		this.street = rentacar.getAddress();
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
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

	
	
	
}
