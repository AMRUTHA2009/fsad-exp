package com.klu.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.klu.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        System.out.println("Hibernate is working!");

        session.close();
        factory.close();
    }
}