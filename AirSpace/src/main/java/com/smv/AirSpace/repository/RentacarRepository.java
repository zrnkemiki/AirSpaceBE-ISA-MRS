package com.smv.AirSpace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.smv.AirSpace.model.Rentacar;

public interface RentacarRepository extends JpaRepository<Rentacar, Long> {
	
	Rentacar findByName(String name);
	
	List<Rentacar> findAll();

	Rentacar save(Rentacar airline);
	
	@Query("select name from Rentacar")
	List<String> getAllNames();

	void deleteAll();


}
