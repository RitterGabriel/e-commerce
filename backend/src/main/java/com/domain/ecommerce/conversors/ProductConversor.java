package com.domain.ecommerce.conversors;

import com.domain.ecommerce.models.Product;
import com.domain.ecommerce.models.ProductDTO;

public class ProductConversor {
    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setStockQuantity(dto.stockQuantity());
        product.setColor(dto.color());
        product.setRating(dto.rating());
        product.setDescription(dto.description());
        return product;
    }

    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getColor(),
                product.getRating(),
                product.getDescription()
        );
    }
}
