package com.retail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.retail.entity.Product;

public class InventoryApp {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        try {
            // --- 1. INSERT (Create) ---
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            
            Product p1 = new Product("Smartphone", "Latest Model", 799.99, 50);
            Product p2 = new Product("Tablet", "Pro Version", 499.99, 30);
            
            session.persist(p1);
            session.persist(p2);
            session.getTransaction().commit();

            // --- 2. RETRIEVE (Read) ---
            session = factory.getCurrentSession();
            session.beginTransaction();
            int searchId = 1; 
            Product retrieved = session.get(Product.class, searchId);
            System.out.println("Retrieved Product: " + retrieved.getName());

            // --- 3. UPDATE Price or Quantity ---
            retrieved.setPrice(749.99); // Updating price
            retrieved.setQuantity(45);  // Updating quantity
            
            // --- 4. DELETE if discontinued ---
            // Let's assume id 2 is discontinued
            Product discontinued = session.get(Product.class, 2);
            if(discontinued != null) {
                session.remove(discontinued);
            }

            session.getTransaction().commit();
            System.out.println("CRUD Operations Completed Successfully!");

        } finally {
            factory.close();
        }
    }
}