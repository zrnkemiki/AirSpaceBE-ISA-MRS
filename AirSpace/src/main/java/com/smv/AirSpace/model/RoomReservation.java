package com.smv.AirSpace.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roomreservation")
public class RoomReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private Date startDate;
	private Date endDate;
    @ManyToOne()
	private Room room;
	private double price;
	@ManyToOne()
	private User customer;
	private int numOfGuests;

	public RoomReservation() {
	}

	public RoomReservation(Long id, Date startDate, Date endDate, Room room, Hotel hotel, double price, RegisteredUser customer,
			int numOfGuests) {

		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.price = price;
		this.customer = customer;
		this.numOfGuests = numOfGuests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public int getNumOfGuests() {
		return numOfGuests;
	}

	public void setNumOfGuests(int numOfcustomers) {
		this.numOfGuests = numOfcustomers;
	}

}
