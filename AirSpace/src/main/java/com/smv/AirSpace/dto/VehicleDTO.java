package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.BranchOffice;
import com.smv.AirSpace.model.Rentacar;

public class VehicleDTO {
	
	private String model;
	private int numOfSeats;
	private String gearBox;
	private int godinaProizvodnje;
	private long id;
	private Long idOffice;
	private int pricePerDay;
	private String cityLocation;
	private int sale;
	
	//test
	private Rentacar rentacar;
	private BranchOffice branchOffice;
	
	public VehicleDTO() {
		super();
	}
	public VehicleDTO(String model,String gearBox, int numOfSeats, int godinaProizvodnje, Long idOffice, int pricePerDay, String cityLocation, int sale) {

		this.model = model;
		this.gearBox = gearBox;
		this.numOfSeats = numOfSeats;
		this.godinaProizvodnje = godinaProizvodnje;
		this.idOffice = idOffice;
		this.pricePerDay = pricePerDay;
		this.cityLocation = cityLocation;
		this.sale = sale;
		
	}
	public VehicleDTO(long id, String model,String gearBox, int numOfSeats, int godinaProizvodnje, Long idOffice, int pricePerDay, String cityLocation, int sale) {

		this.model = model;
		this.gearBox = gearBox;
		this.numOfSeats = numOfSeats;
		this.godinaProizvodnje = godinaProizvodnje;
		this.idOffice = idOffice;
		this.pricePerDay = pricePerDay;
		this.id = id;
		this.cityLocation = cityLocation;
		this.sale = sale;
		
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGearBox() {
		return gearBox;
	}
	
	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public Long getIdOffice() {
		return idOffice;
	}
	public void setIdOffice(Long idOffice) {
		this.idOffice = idOffice;
	}
	public int getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	//test----------------------------------
	public Rentacar getRentacar() {
		return rentacar;
	}
	public void setRentacar(Rentacar rentacar) {
		this.rentacar = rentacar;
	}
	public BranchOffice getBranchOffice() {
		return branchOffice;
	}
	public void setBranchOffice(BranchOffice branchOffice) {
		this.branchOffice = branchOffice;
	}
	public String getCityLocation() {
		return cityLocation;
	}
	public void setCityLocation(String cityLocation) {
		this.cityLocation = cityLocation;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	
	

}
