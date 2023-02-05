package com.smv.AirSpace.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.RoomReservationDTO;
import com.smv.AirSpace.model.Room;
import com.smv.AirSpace.model.RoomReservation;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.repository.RoomReservationRepository;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {
	
	@Autowired
	RoomReservationRepository roomReservationRepository;
	
	@Autowired
	HotelService hotelService;

	@Autowired
	UserService userService;
	
	public List<Room> getRoomReservations(String hotelName, String dateFrom, String dateUntil, String numberOfBeds) {
		
		List<RoomReservation> reservations = new ArrayList<>();
		List<Room> rooms = new ArrayList<Room>();
		reservations = roomReservationRepository.findAll();
		Date date1 = new Date();
		Date date2 = new Date();
		
		
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateUntil);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if (reservations.isEmpty()) {
			for (Room r: hotelService.getRoomsShow(hotelName)) {
				if (Integer.parseInt(numberOfBeds) <= r.getNumOfBeds()) {
					rooms.add(r);
				}
			}
			return rooms;
		}

		rooms = hotelService.getRoomsShow(hotelName);
		List<Long> unavailableRooms = new ArrayList<Long>();
		Iterator<RoomReservation> iter = reservations.iterator();
		
		while (iter.hasNext()) {
			RoomReservation reservation = iter.next();
			if (date1.after(reservation.getStartDate()) && date2.before(reservation.getEndDate())) {
				iter.remove();
				unavailableRooms.add(reservation.getRoom().getId());
			} else if (date1.before(reservation.getStartDate()) && date2.after(reservation.getEndDate())) {
				iter.remove();
				unavailableRooms.add(reservation.getRoom().getId());
			} else if (date1.before(reservation.getStartDate()) && date2.after(reservation.getStartDate())
					&& date2.before(reservation.getEndDate())) {
				iter.remove();
				unavailableRooms.add(reservation.getRoom().getId());
			} else if (date1.after(reservation.getStartDate()) && date1.before(reservation.getEndDate())
					&& date2.after(reservation.getEndDate())) {
				iter.remove();
				unavailableRooms.add(reservation.getRoom().getId());
			} else if (date1.equals(reservation.getStartDate()) && date2.equals(reservation.getEndDate())) {
				iter.remove();
				unavailableRooms.add(reservation.getRoom().getId());
			}
			  else if (date1.equals(reservation.getStartDate()) && date2.before(reservation.getEndDate())) {
				iter.remove();
				unavailableRooms.add(reservation.getRoom().getId());
			}
			  else if (date1.equals(reservation.getStartDate()) && date2.after(reservation.getEndDate())) {
					iter.remove();
					unavailableRooms.add(reservation.getRoom().getId());
			}
			  else if (date1.before(reservation.getStartDate()) && date2.equals(reservation.getEndDate())) {
					iter.remove();
					unavailableRooms.add(reservation.getRoom().getId());
			}
			  else if (date1.after(reservation.getStartDate()) && date2.equals(reservation.getEndDate())) {
					iter.remove();
					unavailableRooms.add(reservation.getRoom().getId());
			}
		}
		for (RoomReservation reservation : reservations) {
			if (rooms.contains(reservation.getRoom())) {
			} 
			else {
				rooms.add(reservation.getRoom());
			}
		}
		Iterator<Room> iter1 = rooms.iterator();
		while (iter1.hasNext()) {
			Room room = iter1.next();
			for (Long id : unavailableRooms) {
				if (room.getId().equals(id)) {
					iter1.remove();
				}
			}
			if (room.getNumOfBeds() < Integer.parseInt(numberOfBeds)) {
				iter1.remove();
			}
		}
		return rooms;
	}


	@Override
	public boolean delete(Long id) {
		try {
			roomReservationRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;	
		}
	}
	

	public Boolean saveReservation(RoomReservationDTO reservationDTO) {

		RoomReservation reservation = new RoomReservation();
		Room room = hotelService.findRoomById(reservationDTO.getRoomId());
		User user = userService.getLoggedUser();
		reservation.setCustomer(user);
		try {
			reservation.setStartDate(reservationDTO.getDateFrom());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reservation.setEndDate(reservationDTO.getDateUntil());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reservation.setRoom(room);
		reservation.setPrice(room.getPrice());
		reservation.setNumOfGuests(room.getNumOfBeds());
		if (room != null && user!=null) {
			roomReservationRepository.save(reservation);
			return true;
		}
		return false;
	}

	@Override
	public List<RoomReservationDTO> getReservationsByUserID(long id) {
		List<RoomReservation> reservations = new ArrayList<RoomReservation>();
		List<RoomReservationDTO> reservationsDTO = new ArrayList<RoomReservationDTO>();

		reservations = roomReservationRepository.findAll();

		Iterator<RoomReservation> iterator = reservations.iterator();
		while (iterator.hasNext()) {
			RoomReservation reservation = iterator.next();
			if (reservation.getCustomer().getId() != id) {
				iterator.remove();
			}
		}
		for(RoomReservation r: reservations) {
			RoomReservationDTO roomDto = new RoomReservationDTO();
			roomDto.setId(r.getId());
			roomDto.setHotelName(r.getRoom().getHotel().getName());
			roomDto.setRoomId(r.getRoom().getId());
			roomDto.setDateFrom(r.getStartDate().toString().split(" ")[0]);
			roomDto.setDateUntil(r.getEndDate().toString().split(" ")[0]);
			reservationsDTO.add(roomDto);
		}

		return reservationsDTO;

	}

}

