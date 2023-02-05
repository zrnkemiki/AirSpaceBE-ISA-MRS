package com.smv.AirSpace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.HotelDTO;
import com.smv.AirSpace.dto.RoomDTO;
import com.smv.AirSpace.model.Hotel;
import com.smv.AirSpace.model.Location;
import com.smv.AirSpace.model.Room;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.repository.HotelRepository;
import com.smv.AirSpace.repository.RoomRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	UserService userService;

	@Override
	public boolean saveRoom(RoomDTO roomDTO) {
		Hotel hotel = hotelRepository.findByName("dash");
		Room room = new Room(roomDTO);
		room.setHotel(hotel);
		if (room != null) {
			roomRepository.save(room);
			return true;
		}
		return false;

	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public List<String> getAllNames() {
		return hotelRepository.getAllNames();
	}

	@Override
	public List<Room> getRooms() {
		// User user = userService.getLoggedUser();
		// Hotel hotel = hotelRepository.findById(user.getCompanyId());
		List<Room> rooms = new ArrayList<>();
		Hotel hotel = hotelRepository.findByName("dash");
		rooms = hotel.getRooms();
		return rooms;
	}

	@Override
	public List<Room> getRoomsShow(String name) {
		// User user = userService.getLoggedUser();
		// Hotel hotel = hotelRepository.findById(user.getCompanyId());
		List<Room> rooms = new ArrayList<>();
		Hotel hotel = hotelRepository.findByName(name);
		rooms = hotel.getRooms();
		return rooms;
	}
	
	@Override
	public Hotel findByAdmin(String username) {
		User user = userService.findByUsername(username);
		return hotelRepository.findById(user.getCompanyId());
	}
	

	@Override
	public Hotel findByName(String name) {
		return hotelRepository.findByName(name);
	}

	@Override
	public Hotel findById(long id) {
		return hotelRepository.findById(id);
	}

	@Override
	public List<Hotel> searchByName(String name) {
		List<Hotel> hotels = new ArrayList<>();
		for (Hotel c : hotelRepository.findAll()) {
			if (c.getName().toLowerCase().contains(name.toLowerCase())) {
				hotels.add(c);
			}
		}
		return hotels;
	}

	@Override
	public boolean deleteRoom(long id) {
		try {
			roomRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	@Override
	public Room findRoomById(long id) {
		return roomRepository.findById(id);
	}

	@Override
	public List<Hotel> searchByCity(String name) {
		List<Hotel> hotels = new ArrayList<>();
		for (Hotel c : hotelRepository.findAll()) {
			if (c.getLocation().getAddress().getCity().toLowerCase().contains(name.toLowerCase())) {
				hotels.add(c);
			}
		}
		return hotels;
	}
	

	@Override
	public Boolean updateHotel(HotelDTO hotelDto) {
			Hotel hotel = hotelRepository.findByName(hotelDto.getName());
			hotel.setDescription(hotelDto.getDescription());
			hotel.setStars(hotelDto.getStars());
			Location location = UserServiceImpl.locationSetter(hotelDto.getStreet(), hotelDto.getCity(), hotelDto.getState());
			hotel.setLocation(location);
			try {
				hotelRepository.save(hotel);
				return true;
			} catch (Exception e) {
				return false;
			}			
	}
	
}
