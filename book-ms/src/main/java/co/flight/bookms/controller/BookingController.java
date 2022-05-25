package co.flight.bookms.controller;

import java.util.List;


// import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.flight.bookms.model.Booking;
import co.flight.bookms.model.User;
import co.flight.bookms.service.BookingService;

import org.springframework.web.bind.annotation.CrossOrigin;

// @Component
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService BookingService;

    @PostMapping("/book/{id}")
    public String getBooking(@RequestBody User user,@PathVariable String id){
        
        return BookingService.getBooking(user, id);
    }

    @GetMapping("/getbooking")
    public List<Booking> getFlight(){
        return BookingService.getFlight();
    }

    @GetMapping("/book/{id}")
    public Booking getCheckIn(@PathVariable String id){
        
        return BookingService.getCheckIn(id);
    }
   
}
