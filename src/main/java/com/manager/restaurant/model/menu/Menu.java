package com.manager.restaurant.model.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @ElementCollection(targetClass = MenuGroup.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "menu_menuGroup",
            joinColumns = @JoinColumn(name = "menu_id"))
    @Column(name = "menu_group_id", nullable = false)
    private Set<MenuGroup> menuGroups;
}
