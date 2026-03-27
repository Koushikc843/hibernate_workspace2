package com.mphasis.firsthibernateapp;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mphasis.firsthibernateapp.contactDAO.ContactDAO;
import com.mphasis.firsthibernateapp.model.Contact;

public class AppContact {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");


        cfg.addAnnotatedClass(Contact.class);

        // Build SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // DAO object
        ContactDAO contactDAO = new ContactDAO(sessionFactory);

        System.out.println("=== Hibernate Contact App Started ===");

        // Create and save a contact
        Contact contact1 = new Contact("C100", "Koushik", "koushik@example.com");
        contactDAO.saveContact(contact1);
        System.out.println("Saved Contact: " + contact1.getId());

        // Fetch by ID
        Contact fetched = contactDAO.getContactById("C100");
        if (fetched != null) {
            System.out.println("\nFetched Contact:");
            System.out.println("ID: " + fetched.getId());
            System.out.println("Name: " + fetched.getName());
            System.out.println("Email: " + fetched.getEmail());
        }

        // List all contacts
        System.out.println("\nAll Contacts:");
        contactDAO.getAllContacts().forEach(c ->
                System.out.println(c.getId() + " | " + c.getName() + " | " + c.getEmail())
        );

        // Delete the contact
        contactDAO.deleteContact("C100");
        System.out.println("\nDeleted Contact C100");

        // Close factory
        sessionFactory.close();
        System.out.println("=== Hibernate Contact App Finished ===");
    }
}
