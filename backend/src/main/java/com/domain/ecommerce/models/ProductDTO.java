package com.domain.ecommerce.models;

public record ProductDTO(
        String name,
        Float price,
        Integer stockQuantity,
        Colors color,
        Integer rating,
        String description
) {
}
