package com.mphasis.firsthibernateapp;

import com.mphasis.firsthibernateapp.model.Books;
import com.mphasis.firsthibernateapp.model.Students;
import com.mphasis.firsthibernateapp.LibraryService;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
import org.hibernate.Session;

public class AppLibrary {

    public static void main(String[] args) {

        // Create initial data
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Students s1 = new Students("Koushik", "kou@gmail.com");
        Students s2 = new Students("Kishor", "kis@gmail.com");

        Books b1 = new Books("belegere", "heli hogo kanara");
        Books b2 = new Books("kuvempu", "ramayana");

        session.persist(s1);
        session.persist(s2);
        session.persist(b1);
        session.persist(b2);

        session.getTransaction().commit();

        // Services
        LibraryService service = new LibraryService();

        // Borrow books
        service.borrowBook(s1.getId(), b1.getId());
        service.borrowBook(s1.getId(), b2.getId());
        service.borrowBook(s2.getId(), b1.getId());

        // List borrowed books
        System.out.println(service.getBooksByStudent(s1.getId()));
    }
}