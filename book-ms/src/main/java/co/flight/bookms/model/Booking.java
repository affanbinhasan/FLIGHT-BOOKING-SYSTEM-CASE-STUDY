package co.flight.bookms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flight-booking")
public class Booking {
    @Id
    private String booking_ref_id;
    private Flight flight;
    private User user;
    private String booking_status;
    public Booking(String booking_ref_id, Flight flight, User user, String booking_status) {
        this.booking_ref_id = booking_ref_id;
        this.flight = flight;
        this.user = user;
        this.booking_status = booking_status;
    }
    public String getBooking_ref_id() {
        return booking_ref_id;
    }
    public void setBooking_ref_id(String booking_ref_id) {
        this.booking_ref_id = booking_ref_id;
    }
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getBooking_status() {
        return booking_status;
    }
    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }
    @Override
    public String toString() {
        return "Booking [booking_ref_id=" + booking_ref_id + ", booking_status=" + booking_status + ", flight=" + flight
                + ", user=" + user + "]";
    }
    
}
