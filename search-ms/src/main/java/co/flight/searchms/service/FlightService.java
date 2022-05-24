package co.flight.searchms.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.flight.searchms.repository.FlightRepo;
import co.flight.searchms.model.Flight;

@Component
public class FlightService {
    
    @Autowired
    FlightRepo FlightRepo;

    
    public List<Flight> getFlight(){
        return FlightRepo.findAll();
    }

    
    public List<Flight> getFlightByOriginDest(String origin,String destination){
        // String orgn = origin.toUpperCase();
        // String dest = destination.toUpperCase();
        // return FlightRepo.getMatchingFlight(origin, destination);
        List<Flight> flights = FlightRepo.getFlightbyOrigin(origin);
        List<Flight> flightResulList = flights.stream().filter(m -> destination.equals(m.getFlight_destination())).toList();
        return flightResulList;
    }

    
    public Optional<Flight> getFlightbyId(String id){
        return FlightRepo.findById(id);
    }

    
    public Flight addFlight(Flight flight){
        FlightRepo.save(flight);
        return flight;
    }
}
