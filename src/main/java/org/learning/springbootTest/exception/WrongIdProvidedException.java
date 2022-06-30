package org.learning.springbootTest.exception;

public class WrongIdProvidedException extends RuntimeException {
    public WrongIdProvidedException(String message) {
        super(message);
    }
}
