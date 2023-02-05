package com.smv.AirSpace.service;

import java.util.List;

import com.smv.AirSpace.model.Airline;


public interface AirlineService {
	
	public void saveAirline();
	public List<Airline> getAll();
	public List<String> getAllNames();

}
