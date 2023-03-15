package com.manager.restaurant.service;

import com.manager.restaurant.exception.BasketNotPresentException;
import com.manager.restaurant.model.basket.Basket;
import com.manager.restaurant.model.basket.BasketItem;
import com.manager.restaurant.model.order.Order;
import com.manager.restaurant.model.order.OrderItem;
import com.manager.restaurant.model.order.OrderState;
import com.manager.restaurant.repository.basket.BasketRepository;
import com.manager.restaurant.repository.order.OrderItemRepository;
import com.manager.restaurant.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final BasketRepository basketRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public Order createOrderFromBasket(Long basketId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(
                        () -> new BasketNotPresentException("Basket not present with give Id")
                );

        List<OrderItem> orderItems = new ArrayList<>();
        for (BasketItem basketItem: basket.getBasketItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .orderItemTotal(basketItem.getBasketItemTotal())
                    .menuItem(basketItem.getMenuItem())
                    .quantity(basketItem.getQuantity())
                    .build();

            orderItems.add(orderItem);
            orderItemRepository.save(orderItem);
        }
        Order createdOrder = Order.builder()
                .orderStartTime(LocalDateTime.now())
                .totalPrice(basket.getTotalPrice())
                .orderItems(orderItems)
                .orderState(OrderState.SUBMIT).build();

        orderRepository.save(createdOrder);
        return createdOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
