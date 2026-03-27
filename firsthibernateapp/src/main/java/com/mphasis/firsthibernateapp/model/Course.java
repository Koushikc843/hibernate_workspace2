package com.mphasis.firsthibernateapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mphasis.firsthibernateapp.model.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@Column(name="id",length=10)
private String id;
	@Column(name="name",length=20)
private String name;
	
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList<>();
	public Course() {
		
		// TODO Auto-generated constructor stub
	}
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	
}


