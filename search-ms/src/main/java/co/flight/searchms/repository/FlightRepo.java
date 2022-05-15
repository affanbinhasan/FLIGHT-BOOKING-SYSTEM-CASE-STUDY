package co.flight.searchms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.flight.searchms.model.*;

public interface FlightRepo extends MongoRepository<Flight,String>{
    @Query("{flight_id : ?0}")
    List<Flight> getFlightbyId(String id);

    // @Query("{name : ?0}")
    // List<Flight> getFlightbyname();
}