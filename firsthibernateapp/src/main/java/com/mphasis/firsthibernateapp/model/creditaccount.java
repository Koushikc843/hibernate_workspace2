package com.mphasis.firsthibernateapp.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


	@Entity
	@DiscriminatorValue("CREDIT")
	public class creditaccount extends  Account {

	@Column(name="creditLimit",length=20)
		private double creditLimit;

	public creditaccount() {

		// TODO Auto-generated constructor stub
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(creditLimit);
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
		debitaccount other = (debitaccount) obj;
		return Double.doubleToLongBits(creditLimit) == Double.doubleToLongBits(debitaccount.creditLimit);
	}
	
	
	
	}
	


	