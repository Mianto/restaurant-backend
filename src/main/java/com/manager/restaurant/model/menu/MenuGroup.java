package com.manager.restaurant.model.menu;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "menu_group")
public class MenuGroup {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @ElementCollection(targetClass = MenuItem.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "menu_menuItem",
            joinColumns = @JoinColumn(name = "menu_group_id"))
    @Column(name = "menu_item_id", nullable = false)
    private Set<MenuItem> menuItems;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MenuGroup menuGroup = (MenuGroup) o;
        return id != null && Objects.equals(id, menuGroup.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
