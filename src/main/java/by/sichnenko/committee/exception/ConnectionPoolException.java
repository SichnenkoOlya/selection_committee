package by.sichnenko.committee.exception;

public class ConnectionPoolException extends Exception {
    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}