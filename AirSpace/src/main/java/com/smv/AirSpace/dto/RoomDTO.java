package com.smv.AirSpace.dto;

import com.smv.AirSpace.model.Room;
import com.smv.AirSpace.model.RoomType;

public class RoomDTO {
	
	private Long id;
	private int number;	
	private int floor;
	private RoomType roomType;
	private int numOfBeds;
	private double price;
	
	
	public RoomDTO() {
	}
	public RoomDTO(Room room) {
		this.id = room.getId();
		this.number = room.getNumber();
		this.floor = room.getFloor();
		this.roomType = room.getRoomType();
		this.numOfBeds = room.getNumOfBeds();
		this.price = room.getPrice();
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
	
}
