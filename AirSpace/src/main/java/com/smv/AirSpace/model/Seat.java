package com.smv.AirSpace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "seat")
public class Seat {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	@Column(name = "seatRow", unique = false, nullable = false)
	private int seatRow;
	@Column(name = "seatColumn", unique = false, nullable = false)
	private String seatColumn;
	@Column(name = "occupied", unique = false, nullable = false)
	private boolean occupied;
	@Enumerated(EnumType.ORDINAL)
	private SeatType seatType;

	public Seat() {
		
	}

	public Seat(Long id, int row, String column, boolean occupied, SeatType seatType) {
		this.id = id;
		this.seatRow = row;
		this.seatColumn = column;
		this.occupied = occupied;
		this.seatType = seatType;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(String seatColumn) {
		this.seatColumn = seatColumn;
	}

	public boolean isOccupied() {
		return occupied;
	}


	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}


	public SeatType getSeatType() {
		return seatType;
	}


	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	


}

