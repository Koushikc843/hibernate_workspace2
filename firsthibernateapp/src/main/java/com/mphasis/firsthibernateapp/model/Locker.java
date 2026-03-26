package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="lockers")
public class Locker {
	@Id
	@Column(name="id",length=10)
	private String id;
	@Column(name="Location",length=10)
	private  String Location;
	@Column(name="size",length=10)
	private String size;
	
	@Override
	public int hashCode() {
		return Objects.hash(Location, id, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locker other = (Locker) obj;
		return Objects.equals(Location, other.Location) && Objects.equals(id, other.id)
				&& Objects.equals(size, other.size);
	}

	public Locker() {
		
	}

	public Locker(String id, String location, String size) {
		super();
		this.id = id;
		Location = location;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	

}
