package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.exception.api.BusinessException;

/**
 * Exception indicating that the e-mail is already taken.
 */
public class UserEmailTakenException extends BusinessException {

    public UserEmailTakenException(String email) {
        super("User with e-mail=%s is already taken".formatted(email));
    }

}
