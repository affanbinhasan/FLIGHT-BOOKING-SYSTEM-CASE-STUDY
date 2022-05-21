package co.flight.bookms.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

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

    
    public Booking getBooking(User user,String id){
        Flight flight = restTemplate.getForObject("http://flight-search-ms/flight/getflight/"+id, Flight.class);
        User user_dum = user;
        String uniqueID = UUID.randomUUID().toString();
        Booking booking = new Booking(uniqueID, flight, user_dum, 200);
        BookingRepo.save(booking);
        return booking;
    }

    
    public List<Booking> getFlight(){
        return BookingRepo.findAll();
    }

    
    public Booking getCheckIn(String id){
        
        return BookingRepo.getBookingbyId(id);
    }
}
