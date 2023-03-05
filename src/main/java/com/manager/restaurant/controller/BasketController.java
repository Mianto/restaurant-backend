package com.manager.restaurant.controller;

import com.manager.restaurant.dto.request.BasketItemRequest;
import com.manager.restaurant.dto.response.EmptyBasketResponse;
import com.manager.restaurant.model.basket.Basket;
import com.manager.restaurant.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000/")
public class BasketController {

    private final BasketService basketService;

    @PostMapping("basket")
    public ResponseEntity<EmptyBasketResponse> createEmptyBasket() {
        return ResponseEntity.ok(basketService.getEmptyBasket());
    }

    @PostMapping("basket/{basketId}")
    public ResponseEntity<Basket> addOrDeleteItemFromBasket(
            @PathVariable String basketId,
            @RequestBody BasketItemRequest basketItemRequest
    ) {
        return ResponseEntity.ok(basketService.addOrDeleteItemFromBasket(basketId, basketItemRequest));
    }
}
