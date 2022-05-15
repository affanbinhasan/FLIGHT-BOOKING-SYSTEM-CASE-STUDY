package co.flight.searchms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.flight.searchms.model.Flight;
import co.flight.searchms.repository.FlightRepo;

@RestController
public class FlightController {
    @Autowired
    FlightRepo FlightRepo;

    @GetMapping("/getflight")
    public List<Flight> getflight(){
        return FlightRepo.findAll();
    }

    @PostMapping("/addflight")
    public Flight addFlight(@RequestBody Flight flight){
        FlightRepo.save(flight);
        return flight;
    }
}
