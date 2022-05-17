package co.flight.checkinms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flight-check-in")
public class CheckIn {
    @Id
    private String checkInId;

    private Booking booking;
    private String seatNo;
    
    public CheckIn(String checkInId, Booking booking, String seatNo) {
        this.checkInId = checkInId;
        this.booking = booking;
        this.seatNo = seatNo;
    }
    public CheckIn() {
    }
}
