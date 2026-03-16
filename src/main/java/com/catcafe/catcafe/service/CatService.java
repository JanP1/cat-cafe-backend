package com.catcafe.catcafe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.catcafe.catcafe.repository.CatRepository;
import com.catcafe.catcafe.dto.CatDTO;

@Service
public class CatService {

    private final CatRepository repository;

    private final StorageService storageService;

    public CatService(CatRepository repository, StorageService storageService) {
        this.repository = repository;
        this.storageService = storageService;
    }

    public List<CatDTO> getCatDTOs() {
        return repository.findAll().stream().map(cat -> {
            String fileName = cat.getId() + "_" + cat.getName() + ".jpg";
            
            String imageUrl = storageService.generatePublicUrl(fileName);

            return new CatDTO(
                cat.getId(),
                cat.getName(),
                cat.getBreed(),
                cat.getDescription(),
                cat.getJoinDate(),
                cat.getForAdoption(),
                imageUrl
            );
        }).collect(Collectors.toList());
    }
}
