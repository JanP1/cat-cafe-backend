package com.catcafe.catcafe.dto;

import java.math.BigDecimal;

public record MenuItemDTO (
    Long id,
    String name,
    String description,
    BigDecimal price,
    String imageUrl
) {}
