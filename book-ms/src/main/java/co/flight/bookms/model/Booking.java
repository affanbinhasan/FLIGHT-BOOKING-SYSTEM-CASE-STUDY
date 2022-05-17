package co.flight.bookms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flight-booking")
public class Booking {
    @Id
    private String booking_ref_id;
    private Flight flight;
    private User user;
    // private String flight_id;
    // private String firstName;
    // private String lastName;
    // private String gender;
    // private String contact;
    private int amount_to_pay;
    public Booking(String booking_ref_id, Flight flight, User user, int amount_to_pay) {
        this.booking_ref_id = booking_ref_id;
        this.flight = flight;
        this.user = user;
        this.amount_to_pay = amount_to_pay;
    }
    public Booking() {
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
    public int getAmount_to_pay() {
        return amount_to_pay;
    }
    public void setAmount_to_pay(int amount_to_pay) {
        this.amount_to_pay = amount_to_pay;
    }
    @Override
    public String toString() {
        return "Booking [amount_to_pay=" + amount_to_pay + ", booking_ref_id=" + booking_ref_id + ", flight=" + flight
                + ", user=" + user + "]";
    }
 
}
