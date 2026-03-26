package com.mphasis.firsthibernateapp.contactDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.firsthibernateapp.model.Contact;

public class ContactDAO {

    private SessionFactory sessionFactory;

    public ContactDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveContact(Contact contact) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(contact);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Contact getContactById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Contact.class, id);
        }
    }

    public List<Contact> getAllContacts() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Contact", Contact.class).list();
        }
    }

    public void deleteContact(String id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Contact c = session.get(Contact.class, id);
            if (c != null) {
                session.remove(c);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}