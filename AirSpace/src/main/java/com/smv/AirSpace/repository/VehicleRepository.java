package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smv.AirSpace.model.Vehicle;

@org.springframework.stereotype.Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	/*
	Vehicle findByName(String name);
	
	List<Vehicle> findAll();

	Vehicle save(Vehicle vehicle);

	void deleteAll();

*/
}