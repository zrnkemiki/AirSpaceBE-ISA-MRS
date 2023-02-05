package com.smv.AirSpace.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.dto.BranchOfficeDTO;
import com.smv.AirSpace.model.BranchOffice;
import com.smv.AirSpace.repository.BranchOfficeRepository;

import exceptions.BranchOfficeDoesntExist;

@Service
public class BranchOfficeService {
	
	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	
	public void delete(Long id) {
		//System.out.println("Ovo je id" + id);
		try {
			branchOfficeRepository.deleteById(id);
		} catch (Exception e) {
			throw new BranchOfficeDoesntExist();
		}
	}
	
	

	public BranchOffice saveOffice(BranchOfficeDTO officeDTO) {
		BranchOffice office = new BranchOffice(officeDTO);
		/*
		if(vehicleRepository.findById(vehicle.getId())!=null){
			vehicleRepository.save(vehicle);
			throw new VehicleAlreadyExistsException();
			
		}
		*/
		return branchOfficeRepository.save(office);
	}
	
	public BranchOffice update(BranchOfficeDTO officeDTO) {
		try {
			findByID(officeDTO.getId());
			BranchOffice office = new BranchOffice(officeDTO);
			branchOfficeRepository.save(office);
			return office;
		} catch (Exception e) {
			throw new BranchOfficeDoesntExist();
		}
		
		
	}

	public BranchOffice findByID(Long id) {
		Optional<BranchOffice> rets = branchOfficeRepository.findById(id);
		if(!rets.isPresent()) {
			throw new BranchOfficeDoesntExist();
		}
		return rets.get();
	}
	


}
