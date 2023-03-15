package com.manager.restaurant.model.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection(targetClass = OrderItem.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "order_orderItem",
            joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "order_item_id", nullable = false)
    private List<OrderItem> orderItems;
    private Double totalPrice;
    @Basic
    private LocalDateTime orderStartTime;
    @Basic
    private LocalDateTime orderFulfilmentTime;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
}
