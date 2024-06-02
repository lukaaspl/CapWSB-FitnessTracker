package com.capgemini.wsb.fitnesstracker.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic business exception indicating that some parameters are invalid.
 * Will resolve to the {@link HttpStatus#BAD_REQUEST} if handled by the Spring's
 * exception handler.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParametersException extends BusinessException {
    public InvalidParametersException(String message) {
        super(message);
    }

}
