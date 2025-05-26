package com.domain.ecommerce.services;

import com.domain.ecommerce.models.Product;
import com.domain.ecommerce.models.ProductDTO;
import com.domain.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product register(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setStockQuantity(dto.stockQuantity());
        product.setColor(dto.color());
        product.setRating(dto.rating());
        product.setDescription(dto.description());

        return productRepository.save(product);
    }

}
