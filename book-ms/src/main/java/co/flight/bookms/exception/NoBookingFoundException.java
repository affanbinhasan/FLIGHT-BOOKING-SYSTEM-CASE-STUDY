package co.flight.bookms.exception;

public class NoBookingFoundException extends Exception {
    public NoBookingFoundException(String error_msg){
        super(error_msg);
    }
}
