package com.catcafe.catcafe.dto;

import java.time.LocalDate;

public record CatDTO(
    Long id,
    String name,
    String breed,
    String description,
    LocalDate joinDate,
    boolean forAdoption,
    String imageUrl
) {}
