package co.flight.bookms.model;

public class Flight {
    
    private String flight_id;
    private String flight_name;
    private String flight_origin;
    private String flight_destination;
    private String flight_arrival;
    private String flight_departure;
    private int duration;
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
    @Override
    public String toString() {
        return "Flight [duration=" + duration + ", flight_arrival=" + flight_arrival + ", flight_departure="
                + flight_departure + ", flight_destination=" + flight_destination + ", flight_id=" + flight_id
                + ", flight_name=" + flight_name + ", flight_origin=" + flight_origin + "]";
    }
}
