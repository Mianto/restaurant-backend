package com.manager.restaurant.exception;

public class BasketNotPresentException extends RuntimeException {
    public BasketNotPresentException(String message) {
        super(message);
    }
}
