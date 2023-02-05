package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.VehicleDTO;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.ReservationRentaCar;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.Vehicle;
import com.smv.AirSpace.repository.VehicleRepository;

import exceptions.VehicleDoesntExistException;
import exceptions.VehicleUsedInReservationsException;
import javassist.expr.NewArray;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	RentacarServiceImpl rentaCarService;

	@Autowired
	UserServiceImpl userService;

	@Autowired
	ReservationRentaCarService reservationService;

	public Vehicle saveVehicle(VehicleDTO vehicleDTO, Principal principal) {
		User user = userService.getUserByUsername(principal.getName());
		Vehicle vehicle = new Vehicle(vehicleDTO, user.getId());
		/*
		 * if(vehicleRepository.findById(vehicle.getId())!=null){
		 * vehicleRepository.save(vehicle); throw new VehicleAlreadyExistsException();
		 * 
		 * }
		 */

		return vehicleRepository.save(vehicle);
	}

	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();

	}

	public void delete(Long id, Principal principal) {
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		List<ReservationRentaCar> reservations = new ArrayList<ReservationRentaCar>();
		List<Long> vehiclesForrbiden = new ArrayList<>();
		reservations = reservationService.getReservationsByRentaCar(rentaCar.getId());
		Vehicle vehicle = findByID(id);

		for (ReservationRentaCar reservationRentaCar : reservations) {
			if (reservationRentaCar.getVehicle().getId() == id) {
				vehiclesForrbiden.add(id);
			}
		}
		
		if (vehiclesForrbiden.contains(id)) {
			vehicle.setAvailable(false);
			vehicleRepository.save(vehicle);
			throw new VehicleUsedInReservationsException();
		}

		try {
			vehicleRepository.deleteById(id);
		} catch (Exception e) {
			throw new VehicleDoesntExistException();
		}

	}

	public List<Vehicle> findByGearBox(String searchParam, Principal principal) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> rets = new ArrayList<Vehicle>();
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		vehicles = vehicleRepository.findAll();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getGearBox().toLowerCase().contains(searchParam.toLowerCase())
					& vehicle.findRentaCar().getId() == rentaCar.getId()) {
				rets.add(vehicle);
			}
		}
		return rets;
	}

	public List<Vehicle> findByModel(String searchParam, Principal principal) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> rets = new ArrayList<Vehicle>();
		Rentacar rentaCar = rentaCarService.getLoggedAdminRentacar(principal);
		vehicles = vehicleRepository.findAll();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getModel().toLowerCase().contains(searchParam.toLowerCase())
					& vehicle.findRentaCar().getId() == rentaCar.getId()) {
				rets.add(vehicle);
			}
		}
		return rets;
	}

	public Vehicle findByID(Long id) {
		Optional<Vehicle> rets = vehicleRepository.findById(id);
		if (!rets.isPresent()) {
			throw new VehicleDoesntExistException();
		}
		return rets.get();
	}

	public Vehicle update(VehicleDTO vehicleDTO, Principal principal) {
		User user = userService.getUserByUsername(principal.getName());
		try {
			findByID(vehicleDTO.getId());
			Vehicle vehicle = new Vehicle(vehicleDTO, user.getId());
			vehicleRepository.save(vehicle);
			return vehicle;
		} catch (Exception e) {
			throw new VehicleDoesntExistException();
		}

	}

	public List<Vehicle> getByRentaCar(Long id) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles = vehicleRepository.findAll();
		Iterator<Vehicle> iterator = vehicles.iterator();
		while (iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			if (vehicle.findRentaCar().getId() != id) {
				iterator.remove();
			}
		}
		return vehicles;
	}
	


}
