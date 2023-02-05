package com.smv.AirSpace.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomReservationDTO {

	private Long id;	
	private Long userId;
	private Long roomId;	
	private String dateFrom;
	private String dateUntil;
	private String hotelName;
	
	public RoomReservationDTO(Long id, Long userId, Long roomId, String dateFrom, String dateUntil, String hotelName) {
		super();
		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
		this.hotelName = hotelName;
	}

	public RoomReservationDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Date getDateFrom() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dateFrom);
		System.out.println(date);
		return date;	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateUntil() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dateUntil);
		System.out.println(date);
		return date;
	}

	public void setDateUntil(String dateUntil) {
		this.dateUntil = dateUntil;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
	
}
