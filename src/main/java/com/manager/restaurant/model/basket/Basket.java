package com.manager.restaurant.model.basket;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection(targetClass = BasketItem.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "basket_basketItem",
            joinColumns = @JoinColumn(name = "basket_id"))
    @Column(name = "basket_item_id", nullable = false)
    private List<BasketItem> basketItems;
    private Double totalPrice;
}
