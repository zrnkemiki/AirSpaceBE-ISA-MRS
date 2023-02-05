package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.VehicleDTO;
import com.smv.AirSpace.model.BranchOffice;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.Vehicle;
import com.smv.AirSpace.service.RentacarServiceImpl;
import com.smv.AirSpace.service.VehicleService;


@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	RentacarServiceImpl rentaCarService;

	// Create new vehicle.
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@PostMapping( consumes = "application/json")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleDTO vehicleDTO, Principal principal) {		
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		//List<BranchOffice>offices = rentaCar.getBranchOffices();
		for (BranchOffice office : rentaCar.getBranchOffices()) {
			if(office.getId().intValue()==vehicleDTO.getIdOffice().intValue()) {
				vehicleDTO.setBranchOffice(office);
			}
		}		
		vehicleDTO.setRentacar(rentaCar);
		Vehicle vehicle = vehicleService.saveVehicle(vehicleDTO, principal);		
		rentaCar.getVehicles().add(vehicle);
		rentaCarService.saveRentacar(rentaCar);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}
	/*
	 * TREBA URADITI ZA OBICNOG KORISNIKA!!!
	// Get all vehicles
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicles() {
		try {
			return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicles(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	*/
	// Get all vehicles
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicles(Principal principal) {
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		try {
			return new ResponseEntity<List<Vehicle>>(rentaCar.getVehicles(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@RequestMapping(value="/getVehicleByModel/{searchParam}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicleByModel(@PathVariable String searchParam, Principal principal) {
		return new ResponseEntity<List<Vehicle>>(vehicleService.findByModel(searchParam, principal), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@RequestMapping(value="/getVehicleByGearBox/{searchParam}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicleByGearBox(@PathVariable String searchParam, Principal principal) {
		return new ResponseEntity<List<Vehicle>>(vehicleService.findByGearBox(searchParam, principal), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{param}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getVehicle(@PathVariable("param") Long id) {
		return new ResponseEntity<Vehicle>(vehicleService.findByID(id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@PutMapping()
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleDTO vehicle, Principal principal ) {
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		for (BranchOffice office : rentaCar.getBranchOffices()) {
			if(office.getId()==vehicle.getIdOffice()) {
				vehicle.setBranchOffice(office);
			}
		}		
		vehicle.setRentacar(rentaCar);
		return new ResponseEntity<Vehicle>(vehicleService.update(vehicle, principal), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@DeleteMapping(value = "/{param}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable("param") Long id, Principal principal) {
		vehicleService.delete(id, principal);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	

}
