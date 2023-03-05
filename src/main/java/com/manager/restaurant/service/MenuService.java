package com.manager.restaurant.service;

import com.manager.restaurant.model.menu.Menu;
import com.manager.restaurant.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu getDefaultMenu() {
        return menuRepository.findAll().get(0);
    }
}
