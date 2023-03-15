package com.manager.restaurant.controller.client;

import com.manager.restaurant.model.menu.MenuGroup;
import com.manager.restaurant.repository.menu.MenuGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000/")
public class MenuGroupController {
    private final MenuGroupRepository menuGroupRepository;

    @GetMapping("/menuGroups")
    public ResponseEntity<List<MenuGroup>> getMenuGroups() {
        return ResponseEntity.ok(menuGroupRepository.findAll());
    }

    @GetMapping("/menuGroups/{id}")
    public ResponseEntity<MenuGroup> getMenuGroupById(@PathVariable String id) {
        return ResponseEntity.of(menuGroupRepository.findById(Long.valueOf(id)));
    }
}
