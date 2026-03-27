package com.mphasis.firsthibernateapp.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @ManyToMany(mappedBy = "books")
    private Set<Students> students = new HashSet<>();

    public Books() {}

    // ❗ Correct constructor (NO ID here)
    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Set<Students> getStudents() { return students; }
}