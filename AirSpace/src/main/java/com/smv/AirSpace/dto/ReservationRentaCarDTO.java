package com.smv.AirSpace.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReservationRentaCarDTO {
	
	private Long id;	
	private Long userId;
	private Long vehicleId;	
	private String dateFrom;
	private String dateUntil;
	
	public ReservationRentaCarDTO() {
		
	}
	
	public ReservationRentaCarDTO(Long id, Long rentacarId, Long userId, Long vehicleId, String dateFrom,
			String dateUntil) {
		super();
		this.id = id;
		this.userId = userId;
		this.vehicleId = vehicleId;
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
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
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Date getDateFrom() throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	
	public Date getDateUntil() throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(dateUntil);
	}
	public void setDateUntil(String dateUntil) {
		this.dateUntil = dateUntil;
	}

	
}
