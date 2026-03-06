package com.catcafe.catcafe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catcafe.catcafe.repository.MenuItemRepository;
import com.catcafe.catcafe.model.MenuItem;


@Service
public class MenuItemService {

    private final MenuItemRepository repository;


    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    
    public List<MenuItem> getMenuItems() {
        return repository.findAll();
    }


}

