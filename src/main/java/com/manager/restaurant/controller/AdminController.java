package com.manager.restaurant.controller;

import com.manager.restaurant.dto.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
