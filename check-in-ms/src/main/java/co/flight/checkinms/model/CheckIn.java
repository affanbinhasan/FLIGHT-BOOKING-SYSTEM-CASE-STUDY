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
    public String getCheckInId() {
        return checkInId;
    }
    public void setCheckInId(String checkInId) {
        this.checkInId = checkInId;
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public String getSeatNo() {
        return seatNo;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    @Override
    public String toString() {
        return "CheckIn [booking=" + booking + ", checkInId=" + checkInId + ", seatNo=" + seatNo + "]";
    }
    
}
