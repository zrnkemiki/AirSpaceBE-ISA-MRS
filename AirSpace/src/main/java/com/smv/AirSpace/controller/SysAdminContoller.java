package com.smv.AirSpace.controller;

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

import com.smv.AirSpace.dto.AirlineDTO;
import com.smv.AirSpace.dto.AirlineFrontDTO;
import com.smv.AirSpace.dto.HotelDTO;
import com.smv.AirSpace.dto.HotelFrontDTO;
import com.smv.AirSpace.dto.RentacarDTO;
import com.smv.AirSpace.dto.RentacarFrontDTO;
import com.smv.AirSpace.dto.UserDTO;
import com.smv.AirSpace.model.Airline;
import com.smv.AirSpace.model.Hotel;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.UserType;
import com.smv.AirSpace.service.AirlineService;
import com.smv.AirSpace.service.HotelService;
import com.smv.AirSpace.service.RentacarService;
import com.smv.AirSpace.service.UserService;

@RestController
@RequestMapping(value = "/sys_admin")

public class SysAdminContoller {

	@Autowired
	UserService userService;

	@Autowired
	HotelService hotelService;
	
	@Autowired
	AirlineService airlineService;
	
	@Autowired
	RentacarService rentacarService;

	@RequestMapping(value = "/get_hotels", method = RequestMethod.GET)
	public ResponseEntity<List<HotelFrontDTO>> getHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		List<HotelFrontDTO> hotelsDTOs = new ArrayList<>();
		try {
			hotels = hotelService.getAll();
			if (hotels != null) {
				hotelsDTOs = Helpers.Converter.ConvertHotelToHotelDTOs(hotels);
				return new ResponseEntity<List<HotelFrontDTO>>(hotelsDTOs, HttpStatus.OK);
			}
			return new ResponseEntity<List<HotelFrontDTO>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<HotelFrontDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get_airlines", method = RequestMethod.GET)
	public ResponseEntity<List<AirlineFrontDTO>> getAirlines() {
		List<Airline> airlines = new ArrayList<Airline>();
		try {
			airlines = airlineService.getAll();
			if (airlines != null)
				return new ResponseEntity<List<AirlineFrontDTO>>(Helpers.Converter.convertAirlineToAirlineFrontDTOs(airlines), HttpStatus.OK);
			return new ResponseEntity<List<AirlineFrontDTO>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<AirlineFrontDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	@RequestMapping(value = "/get_rentacars", method = RequestMethod.GET)
	public ResponseEntity<List<RentacarFrontDTO>> getRentacars() {
		List<Rentacar> rentacars = new ArrayList<Rentacar>();
		try {
			rentacars = rentacarService.getAll();
			if (rentacars != null)
				return new ResponseEntity<List<RentacarFrontDTO>>(Helpers.Converter.convertRentacarToRentacarFrontDTOs(rentacars), HttpStatus.OK);
			return new ResponseEntity<List<RentacarFrontDTO>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<RentacarFrontDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/get_rentacar_names", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getRentacarNames() {
		List<String> rentacars = new ArrayList<>();
		try {
			rentacars = rentacarService.getAllNames();
			if (rentacars != null)
				return new ResponseEntity<List<String>>(rentacars, HttpStatus.OK);
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get_hotel_names", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getHotelNames() {
		List<String> hotels = new ArrayList<>();
		try {
			hotels = hotelService.getAllNames();
			if (hotels != null)
				return new ResponseEntity<List<String>>(hotels, HttpStatus.OK);
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/get_airline_names", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAirlineNames() {
		List<String> airlines = new ArrayList<>();
		try {
			airlines = airlineService.getAllNames();
			if (airlines != null)
				return new ResponseEntity<List<String>>(airlines, HttpStatus.OK);
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/add_admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addAdmin(@RequestBody UserDTO userDTO) {
		Long companyId;
		if (userDTO.getUserType() != UserType.SYS_ADMIN) {
			companyId = userService.findCompanydId(userDTO.getCompanyName(), userDTO.getUserType());
		}
		else {
			companyId = null;
		}
		try {
			boolean retValue = userService.saveAdmin(userDTO.getUsername(), userDTO.getEmail(), userDTO.getUserType(),
					companyId);
			if (retValue)
				return new ResponseEntity<Boolean>(retValue, HttpStatus.CREATED);
			return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/add_hotel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addHotel(@RequestBody HotelDTO hotelDTO) {
		try {

			boolean retValue = userService.saveHotel(hotelDTO);

			if (retValue)
				return new ResponseEntity<Boolean>(retValue, HttpStatus.CREATED);

			return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);

		}

		catch (Exception e) {

			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/add_airline", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addAirline(@RequestBody AirlineDTO airlineDTO) {
		try {

			boolean retValue = userService.saveAirline(airlineDTO);

			if (retValue)
				return new ResponseEntity<Boolean>(retValue, HttpStatus.CREATED);

			return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);

		}

		catch (Exception e) {

			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/add_rentacar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addRentacar(@RequestBody RentacarDTO rentacarDTOD) {
		try {

			boolean retValue = userService.saveRentacar(rentacarDTOD);

			if (retValue)
				return new ResponseEntity<Boolean>(retValue, HttpStatus.CREATED);

			return new ResponseEntity<Boolean>(retValue, HttpStatus.OK);

		}

		catch (Exception e) {

			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/search_by_name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<HotelFrontDTO>> searchByName(@PathVariable("name") String name) {
    	List<Hotel> hotels = hotelService.searchByName(name);
    	List<HotelFrontDTO> hotelsFront = new ArrayList<>();
    	for (Hotel hotel: hotels) {
    		hotelsFront.add(new HotelFrontDTO(hotel));
    	}
    	return new ResponseEntity<List<HotelFrontDTO>>(hotelsFront, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/search_by_city/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<HotelFrontDTO>> searchByCity(@PathVariable("name") String name) {
    	List<Hotel> hotels = hotelService.searchByCity(name);
    	List<HotelFrontDTO> hotelsFront = new ArrayList<>();
    	for (Hotel hotel: hotels) {
    		hotelsFront.add(new HotelFrontDTO(hotel));
    	}
    	return new ResponseEntity<List<HotelFrontDTO>>(hotelsFront, HttpStatus.OK);
    }


}
