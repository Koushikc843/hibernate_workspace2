package com.mphasis.firsthibernateapp;

import com.mphasis.firsthibernateapp.model.Contact;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        // Display existing c1
        findById("c1");

        // Update email of c1
        updateEmail("c1", "newemail@gmail.com");
        findById("c1");

        // Delete c1
        delete("c1");
        findById("c1");   // should show "not found"
    }

    // SAVE contact (use only when adding NEW IDs)
    public static void save() {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Contact contact = new Contact("c2", "kou", "kou@gmail.com");
        session.persist(contact);

        session.getTransaction().commit();
        session.close();
        System.out.println("Saved.....");
    }

    // FIND by ID
    public static void findById(String id) {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Contact c = session.find(Contact.class, id);

        if (c != null)
            System.out.println(c.getId() + "," + c.getName() + "," + c.getEmail());
        else
            System.out.println("Contact not found!");

        session.getTransaction().commit();
        session.close();
    }

    // DELETE
    public static void delete(String id) {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Contact c = session.find(Contact.class, id);

        if (c != null) {
            session.remove(c);
            System.out.println("Deleted " + id);
        } else {
            System.out.println("No contact found with id: " + id);
        }

        session.getTransaction().commit();
        session.close();
    }

    // UPDATE email
    public static void updateEmail(String id, String newemail) {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Contact c = session.find(Contact.class, id);

        if (c != null) {
            c.setEmail(newemail);
            System.out.println(id + " updated.....");
        } else {
            System.out.println("No contact found with id: " + id);
        }

        session.getTransaction().commit();
        session.close();
    }
}