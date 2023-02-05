package com.smv.AirSpace.repository;

import com.smv.AirSpace.model.Flight;
import org.springframework.data.repository.Repository;

public interface FlightRepository extends Repository<Flight,Long> {

    Flight save(Flight flight);

}
