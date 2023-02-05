package com.smv.AirSpace.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.smv.AirSpace.model.Room;

public interface RoomRepository  extends Repository<Room, Long> {
		
	List<Room> findAll();

	Room save(Room room);

	void deleteById(Long id);

	Room findById(Long id);

}
