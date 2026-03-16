package com.retail.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    // Observe ID Strategy: Change to IDENTITY, SEQUENCE, or AUTO as per Task 7a
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int productId;

    private String name;
    private String description;
    private double price;
    private int quantity;

    // Default Constructor (Required by Hibernate)
    public Product() {}

    // Parameterized Constructor for easy insertion
    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters (Right-click > Source > Generate Getters and Setters)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}