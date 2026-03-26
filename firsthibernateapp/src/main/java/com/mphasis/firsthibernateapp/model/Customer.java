package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@Column(name="id",length=10)
private String id;
	@Column(name="name",length=20)
private String name;
@OneToOne
@JoinColumn(name="lockerid")
private Locker Locker;
private Customer() {
	
}
public Customer(String id, String name) {
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
//public void setLocker(com.mphasis.firsthibernateapp.model.Locker l) {
//	// TODO Auto-generated method stub
//	
//}
@Override
public int hashCode() {
	return Objects.hash(Locker, id, name);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	return Objects.equals(Locker, other.Locker) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
}
public void setLocker(com.mphasis.firsthibernateapp.model.Locker l) {
	// TODO Auto-generated method stub
	
}


}
