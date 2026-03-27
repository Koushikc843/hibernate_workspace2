package com.mphasis.firsthibernateapp;

import com.mphasis.firsthibernateapp.model.Book;
import com.mphasis.firsthibernateapp.model.Clothing;
import com.mphasis.firsthibernateapp.model.Electronics;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

import org.hibernate.Session;

import java.math.BigDecimal;

public class AppEcommerce {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Book b = new Book();
        b.setName("Java Programming");
        b.setPrice(new BigDecimal("29.99"));
        b.setAuthor("Koushik");
        b.setIsbn("123");
        b.setNumberOfPages(450);

        Electronics e = new Electronics();
        e.setName("Gaming Laptop");
        e.setPrice(new BigDecimal("999.99"));
        e.setBrand("Asus");
        e.setWarrantyPeriod(24);
        e.setPowerConsumption(180);

        Clothing c = new Clothing();
        c.setName("T-Shirt");
        c.setPrice(new BigDecimal("15.99"));
        c.setSize("M");
        c.setColor("Black");
        c.setMaterial("Cotton");


session.persist(b);
        session.persist(e);
        session.persist(c);

        session.getTransaction().commit();
        System.out.println("Products saved successfully!");
    }
}
