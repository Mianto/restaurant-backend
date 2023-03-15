package com.manager.restaurant.exception;

public class UserIsNotAdminException extends RuntimeException {
    public UserIsNotAdminException(String message) {
        super(message);
    }

    public UserIsNotAdminException(String message, Throwable cause) {
        super(message, cause);
    }
}
