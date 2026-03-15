package com.catcafe.catcafe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.catcafe.catcafe.repository.CatRepository;
import com.catcafe.catcafe.dto.CatDTO;

@Service
public class CatService {

    @Value("${supabase.endpoint}")
    private String endpoint;

    @Value("${supabase.bucket-name}")
    private String bucketName;

    private final CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public List<CatDTO> getCatDTOs() {
        return repository.findAll().stream().map(cat -> {

            String fileName = cat.getId() + "_" + cat.getName() + ".jpg";
            String imageUrl = generatePublicUrl(fileName);
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

    private String generatePublicUrl(String fileName) {
        return endpoint + "/" + bucketName + "/" + fileName;
    }
}
