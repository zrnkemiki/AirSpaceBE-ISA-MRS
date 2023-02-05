package com.smv.AirSpace.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.smv.AirSpace.dto.VehicleDTO;


@Entity
@Table (name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String model;
	private String gearBox;
	private int numOfSeats;
	private int godinaProizvodnje;
	private boolean available;
	private int sale;
	
	private Long idUser;
	private String cityLocation;
	private int pricePerDay;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<ReservationRentaCar> reservations;
	
	@ManyToOne()
	private BranchOffice branchoffice;
	
	@ManyToOne()
	private Rentacar rentacar;
	
	
	public Vehicle() {
	}

	public Vehicle(Long id, String model, int numOfSeats,String gearBox, boolean available, int sale) {
		this.id = id;
		this.model = model;
		this.gearBox = gearBox;
		this.numOfSeats = numOfSeats;
		this.available = available;
		this.sale = sale;
	}
	
	public Vehicle(Long id, String model, String gearBox, int numOfSeats, int godinaProizvodnje, Long idOffice, int pricePerDay) {
		this.id = id;
		this.model = model;
		this.gearBox = gearBox;
		this.numOfSeats = numOfSeats;
		this.godinaProizvodnje = godinaProizvodnje;
		this.available = true;
		this.sale = 1;
		this.pricePerDay = pricePerDay;
	}
	
	public Vehicle(VehicleDTO dto, Long userId) {
		this.id = dto.getId();
		this.model = dto.getModel();
		this.gearBox = dto.getGearBox();
		this.numOfSeats = dto.getNumOfSeats();
		this.godinaProizvodnje = dto.getGodinaProizvodnje();
		this.pricePerDay = dto.getPricePerDay();
		this.rentacar = dto.getRentacar();
		this.branchoffice = dto.getBranchOffice();
		this.cityLocation = dto.getCityLocation();
		this.idUser = userId;
		this.available = true;
		this.sale = dto.getSale();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getCityLocation() {
		return cityLocation;
	}

	public void setCityLocation(String cityLocation) {
		this.cityLocation = cityLocation;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public Rentacar findRentaCar() {
		return rentacar;
	}
	
	
	
	

}
