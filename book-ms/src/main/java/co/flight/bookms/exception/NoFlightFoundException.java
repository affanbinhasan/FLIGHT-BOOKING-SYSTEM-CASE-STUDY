package co.flight.bookms.exception;

public class NoFlightFoundException extends Exception {
    public NoFlightFoundException(String error_msg){
        super(error_msg);
    }
}
