package com.inventory;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product p1 = new Product("Laptop", "Dell i7", 75000, 10);
        dao.saveProduct(p1);

        System.out.println("Insert Done!");

    }
}