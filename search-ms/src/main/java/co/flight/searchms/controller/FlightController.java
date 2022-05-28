package co.flight.searchms.controller;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.flight.searchms.model.Flight;
import co.flight.searchms.repository.FlightRepo;
import co.flight.searchms.service.FlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightService FlightService;

    @GetMapping("/admin/getflight")
    public List<Flight> getFlight(){
        return FlightService.getFlight();
    }

    @GetMapping("/getflight/{origin}/{destination}")
    public List<Flight> getFlightByOriginDest(@PathVariable String origin,@PathVariable String destination){
        return FlightService.getFlightByOriginDest(origin, destination);
    }

    @GetMapping("/getflight/{id}")
    public Optional<Flight> getFlightbyId(@PathVariable String id){
        return FlightService.getFlightbyId(id);
    }

    @PostMapping("/admin/addflight")
    public Flight addFlight(@RequestBody Flight flight){
        return FlightService.addFlight(flight);
    }

    @GetMapping("/admin/avail/{id}")
    public Flight addFlight(@PathVariable String id){
        return FlightService.availSeats(id);
    }

    @GetMapping("/updateflight/{id}")
    public Flight updateSeat(@PathVariable String id){
        FlightService.bookSeats(id);
        Optional<Flight> newFlight = FlightService.getFlightbyId(id);
        Flight getFlight = newFlight.get();
        return getFlight;
    }
}
