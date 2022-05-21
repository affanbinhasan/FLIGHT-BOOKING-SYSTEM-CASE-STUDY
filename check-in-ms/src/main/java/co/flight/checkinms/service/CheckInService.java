package co.flight.checkinms.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import co.flight.checkinms.model.Booking;
import co.flight.checkinms.model.CheckIn;
import co.flight.checkinms.repository.CheckInRepo;

@Component
public class CheckInService {
    
    @Autowired
    CheckInRepo CheckInrepo;

    @Autowired
    RestTemplate restTemplate;

    
    public List<CheckIn> getCheckIn(String id){
        Booking booking = restTemplate.getForObject("http://flight-booking-ms/booking/book/"+id, Booking.class);
        String booking_id = booking.getBooking_ref_id();
        CheckIn checkIn = new CheckIn("ch01",booking_id,"28a");
        List<CheckIn> newList = Arrays.asList(checkIn);
        //CheckInrepo.save(checkIn);
        return newList;
    }

    
    public List<CheckIn> getAllCheckIn(){
        return CheckInrepo.findAll();
    }
}
