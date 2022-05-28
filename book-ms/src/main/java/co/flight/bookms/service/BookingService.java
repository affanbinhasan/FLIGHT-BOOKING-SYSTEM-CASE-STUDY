package co.flight.bookms.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import co.flight.bookms.exception.NoBookingFoundException;
import co.flight.bookms.exception.NoFlightFoundException;
import co.flight.bookms.model.Booking;
import co.flight.bookms.model.Flight;
import co.flight.bookms.model.User;
import co.flight.bookms.repository.BookingRepo;

@Component
public class BookingService {
    @Autowired
    BookingRepo BookingRepo;

    @Autowired
    private RestTemplate restTemplate;

    // @GetMapping("/getuser")
    // public List<User> getusers(){
    //     return BookingRepo.findAll();
    // }

    // @PostMapping("/adduser")
    // public User addUser(@RequestBody User user){
    //     BookingRepo.save(user);
    //     return user;
    // }

    
    public String getBooking(User user,String id){

        try {

            Flight flight = restTemplate.getForObject("http://flight-search-ms/flight/getflight/"+id, Flight.class);

            if (flight == null) {
                throw new NoFlightFoundException("Unable to get Flight details against id :" + id );
            } else {

                Flight bookflight = restTemplate.getForObject("http://flight-search-ms/flight/updateflight/"+id, Flight.class);
                User user_dum = user;
                String uniqueID = UUID.randomUUID().toString();
                Booking booking = new Booking(uniqueID, flight, user_dum, "booked");
                BookingRepo.save(booking);
                return uniqueID;

            }
            
        } catch (NoFlightFoundException e) {
            System.out.println(e.getMessage());
        }

        return "operation not performed check for errors";
        
    }

    
    public List<Booking> getFlight(){
        
        try {
            List<Booking> bookings = BookingRepo.findAll();
            if (bookings == null) {
                throw new RuntimeException("Error Fetching Booking data");
            } else {
                return BookingRepo.findAll();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    
    public Booking getCheckIn(String id){
        try {
            Booking booking = BookingRepo.getBookingbyId(id);
            if (booking == null){
                throw new NoBookingFoundException("No Booking Available Against This Id");
            }
            else{
                return booking;
            }
        } catch (NoBookingFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Flight doCheckIn(String id){
        try {
            Flight flight = restTemplate.getForObject("http://flight-search-ms/flight/admin/avail/"+id, Flight.class);

            if(flight == null){
                throw new NoFlightFoundException("Unable to get Flight against id : " + id );
            }
            else{
                return flight;
            }
        } catch (NoFlightFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
}
