package com.smv.AirSpace.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.RoomDTO;
import com.smv.AirSpace.dto.RoomReservationDTO;
import com.smv.AirSpace.model.Room;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.service.HotelService;
import com.smv.AirSpace.service.RoomReservationService;
import com.smv.AirSpace.service.UserService;

@RestController
@RequestMapping(value = "/room-reservation")
public class RoomReservationController {
	
	@Autowired
	RoomReservationService roomReservationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HotelService hotelService;

	@RequestMapping(value = "/get-avalaible-rooms/{hotelName}/{dateFrom}/{dateUntil}/{numberOfBeds}", method = RequestMethod.GET)
	public ResponseEntity<List<RoomDTO>> getReservations(@PathVariable("hotelName") String hotelName, @PathVariable("dateFrom") String dateFrom, @PathVariable("dateUntil")  String dateUntil,
			@PathVariable("numberOfBeds") String numberOfBeds) {
		
			List<Room> rooms = new ArrayList<>();
			List<RoomDTO> roomDTOs = new ArrayList<>();
			try {

				rooms = roomReservationService.getRoomReservations(hotelName, dateFrom, dateUntil, numberOfBeds);
				if (rooms != null) {
					roomDTOs = Helpers.Converter.convertRoomToRoomDTO(rooms);
					return new ResponseEntity<List<RoomDTO>>(roomDTOs, HttpStatus.OK);
				}
				return new ResponseEntity<List<RoomDTO>>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<List<RoomDTO>>(HttpStatus.BAD_REQUEST);
			}
	}
	
	@RequestMapping(value = "/get-reservation-user", method = RequestMethod.GET)
	public ResponseEntity<List<RoomReservationDTO>> getReservationByUser(){
		User user = userService.getLoggedUser();
		List<RoomReservationDTO> reservations = new ArrayList<>();
		try {

			reservations = roomReservationService.getReservationsByUserID(user.getId());
			if (reservations != null) {
				return new ResponseEntity<List<RoomReservationDTO>>(reservations, HttpStatus.OK);
			}
			return new ResponseEntity<List<RoomReservationDTO>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<RoomReservationDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/reserve-room", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addReservation(@RequestBody RoomReservationDTO reservationDTO) throws ParseException {	
		try {

			boolean retValue = roomReservationService.saveReservation(reservationDTO);		

			if (retValue)
				return new ResponseEntity<Boolean>(retValue, HttpStatus.CREATED);

			return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);

		}

		catch (Exception e) {

			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteRoom(@PathVariable("id") Long id) {

		boolean retValue;

		try {

			retValue = roomReservationService.delete(id);
			if (retValue)
				return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);
			return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);

		}
	}
	

}
