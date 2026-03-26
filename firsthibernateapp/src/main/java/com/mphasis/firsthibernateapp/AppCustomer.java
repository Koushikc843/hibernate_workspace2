package com.mphasis.firsthibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mphasis.firsthibernateapp.model.Address;
import com.mphasis.firsthibernateapp.model.Customer;
import com.mphasis.firsthibernateapp.model.Locker;
import com.mphasis.firsthibernateapp.model.User;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class AppCustomer {

    public static void main(String[] args) {

//        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//        cfg.addAnnotatedClass(User.class);
//        cfg.addAnnotatedClass(Address.class);
//
//        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        Locker l = new Locker("L1", "Rack_2", "Big");
        s.persist(l);
        Customer c = new Customer("C1","shrek");
        c.setLocker(l);
        s.persist(c);
      
        s.getTransaction().commit();   
       
        s.close();
       

        System.out.println("saved");
    }
}