package com.smv.AirSpace.service;


import com.smv.AirSpace.dto.FlightDTO;
import com.smv.AirSpace.model.Flight;
import com.smv.AirSpace.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public boolean addFlight(Flight flight) {

        try {
            flightRepository.save(flight);
        } catch (Exception e){
            return  false;
        }
        return true;
    }
}
