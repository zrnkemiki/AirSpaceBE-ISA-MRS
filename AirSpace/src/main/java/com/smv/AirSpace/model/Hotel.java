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

import com.smv.AirSpace.dto.HotelDTO;

@Entity
@Table (name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String name;
	private int stars;
	private String description;
	private double rating;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Location location;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hotel")
	private List<Room> rooms;
	
	public Hotel() {
	}

	public Hotel(Long id, String name, int stars, String description, double rating, Location location) {
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.description = description;
		this.rating = rating;
		this.location = location;
	}
	
	public Hotel(HotelDTO hotelDTO) {
		this.name = hotelDTO.getName();
		this.stars = hotelDTO.getStars();
		this.description = hotelDTO.getDescription();
		this.rating = 0.0;
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

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
