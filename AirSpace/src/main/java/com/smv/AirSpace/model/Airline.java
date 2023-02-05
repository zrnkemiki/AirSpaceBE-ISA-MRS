package com.smv.AirSpace.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smv.AirSpace.dto.AirlineDTO;

@Entity
@Table (name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "description", unique = false, nullable = true)
    private String description;
    @Column(name = "rating", unique = false, nullable = true)
    private double rating;
    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    private Location location;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Airport> airports;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flight> flights;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    
    public Airline(AirlineDTO airlineDTO) {
    	this.name = airlineDTO.getName();
		this.description = airlineDTO.getDescription();
		this.rating = 0.0;
	}
    
    public Airline() {
	}

	public Airline(String name, String description, double rating, Location location) {
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.location = location;
	}
    
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



	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}


}
