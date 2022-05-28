package co.flight.searchms.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.flight.searchms.repository.FlightRepo;
import co.flight.searchms.exception.NoFlightFoundException;
import co.flight.searchms.model.Flight;

@Component
public class FlightService {
    
    @Autowired
    FlightRepo FlightRepo;

    
    public List<Flight> getFlight(){
        try {
            List<Flight> flights = FlightRepo.findAll();
            if(flights.isEmpty()){
                throw new NoFlightFoundException("No Origins Found");
            }
            else{
                return FlightRepo.findAll();
            }
        } catch (NoFlightFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
        
    }

    
    public List<Flight> getFlightByOriginDest(String origin,String destination){
        String orgn = origin.toUpperCase();
        String dest = destination.toUpperCase();
        // return FlightRepo.getMatchingFlight(origin, destination);
        try {
            List<Flight> flights = FlightRepo.getFlightbyOrigin(orgn);
            if(flights.isEmpty()){
                throw new NoFlightFoundException("No Origins Found");
            }
            else{
                List<Flight> flightResulList = flights.stream().filter(m -> dest.equals(m.getFlight_destination())).toList();
                return flightResulList;
            }
            } catch (NoFlightFoundException e) {
                System.out.println(e.getMessage());
            }
        
        return null;
        
    }

    
    public Optional<Flight> getFlightbyId(String id){
        try {
            Optional<Flight> flight = FlightRepo.findById(id);
            if(flight.isPresent()){
                return flight;
            }
            else{
                throw new NoFlightFoundException("failed to fetch flight again id : "+id);
            }
        } catch (NoFlightFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    
    public Flight addFlight(Flight flight){
        FlightRepo.save(flight);
        return flight;
    }

    public Flight bookSeats(String id){
        Optional<Flight> new_flight = FlightRepo.findById(id);
        try {
            if(new_flight.isPresent()){
                Flight getflight = new_flight.get();
    
                int seatUpdate = getflight.getFlight_seat_no() - 1;
                getflight.setFlight_seat_no(seatUpdate);
                FlightRepo.save(getflight);
                return getflight;
            }
            else{
                throw new NoFlightFoundException("failed to fetch flight again id : "+id);
            }
        } catch (NoFlightFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }

    public Flight availSeats(String id){
        Optional<Flight> new_flight = FlightRepo.findById(id);
        if(new_flight.isPresent()){
            Flight getflight = new_flight.get();

            int seatUpdate = getflight.getFlight_seat_no() + 1;
            getflight.setFlight_seat_no(seatUpdate);
            FlightRepo.save(getflight);
            return getflight;
        }
        // else{
        //     return "Data You are Looking For is not present";
        // }
        return null;
        
    }
}
