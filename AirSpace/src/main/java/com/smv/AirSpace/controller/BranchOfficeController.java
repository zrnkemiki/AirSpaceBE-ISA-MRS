package com.smv.AirSpace.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Branch;
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
import org.springframework.web.bind.annotation.RestController;

import com.smv.AirSpace.dto.BranchOfficeDTO;
import com.smv.AirSpace.dto.VehicleDTO;
import com.smv.AirSpace.model.BranchOffice;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.Vehicle;
import com.smv.AirSpace.service.BranchOfficeService;
import com.smv.AirSpace.service.RentacarServiceImpl;

@RestController
@RequestMapping(value = "/branchOffice")
public class BranchOfficeController {

	@Autowired
	BranchOfficeService branchOfficeService;

	@Autowired
	RentacarServiceImpl rentaCarService;
	
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@PostMapping( consumes = "application/json")
	public ResponseEntity<BranchOffice> addOffice(@RequestBody BranchOfficeDTO officeDTO, Principal principal) {		
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		//List<BranchOffice>offices = rentaCar.getBranchOffices();			
		officeDTO.setRentacar(rentaCar);
		BranchOffice office = branchOfficeService.saveOffice(officeDTO);		
		rentaCar.getBranchOffices().add(office);
		rentaCarService.saveRentacar(rentaCar);
		//System.out.println(office.getId());
		return new ResponseEntity<BranchOffice>(office, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@GetMapping(value = "/{param}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBranchOffice(@PathVariable("param") Long id) {
		return new ResponseEntity<BranchOffice>(branchOfficeService.findByID(id), HttpStatus.OK);
	}
	

	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@GetMapping("/admin")
	public List<BranchOffice> getBranchOffices(Principal principal) {
		//System.out.println("USAO U GETBRANCHOFFICE");
		List<BranchOffice> branchOffices = new ArrayList<BranchOffice>();
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		branchOffices = rentaCar.getBranchOffices();
		return branchOffices;

	}
	@PreAuthorize("hasAuthority('RENTACAR_ADMIN')")
	@DeleteMapping(value = "/{param}")
	public ResponseEntity<Void> deleteOffice(@PathVariable("param") Long id) {
		branchOfficeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<BranchOffice> updateOffice(@RequestBody BranchOfficeDTO officeDTO, Principal principal ) {
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);		
		officeDTO.setRentacar(rentaCar);
		return new ResponseEntity<BranchOffice>(branchOfficeService.update(officeDTO), HttpStatus.OK);
	}

}
