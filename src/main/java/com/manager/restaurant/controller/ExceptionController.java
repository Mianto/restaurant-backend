package com.manager.restaurant.controller;

import com.manager.restaurant.dto.response.ExceptionMessageResponse;
import com.manager.restaurant.exception.BasketNotPresentException;
import com.manager.restaurant.exception.UserAlreadyExistException;
import com.manager.restaurant.exception.UserDoesNotExistException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<ExceptionMessageResponse> handleUserDoesNotException(
            UserDoesNotExistException userDoesNotExistException,
            HttpServletRequest httpServletRequest
    ) {
        ExceptionMessageResponse response = ExceptionMessageResponse.builder()
                .message(userDoesNotExistException.getMessage())
                .path(httpServletRequest.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(401));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionMessageResponse> handleUserAlreadyExistException(
            UserAlreadyExistException userAlreadyExistException,
            HttpServletRequest httpServletRequest
    ) {
        ExceptionMessageResponse response = ExceptionMessageResponse.builder()
                .message(userAlreadyExistException.getMessage())
                .path(httpServletRequest.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(409));
    }

    @ExceptionHandler(BasketNotPresentException.class)
    public ResponseEntity<ExceptionMessageResponse> handleUserAlreadyExistException(
            BasketNotPresentException basketNotPresentException,
            HttpServletRequest httpServletRequest
    ) {
        ExceptionMessageResponse response = ExceptionMessageResponse.builder()
                .message(basketNotPresentException.getMessage())
                .path(httpServletRequest.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(401));
    }
}
