package co.flight.bookms.controller;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.flight.bookms.configuration.RabbitMQConfiguration;
import co.flight.bookms.model.Flight;
import co.flight.bookms.model.User;
import co.flight.bookms.repository.BookingRepo;

// @Component
@RestController("/book")
public class BookingController {

    // @RabbitListener(queues = RabbitMQConfiguration.QUEUE)
    // @GetMapping("/testrecieve")
    // public String listener(Flight flight){
    //     return flight.toString();
    // }

    @Autowired
    BookingRepo BookingRepo;

    @GetMapping("/getuser")
    public List<User> getusers(){
        return BookingRepo.findAll();
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        BookingRepo.save(user);
        return user;
    }

    
}
