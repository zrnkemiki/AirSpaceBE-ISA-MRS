package com.smv.AirSpace.service;

import java.util.List;

import com.smv.AirSpace.dto.RoomReservationDTO;
import com.smv.AirSpace.model.Room;

public interface RoomReservationService {
	
	public List<Room> getRoomReservations(String hotelName, String dateFrom, String dateUntil, String numberOfSeats);
	
	public List<RoomReservationDTO> getReservationsByUserID(long id);
	
	public Boolean saveReservation(RoomReservationDTO reservation);
		
	public boolean delete(Long id);

}