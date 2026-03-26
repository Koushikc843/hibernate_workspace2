package com.mphasis.firsthibernateapp.dao;



import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.customer;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class customerDAO {

    // Save a new customer
    public void saveCustomer(customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(customer);

        session.getTransaction().commit();
        session.close();

        System.out.println("Customer saved successfully!");
    }

    // Retrieve by ID
    public void findCustomerById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        customer c = session.get(customer.class, id);

        if (c != null)
            System.out.println("Customer Found: " + c);
        else
            System.out.println("Customer not found!");

        session.getTransaction().commit();
        session.close();
    }

    // Update phone number
    public void updateCustomerPhone(Long id, String newPhone) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        customer c = session.get(customer.class, id);

        if (c != null) {
            c.setPhoneNumber(newPhone);
            System.out.println("Phone updated for: " + id);
        } else {
            System.out.println("Customer not found!");
        }

        session.getTransaction().commit();
        session.close();
    }
}