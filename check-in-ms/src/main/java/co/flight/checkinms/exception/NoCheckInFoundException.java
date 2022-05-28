package co.flight.checkinms.exception;

public class NoCheckInFoundException extends Exception {
    public NoCheckInFoundException(String error_msg){
        super(error_msg);
    }
}
