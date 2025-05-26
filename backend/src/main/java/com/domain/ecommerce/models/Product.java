package com.domain.ecommerce.models;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Float price;

    private Integer stockQuantity;

    private Colors color;

    private Integer rating;

    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getPrice() {return  this.price;}
    public void setPrice(Float price) {this.price = price;}

    public Integer getStockQuantity() {return this.stockQuantity;}
    public void setStockQuantity(Integer stockQuantity) {this.stockQuantity = stockQuantity;}

    public Colors getColor() {return this.color;}
    public void setColor(Colors color) {this.color = color;}

    public Integer getRating() {return this.rating;}
    public void setRating(Integer rating) {this.rating = rating;}

    public String getDescription() {return this.description;}
    public void setDescription(String description) {this.description = description;}
}
