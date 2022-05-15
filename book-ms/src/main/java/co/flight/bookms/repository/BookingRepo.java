package co.flight.bookms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.flight.bookms.model.Booking;
import co.flight.bookms.model.User;

public interface BookingRepo extends MongoRepository<Booking,String> {
    // @Query("{flight_id : ?0}")
    // List<Booking> getBookingbyId();

    // @Query("{name : ?0}")
    // List<Booking> getBookingbyName();
}
