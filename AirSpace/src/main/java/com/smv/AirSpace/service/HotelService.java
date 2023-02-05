package com.smv.AirSpace.service;

import java.util.List;

import com.smv.AirSpace.dto.HotelDTO;
import com.smv.AirSpace.dto.RoomDTO;
import com.smv.AirSpace.model.Hotel;
import com.smv.AirSpace.model.Room;

public interface HotelService {
	
	public List<Hotel> getAll();
	public List<String> getAllNames();
	public List<Room> getRooms();
	boolean saveRoom(RoomDTO roomDTO);
	Hotel findByName(String Name);
	Hotel findById(long id);
	List<Room> getRoomsShow(String name);
	List<Hotel> searchByName(String name);
	boolean deleteRoom(long id);
	Hotel findByAdmin(String username);
	Room findRoomById(long id);
	public List<Hotel> searchByCity(String name);
	Boolean updateHotel(HotelDTO hotelDto);


}
