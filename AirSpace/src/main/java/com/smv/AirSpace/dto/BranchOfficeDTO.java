package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Rentacar;

public class BranchOfficeDTO {
	
	private long id;
	private String officeName;
	private Rentacar rentacar;
	private String address;
	
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Rentacar getRentacar() {
		return rentacar;
	}
	public void setRentacar(Rentacar rentacar) {
		this.rentacar = rentacar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
