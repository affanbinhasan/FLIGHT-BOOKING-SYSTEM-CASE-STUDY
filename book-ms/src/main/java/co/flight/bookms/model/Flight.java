package co.flight.bookms.model;

public class Flight {
    
    private String flight_id;
    private String flight_name;
    private String flight_origin;
    private String flight_destination;
    private String flight_arrival;
    private String flight_departure;
    private int duration;
    public Flight() {
    }
    public Flight(String flight_id, String flight_name, String flight_origin, String flight_destination,
            String flight_arrival, String flight_departure, int duration) {
        this.flight_id = flight_id;
        this.flight_name = flight_name;
        this.flight_origin = flight_origin;
        this.flight_destination = flight_destination;
        this.flight_arrival = flight_arrival;
        this.flight_departure = flight_departure;
        this.duration = duration;
    }
    public String getFlight_id() {
        return flight_id;
    }
    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }
    public String getFlight_name() {
        return flight_name;
    }
    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }
    public String getFlight_origin() {
        return flight_origin;
    }
    public void setFlight_origin(String flight_origin) {
        this.flight_origin = flight_origin;
    }
    public String getFlight_destination() {
        return flight_destination;
    }
    public void setFlight_destination(String flight_destination) {
        this.flight_destination = flight_destination;
    }
    public String getFlight_arrival() {
        return flight_arrival;
    }
    public void setFlight_arrival(String flight_arrival) {
        this.flight_arrival = flight_arrival;
    }
    public String getFlight_departure() {
        return flight_departure;
    }
    public void setFlight_departure(String flight_departure) {
        this.flight_departure = flight_departure;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    @Override
    public String toString() {
        return "Flight [duration=" + duration + ", flight_arrival=" + flight_arrival + ", flight_departure="
                + flight_departure + ", flight_destination=" + flight_destination + ", flight_id=" + flight_id
                + ", flight_name=" + flight_name + ", flight_origin=" + flight_origin + "]";
    }
    
}
