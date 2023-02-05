package com.smv.AirSpace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smv.AirSpace.model.Airline;
import com.smv.AirSpace.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	AirlineRepository airlineRepository;
	
	public void saveAirline() {
		
	}
	public List<Airline> getAll(){
		return airlineRepository.findAll();
	}
	public List<String> getAllNames() {
		return airlineRepository.getAllNames();
	}

}
