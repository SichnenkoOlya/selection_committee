package by.sichnenko.committee.exception;

public class TechnicalException extends Exception {

    public TechnicalException() {
    }

    public TechnicalException(Exception e) {
        super(e);
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Exception e) {
        super(message, e);
    }
}