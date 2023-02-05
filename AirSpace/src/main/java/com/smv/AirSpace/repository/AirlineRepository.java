package com.smv.AirSpace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.smv.AirSpace.model.Airline;


public interface AirlineRepository extends Repository<Airline, Long>{
	
	Airline findByName(String name);
	
	List<Airline> findAll();

	Airline save(Airline airline);

	void deleteAll();
	
	@Query("select name from Airline")
	List<String> getAllNames();


}
