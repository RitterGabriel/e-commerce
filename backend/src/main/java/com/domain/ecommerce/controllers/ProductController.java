package com.domain.ecommerce.controllers;

import com.domain.ecommerce.conversors.ProductConversor;
import com.domain.ecommerce.models.Product;
import com.domain.ecommerce.models.ProductDTO;
import com.domain.ecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> registerProduct(@RequestBody ProductDTO productDTO) {
        Product newProduct = productService.register(productDTO);
        ProductDTO response = ProductConversor.toDTO(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ProductDTO>> registerBatchProduct(@RequestBody List<ProductDTO> dtos) {
        List<ProductDTO> response = dtos.stream()
                .map(dto -> {
                    Product product = productService.register(dto);
                    return ProductConversor.toDTO(product);
                }).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
