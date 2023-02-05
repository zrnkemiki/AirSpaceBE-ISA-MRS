package com.smv.AirSpace.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smv.AirSpace.dto.RentacarDTO;

@Entity
@Table (name = "rentacar")
public class Rentacar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String name;
	private String description;
	private String address;
	/*
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Location location;
	*/
	private double rating;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rentacar")
    private List<BranchOffice> branchOffices;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rentacar")
    private List<Vehicle> vehicles;    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rentacar")
    private List<ReservationRentaCar> reservations;
    
	public Rentacar(){

	}
	
	
	
	public Rentacar(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.rating = 0.0;
	}
	
	public Rentacar(RentacarDTO rentacarDTO) {
		this.id =rentacarDTO.getId();
		this.name = rentacarDTO.getName();
		this.description = rentacarDTO.getDescription();
		this.address = rentacarDTO.getAddress();
		this.rating = 0.0;
	}

	/*
	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}

*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<BranchOffice> getBranchOffices() {
		return branchOffices;
	}

	public void setBranchOffices(List<BranchOffice> branchOffices) {
		this.branchOffices = branchOffices;
	}



	public List<Vehicle> getVehicles() {
		return vehicles;
	}



	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
}
