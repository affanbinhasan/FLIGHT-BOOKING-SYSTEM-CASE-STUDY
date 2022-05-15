package co.flight.searchms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<Flight> getFlight(){
        return FlightRepo.findAll();
    }

    @GetMapping("/getflight/{id}")
    public Optional<Flight> getFlightbyId(@PathVariable String id){
        return FlightRepo.findById(id);
    }

    @PostMapping("/addflight")
    public Flight addFlight(@RequestBody Flight flight){
        FlightRepo.save(flight);
        return flight;
    }
}
