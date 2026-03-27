package com.mphasis.firsthibernateapp;

import java.util.List;

import org.hibernate.Session;


import com.mphasis.firsthibernateapp.model.Books;

import com.mphasis.firsthibernateapp.model.Students;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class LibraryService {

    // Borrow book
    public void borrowBook(Long studentId, Long bookId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Students student = session.get(Students.class, studentId);
        Books book = session.get(Books.class, bookId);

        if (student == null || book == null) {
            throw new RuntimeException("Student or Book not found");
        }

        student.addBook(book); // owning side

        session.merge(student);
        session.getTransaction().commit();
    }

    // Return a book
    public void returnBook(Long studentId, Long bookId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Students student = session.get(Students.class, studentId);
        Books book = session.get(Books.class, bookId);

        if (student == null || book == null) {
            throw new RuntimeException("Student or Book not found");
        }

        student.removeBook(book);

        session.merge(student);

        session.getTransaction().commit();
    }

    // List books borrowed by student
    public List<Books> getBooksByStudent(Long studentId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Students student = session.get(Students.class, studentId);

        List<Books> books = student.getBooks().stream().toList();

        session.getTransaction().commit();
        return books;
    }
}