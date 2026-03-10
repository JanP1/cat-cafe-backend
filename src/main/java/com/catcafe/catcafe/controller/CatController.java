package com.catcafe.catcafe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catcafe.catcafe.model.Cat;
import com.catcafe.catcafe.service.CatService;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cat> findAll() {
        return service.getCats();
    }
    
}
