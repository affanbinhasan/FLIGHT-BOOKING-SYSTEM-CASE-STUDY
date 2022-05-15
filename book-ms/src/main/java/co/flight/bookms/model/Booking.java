package co.flight.bookms.model;


public class Booking {

    private String booking_ref_id;
    private Flight flight;
    private User user;
    private int amount_to_pay;
    
    public Booking(String booking_ref_id, Flight flight, User user, int amount_to_pay) {
        this.booking_ref_id = booking_ref_id;
        this.flight = flight;
        this.user = user;
        this.amount_to_pay = amount_to_pay;
    }
    
    @Override
    public String toString() {
        return "Booking [amount_to_pay=" + amount_to_pay + ", booking_ref_id=" + booking_ref_id + ", flight=" + flight
                + ", user=" + user + "]";
    }
    
}