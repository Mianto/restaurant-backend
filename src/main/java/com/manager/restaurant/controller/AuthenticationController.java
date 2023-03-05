package com.manager.restaurant.controller;

import com.manager.restaurant.dto.request.AuthenticationRequest;
import com.manager.restaurant.dto.request.RegisterRequest;
import com.manager.restaurant.dto.response.AuthenticationResponse;
import com.manager.restaurant.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUpCustomer")
    public ResponseEntity<AuthenticationResponse> signUpCustomer(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.registerCustomer(request));
    }

    @PostMapping("/signUpAdmin")
    public ResponseEntity<AuthenticationResponse> signUpAdmin(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
