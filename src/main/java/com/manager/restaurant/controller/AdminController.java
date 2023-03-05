package com.manager.restaurant.controller;

import com.manager.restaurant.dto.request.RegisterRequest;
import com.manager.restaurant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @PostMapping("/hello")
    public ResponseEntity<String> registerCustomer(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok("Hello Admin");
    }

    @PostMapping("/authenticatedHello")
    public ResponseEntity<String> authenticatedHello(
            @RequestBody RegisterRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok("Hello Admin");
    }
}
