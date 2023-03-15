package com.manager.restaurant.controller.client;

import com.manager.restaurant.dto.request.CreateOrderRequest;
import com.manager.restaurant.model.order.Order;
import com.manager.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "http://localhost:3000/")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public Order createOrderFromBasket(
            @RequestBody CreateOrderRequest createOrderRequest
    ) {
        return orderService.createOrderFromBasket(createOrderRequest.getBasketId());
    }


}
