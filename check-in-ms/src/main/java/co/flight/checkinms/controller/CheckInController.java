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
import co.flight.checkinms.service.CheckInService;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flight-check-in")
public class CheckInController {
    
    @Autowired
    CheckInService CheckInService;


    @GetMapping("/check-in/{id}")
    public List<CheckIn> getCheckIn(@PathVariable String id){
        return CheckInService.getCheckIn(id);
    }

    @GetMapping("/getcheck-in")
    public List<CheckIn> getAllCheckIn(){
        return CheckInService.getAllCheckIn();
    }
}
