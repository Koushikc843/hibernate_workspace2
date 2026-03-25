package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="contact")
public class Contact {
	@Id
	@Column(name="id", length =5)
  private String id;
	
	@Column(name="name", length =10)
  private String name;
	@Column(name="email", length =15)
  private String email;
  
  public Contact () {
	  
  }

public Contact(String id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Contact other = (Contact) obj;
	return Objects.equals(id, other.id);
}
  
  
}
