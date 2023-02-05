package com.smv.AirSpace.dto;

import java.time.LocalDateTime;

public class FlightDTO {
    private String flightNumber;
    private String airplaneModel;
    private String fromAirportId;
    private String toAirportId;
    private String departureDateTime;
    private String arrivalDateTime;

    public FlightDTO(){

    }

    public FlightDTO(String flightNumber, String airplaneModel, String fromAirportId, String toAirportId, String departureDateTime, String arrivalDateTime) {
        this.flightNumber = flightNumber;
        this.airplaneModel = airplaneModel;
        this.fromAirportId = fromAirportId;
        this.toAirportId = toAirportId;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
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

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
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

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
}
