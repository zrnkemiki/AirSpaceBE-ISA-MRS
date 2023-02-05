package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.RentacarDTO;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.service.RentacarServiceImpl;
import com.smv.AirSpace.service.UserServiceImpl;

import exceptions.RentacarDoesntExistException;

@RestController
@RequestMapping(value = "/rentacar")
public class RentACarController {

	@Autowired
	RentacarServiceImpl rentaCarService;

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/admin")
	public ResponseEntity<?> getLoggedUserRentaCarCompany(Principal principal) {

		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		if (rentaCar != null) {
			return new ResponseEntity<RentacarDTO>(new RentacarDTO(rentaCar), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/{param}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRentaCar(@PathVariable("param") Long id) {
		Optional<Rentacar> rentaCar = rentaCarService.findByID(id);
		if (!rentaCar.isPresent()) {
			throw new RentacarDoesntExistException();
		}
		return new ResponseEntity<Rentacar>(rentaCar.get(), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Rentacar> updateRentACar(@RequestBody RentacarDTO rentaCar) {
		return new ResponseEntity<Rentacar>(rentaCarService.update(rentaCar), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{param}")
	public ResponseEntity<?> deleteRentACar(@PathVariable("param") Long id) {
		rentaCarService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
