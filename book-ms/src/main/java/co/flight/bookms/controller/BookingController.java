package co.flight.bookms.controller;

import java.util.List;
import java.util.Optional;

// import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.flight.bookms.model.Booking;
import co.flight.bookms.model.Flight;
import co.flight.bookms.model.User;
import co.flight.bookms.repository.BookingRepo;

// @Component
@RestController
public class BookingController {

    // @RabbitListener(queues = RabbitMQConfiguration.QUEUE)
    // @GetMapping("/testrecieve")
    // public String listener(Flight flight){
    //     return flight.toString();
    // }

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

    @PostMapping("/book")
    public Booking getBooking(@RequestBody User user){
        Flight flight = restTemplate.getForObject("http://flight-search-ms/getflight/test", Flight.class);
        User user_dum = user;
        Booking booking = new Booking("3", flight, user_dum, 200);
        BookingRepo.save(booking);
        return booking;
    }

    @GetMapping("/getbooking")
    public List<Booking> getFlight(){
        return BookingRepo.findAll();
    }

    @GetMapping("/book/{id}")
    public Booking getCheckIn(@PathVariable String id){
        
        return BookingRepo.getBookingbyId(id);
    }
   
}
