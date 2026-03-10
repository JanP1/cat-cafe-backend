package com.catcafe.catcafe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catcafe.catcafe.model.Cat;
import com.catcafe.catcafe.repository.CatRepository;

@Service
public class CatService {

    private final CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public List<Cat> getCats() {
        return repository.findAll();
    }

    
}
