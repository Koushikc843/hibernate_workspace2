package com.mphasis.firsthibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mphasis.firsthibernateapp.model.Address;
import com.mphasis.firsthibernateapp.model.User;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class AppUser {

    public static void main(String[] args) {

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();

      
        Transaction tx = s.beginTransaction();

        Address address = new Address("Karve Nagar", "Pune", "411052");
        User user = new User("U001", "Koushik", address);

        s.persist(user);

        s.getTransaction().commit();    
        s.close();
        s.close();

        System.out.println("User inserted successfully!");
    }
}