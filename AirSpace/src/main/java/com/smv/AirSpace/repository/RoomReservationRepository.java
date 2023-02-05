package com.smv.AirSpace.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.smv.AirSpace.model.RoomReservation;


public interface RoomReservationRepository extends Repository<RoomReservation, Long> {
	
	List<RoomReservation> findAll();

	RoomReservation save(RoomReservation RoomReservation);

	void deleteById(Long id);

	RoomReservation findById(Long id);

}
