package co.flight.checkinms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.flight.checkinms.model.Booking;
import co.flight.checkinms.model.CheckIn;
import co.flight.checkinms.repository.CheckInRepo;

import java.util.*;

@RestController
public class CheckInController {
    
    @Autowired
    CheckInRepo CheckInrepo;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/check-in/{id}")
    public CheckIn getCheckIn(@PathVariable String id){
        Booking booking = restTemplate.getForObject("http://flight-booking-ms/book/"+id, Booking.class);
        CheckIn checkIn = new CheckIn("ch01",booking,"28a");
        //CheckInrepo.save(checkIn);
        return checkIn;
    }

    @GetMapping("/getcheck-in")
    public List<CheckIn> getAllCheckIn(){
        return CheckInrepo.findAll();
    }
}
