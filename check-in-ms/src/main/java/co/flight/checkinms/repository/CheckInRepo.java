package co.flight.checkinms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.flight.checkinms.model.CheckIn;

public interface CheckInRepo extends MongoRepository<CheckIn,String>{
    
}
