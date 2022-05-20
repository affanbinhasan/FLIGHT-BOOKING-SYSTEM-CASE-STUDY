package co.flight.checkinms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flight-check-in")
public class CheckIn {
    @Id
    private String checkInId;

    private String booking_ref_id;
    private String seatNo;
    public CheckIn(String checkInId, String booking_ref_id, String seatNo) {
        this.checkInId = checkInId;
        this.booking_ref_id = booking_ref_id;
        this.seatNo = seatNo;
    }
    public String getCheckInId() {
        return checkInId;
    }
    public void setCheckInId(String checkInId) {
        this.checkInId = checkInId;
    }
    public String getBooking_ref_id() {
        return booking_ref_id;
    }
    public void setBooking_ref_id(String booking_ref_id) {
        this.booking_ref_id = booking_ref_id;
    }
    public String getSeatNo() {
        return seatNo;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    @Override
    public String toString() {
        return "CheckIn [booking_ref_id=" + booking_ref_id + ", checkInId=" + checkInId + ", seatNo=" + seatNo + "]";
    }
    
    
}
