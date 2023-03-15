package com.manager.restaurant.model.order;

import com.manager.restaurant.model.menu.MenuItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;
    private Integer quantity;
    private Double orderItemTotal;
}
