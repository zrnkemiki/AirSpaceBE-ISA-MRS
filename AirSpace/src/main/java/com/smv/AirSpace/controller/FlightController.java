package com.smv.AirSpace.controller;


import com.smv.AirSpace.dto.FlightDTO;
import com.smv.AirSpace.model.Flight;
import com.smv.AirSpace.service.FlightService;
import com.smv.AirSpace.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flightController")
public class FlightController {

    @Autowired
    FlightServiceImpl flightService;


    @RequestMapping(value = "/add_flight", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addFlight(@RequestBody FlightDTO flightDTO){
        boolean added = true;
        System.out.println("kontroler");
        added = flightService.addFlight(new Flight(flightDTO));

        return new ResponseEntity<Boolean>(added,HttpStatus.OK);
    }
}
