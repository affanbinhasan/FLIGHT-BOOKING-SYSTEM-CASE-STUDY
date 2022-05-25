package co.flight.checkinms.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    public static String getRandomNumber() {
        Random random = new Random();
        int min = 1;
        int max = 41;
        Integer res = random.nextInt(max - min) + min;
        String seat = res.toString();
        return seat;
    }

    
    public static String alotSeat(){
        String[] arr = {"a","b","c"};
        Random r=new Random();        
      	int randomNumber=r.nextInt(arr.length);
        String seatNo = arr[randomNumber];
        String seat = getRandomNumber();
        String finalSeat = seatNo+seat;
        return finalSeat;
    }
    
    public List<CheckIn> getCheckIn(String id){

        Booking booking = restTemplate.getForObject("http://flight-booking-ms/booking/book/"+id, Booking.class);

        String booking_id = booking.getBooking_ref_id();
        String seatNo = alotSeat();
        String uniqueID = UUID.randomUUID().toString();

        CheckIn checkIn = new CheckIn(uniqueID,booking_id,seatNo);
        
        List<CheckIn> newList = Arrays.asList(checkIn);
        
        CheckInrepo.save(checkIn);
        return newList;
    }

    
    public List<CheckIn> getAllCheckIn(){
        return CheckInrepo.findAll();
    }
}
