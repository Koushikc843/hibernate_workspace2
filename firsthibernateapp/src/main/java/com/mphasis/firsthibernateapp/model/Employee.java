package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="id",length=10)
private String id;
	@Column(name="name",length=20)
private String name;
	@Column(name="salary",length=10)
private double salary;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="department_id")
private Department department;

public Employee() {
	
}


public Employee(String id, String name, double salary) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
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


public double getSalary() {
	return salary;
}


public void setSalary(double salary) {
	this.salary = salary;
}


@Override
public int hashCode() {
	return Objects.hash(id, name, salary);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return Objects.equals(id, other.id) && Objects.equals(name, other.name)
			&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
}



	public void setDepartment(Department department) {
	    this.department = department;
	}
	
}
