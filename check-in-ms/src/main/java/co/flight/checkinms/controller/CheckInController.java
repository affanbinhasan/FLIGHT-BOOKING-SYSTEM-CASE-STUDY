package co.flight.checkinms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.flight.checkinms.model.Booking;
import co.flight.checkinms.model.CheckIn;
import co.flight.checkinms.repository.CheckInRepo;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flight-check-in")
public class CheckInController {
    
    @Autowired
    CheckInRepo CheckInrepo;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/check-in/{id}")
    public Booking getCheckIn(@PathVariable String id){
        Booking booking = restTemplate.getForObject("http://flight-booking-ms/booking/book/"+id, Booking.class);
        CheckIn checkIn = new CheckIn("ch01",booking,"28a");
        //CheckInrepo.save(checkIn);
        return booking;
    }

    @GetMapping("/getcheck-in")
    public List<CheckIn> getAllCheckIn(){
        return CheckInrepo.findAll();
    }
}
