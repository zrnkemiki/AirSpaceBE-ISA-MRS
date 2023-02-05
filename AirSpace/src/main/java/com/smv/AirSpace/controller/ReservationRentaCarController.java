package com.smv.AirSpace.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.ReservationRentaCarDTO;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.ReservationRentaCar;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.Vehicle;
import com.smv.AirSpace.service.RentacarServiceImpl;
import com.smv.AirSpace.service.ReservationRentaCarService;
import com.smv.AirSpace.service.UserServiceImpl;
import com.smv.AirSpace.service.VehicleService;

@RestController
@RequestMapping(value = "/reservationRentaCar")
public class ReservationRentaCarController {

	@Autowired
	ReservationRentaCarService reservationRentaCarService;

	@Autowired
	RentacarServiceImpl rentaCarService;

	@Autowired
	VehicleService vehicleService;

	@Autowired
	UserServiceImpl userService;

	@GetMapping(value = "/getVehicleByRentaCarId/{dateFrom}/{dateUntil}/{numberOfSeats}/{city}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getReservationsByRentaCarID(@PathVariable("dateFrom") String dateFrom,
			@PathVariable("dateUntil") String dateUntil, @PathVariable("numberOfSeats") String numberOfseats,
			@PathVariable("city") String city, @PathVariable("id") Long id) throws ParseException {
		return new ResponseEntity<List<Vehicle>>(
				reservationRentaCarService.getReservationsByRentaCarID(dateFrom, dateUntil, numberOfseats, city, id),
				HttpStatus.OK);
	}

	@GetMapping(value = "/getVehicleByDateAndHotelName/{dateFrom}/{dateUntil}/{hotelName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicleByDateAndHotelId(@PathVariable("dateFrom") String dateFrom,
			@PathVariable("dateUntil") String dateUntil, @PathVariable("hotelName") String hotelName) throws ParseException {
		return new ResponseEntity<List<Vehicle>>(
				reservationRentaCarService.getReservationsByHotelLocation(dateFrom, dateUntil, hotelName), HttpStatus.OK);
	}
	@PreAuthorize("hasAuthority('REGISTERED_USER')")
	@GetMapping(value = "/getReservationByUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getReservationByUser() {
		User user = userService.getLoggedUser();
		return new ResponseEntity<List<ReservationRentaCar>>(
				reservationRentaCarService.getReservationsByUserID(user.getId()), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@GetMapping(value = "/getReservationReport/{dateFrom}/{dateUntil}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getReservationReport(@PathVariable("dateFrom") String dateFrom,
			@PathVariable("dateUntil") String dateUntil, @PathVariable("id") Long id) throws ParseException {
		return new ResponseEntity<List<ReservationRentaCar>>(
				reservationRentaCarService.getReservationReport(dateFrom, dateUntil, id), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ReservationRentaCar> addReservation(@RequestBody ReservationRentaCarDTO reservationDTO)
			throws ParseException {
		ReservationRentaCar reservation = new ReservationRentaCar();
		Vehicle vehicle = vehicleService.findByID(reservationDTO.getVehicleId());
		Rentacar rentaCar = vehicle.findRentaCar();
		User user = userService.getLoggedUser();
		int totalPrice;
		long dateDiff;
		dateDiff = reservationDTO.getDateUntil().getTime() - reservationDTO.getDateFrom().getTime();
		totalPrice = ((int) (dateDiff / (1000 * 60 * 60 * 24))) * vehicle.getPricePerDay();

		reservation.setUser(user);
		reservation.setDateFrom(reservationDTO.getDateFrom());
		reservation.setDateUntil(reservationDTO.getDateUntil());
		reservation.setRentacar(rentaCar);
		reservation.setVehicle(vehicle);

		reservation.setTotalPrice(totalPrice);

		reservation = reservationRentaCarService.saveReservation(reservation);
		return new ResponseEntity<ReservationRentaCar>(reservation, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAnyAuthority('REGISTERED_USER','RENTACAR_ADMIN')")
	@DeleteMapping(value = "/{param}")
	public ResponseEntity<Void> deleteReservation(@PathVariable("param") Long id) {
		reservationRentaCarService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
