package com.catcafe.catcafe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catcafe.catcafe.dto.MenuItemDTO;
import com.catcafe.catcafe.service.MenuItemService;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<MenuItemDTO> gMenuItems() {
        return menuItemService.getMenuItemDTOs();
    }
    
}
