package com.manager.restaurant.controller.admin;

import com.manager.restaurant.exception.BasketNotPresentException;
import com.manager.restaurant.exception.UserIsNotAdminException;
import com.manager.restaurant.model.user.Role;
import com.manager.restaurant.model.user.User;
import com.manager.restaurant.model.order.Order;
import com.manager.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminOrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> viewAllOrders(
            @AuthenticationPrincipal User user
    ) {
        if (!user.getRoles().contains(Role.ADMIN)) throw new UserIsNotAdminException("User is not admin");
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
