package com.mphasis.firsthibernateapp.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="stu")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_book",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Books> books = new HashSet<>();

    public Students() {}

    // ✔ Correct constructor
    public Students(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }

    public Set<Books> getBooks() { return books; }

    public void addBook(Books b) {
        books.add(b);
        b.getStudents().add(this);
    }

    public void removeBook(Books b) {
        books.remove(b);
        b.getStudents().remove(this);
    }
}