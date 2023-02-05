package com.smv.AirSpace.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.RentacarDTO;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserType;
import com.smv.AirSpace.repository.RentacarRepository;

import exceptions.RentacarDoesntExistException;
import exceptions.VehicleDoesntExistException;

@Service
public class RentacarServiceImpl implements RentacarService {

	@Autowired
	RentacarRepository rentacarRepository;

	@Autowired
	UserServiceImpl userService;

	@Override
	public void saveRentacar(Rentacar rentacar) {
		rentacarRepository.save(rentacar);
	}

	public Rentacar update(RentacarDTO rentacarDTO) {
		try {
			findByID(rentacarDTO.getId());
			Rentacar rentacar = new Rentacar(rentacarDTO);
			rentacarRepository.save(rentacar);
			return rentacar;
		} catch (Exception e) {
			throw new RentacarDoesntExistException();
		}
	}

	public Optional<Rentacar> findByID(Long id) {
		return rentacarRepository.findById(id);
	}

	@Override
	public List<Rentacar> getAll() {
		return rentacarRepository.findAll();
	}

	@Override
	public List<String> getAllNames() {
		return rentacarRepository.getAllNames();
	}

	public void delete(Long id) {
		try {
			rentacarRepository.deleteById(id);
		} catch (Exception e) {
			throw new VehicleDoesntExistException();
		}

	}

	public Rentacar getLoggedAdminRentacar(Principal principal) {
		User user = userService.getUserByUsername(principal.getName());
		System.err.println(principal.getName());
		if (user != null && user.getUserType() == UserType.RENTACAR_ADMIN) {
			return findByID(user.getCompanyId()).orElse(null);
		}
		return null;
	}

}
