package org.elsys.springcarautopark.exception;

public class LimitMaxCarsException extends RuntimeException {
    public LimitMaxCarsException(String message) {
        super(message);
    }
}
