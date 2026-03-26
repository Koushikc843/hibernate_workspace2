package com.mphasis.firsthibernateapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mphasis.firsthibernateapp.contactDAO.ContactDAO;
import com.mphasis.firsthibernateapp.model.Contact;

public class App{

    public static void main(String[] args) {

      
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Contact.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        ContactDAO contactDAO = new ContactDAO(sessionFactory);
        System.out.println(" Hibernate App Started");
        Contact c1 = new Contact("C001", "Koushik", "koushik@gmail.com");
        contactDAO.saveContact(c1);
        System.out.println("Contact saved!");

        Contact fetched = contactDAO.getContactById("C001");
        System.out.println("Fetched: " + fetched.getName() + " | " + fetched.getEmail());

        System.out.println("All contacts:");
        contactDAO.getAllContacts().forEach(c ->
                System.out.println(c.getId() + " - " + c.getName() + " - " + c.getEmail())
        );
    }
}


