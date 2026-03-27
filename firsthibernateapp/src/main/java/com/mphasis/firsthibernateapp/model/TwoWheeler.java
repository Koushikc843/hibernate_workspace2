package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("BIKE")
public class TwoWheeler extends  Vehicle {

@Column(name="steeringHandleType",length=20)
	private String steeringHandleType;

public TwoWheeler() {

	// TODO Auto-generated constructor stub
}

//public TwoWheeler(String id, String manufacturer) {
//	super(id, manufacturer);
//	// TODO Auto-generated constructor stub
//}
//
//public TwoWheeler(String steeringHandleType) {
//	super();
//	this.steeringHandleType = steeringHandleType;
//}

public String getSteeringHandleType() {
	return steeringHandleType;
}

public void setSteeringHandleType(String steeringHandleType) {
	this.steeringHandleType = steeringHandleType;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(steeringHandleType);
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	TwoWheeler other = (TwoWheeler) obj;
	return Objects.equals(steeringHandleType, other.steeringHandleType);
}

}
