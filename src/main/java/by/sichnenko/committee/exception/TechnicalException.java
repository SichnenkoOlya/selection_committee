package by.sichnenko.committee.exception;

public class TechnicalException extends Exception {

    public TechnicalException(Exception e) {
        super(e);
    }

    public TechnicalException(String message, Exception e) {
        super(message, e);
    }
}