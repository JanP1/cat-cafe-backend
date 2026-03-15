package com.catcafe.catcafe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catcafe.catcafe.dto.CatDTO;
import com.catcafe.catcafe.service.CatService;

@RestController
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cats")
    public List<CatDTO> getCats() {
        return catService.getCatDTOs();
    }
}
