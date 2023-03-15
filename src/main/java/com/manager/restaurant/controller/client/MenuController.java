package com.manager.restaurant.controller.client;

import com.manager.restaurant.model.menu.Menu;
import com.manager.restaurant.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
@CrossOrigin(origins = "http://localhost:3000/")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("")
    public ResponseEntity<Menu> getMenu() {
        return ResponseEntity.ok(menuService.getDefaultMenu());
    }
}
