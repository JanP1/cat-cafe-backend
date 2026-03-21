package com.catcafe.catcafe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.catcafe.catcafe.repository.MenuItemRepository;
import com.catcafe.catcafe.dto.MenuItemDTO;

@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    private final StorageService storageService;

    public MenuItemService(MenuItemRepository repository, StorageService storageService) {
        this.repository = repository;
        this.storageService = storageService;
    }
    
    public List<MenuItemDTO> getMenuItemDTOs() {
        return repository.findAll().stream().map(menuItem -> {
            String fileName = menuItem.getId() + "_" + menuItem.getName() + ".jpg";
            
            String imageUrl = storageService.generatePublicUrl(fileName);

            return new MenuItemDTO(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getType(),
                imageUrl
            );

        }).collect(Collectors.toList());
    }

    public MenuItemDTO getMenuItemDTOById(Long id) {
        return repository.findById(id).map(menuItem -> {
            
            String fileName = menuItem.getId() + "_" + menuItem.getName() + ".jpg";
            String imageUrl = storageService.generatePublicUrl(fileName);

            return new MenuItemDTO(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getType(),
                imageUrl
            );
        }).orElseThrow(() -> new RuntimeException("MenuItem not found with id: " + id));
    }
}

