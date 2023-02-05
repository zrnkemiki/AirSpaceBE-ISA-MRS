package com.smv.AirSpace.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.smv.AirSpace.dto.RoomDTO;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private int number;
	private int floor;
	@Enumerated(EnumType.ORDINAL)
	private RoomType roomType;
	private int numOfBeds;
	private double price;
	private double rating;
	@ManyToOne()
	private Hotel hotel;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "room")
    private List<RoomReservation> reservations;

	public Room() {

	}

	public Room(Long id, int number, int floor, RoomType roomType, int numOfBeds, double price, double rating,
			boolean available) {

		this.id = id;
		this.number = number;
		this.floor = floor;
		this.roomType = roomType;
		this.numOfBeds = numOfBeds;
		this.price = price;
		this.rating = rating;
	}

	public Room(RoomDTO roomDTO) {
		this.id = roomDTO.getId();
		this.number = roomDTO.getNumber();
		this.floor = roomDTO.getFloor();
		this.roomType = roomDTO.getRoomType();
		this.numOfBeds = roomDTO.getNumOfBeds();
		this.price = roomDTO.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getNumOfBeds() {
		return numOfBeds;
	}

	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
