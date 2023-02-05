package com.smv.AirSpace.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smv.AirSpace.dto.FlightDTO;

@Entity
@Table (name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "flightNumber", unique = true, nullable = false)
	private String flightNumber;
	@Column(name = "airplaneModel", unique = false, nullable = false)
	private String airplaneModel;
	@Column(name = "fromAirportId", unique = false, nullable = false)
	private String fromAirportId;
	@Column(name = "toAirportId", unique = false, nullable = false)
	private String toAirportId;
	@Column(name = "departureDateTime", unique = false, nullable = false)
	private LocalDateTime departureDateTime;
	@Column(name = "arrivalDateTime", unique = false, nullable = false)
	private LocalDateTime arrivalDateTime;


	public Flight(){

	}

	public Flight(Long id, String flightNumber, String airplaneModel, String fromAirportId, String toAirportId, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
		this.id = id;
		this.flightNumber = flightNumber;
		this.airplaneModel = airplaneModel;
		this.fromAirportId = fromAirportId;
		this.toAirportId = toAirportId;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
	}

	public Flight(FlightDTO flightDTO){
		this.flightNumber = flightDTO.getFlightNumber();
		this.airplaneModel = flightDTO.getAirplaneModel();
		this.fromAirportId = flightDTO.getFromAirportId();
		this.toAirportId = flightDTO.getToAirportId();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.departureDateTime = LocalDateTime.parse(flightDTO.getDepartureDateTime(), formatter);
		this.arrivalDateTime = LocalDateTime.parse(flightDTO.getArrivalDateTime(),formatter);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirplaneModel() {
		return airplaneModel;
	}

	public void setAirplane(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getFromAirportId() {
		return fromAirportId;
	}

	public void setFromAirportId(String fromAirportId) {
		this.fromAirportId = fromAirportId;
	}

	public String getToAirportId() {
		return toAirportId;
	}

	public void setToAirportId(String toAirportId) {
		this.toAirportId = toAirportId;
	}
}
