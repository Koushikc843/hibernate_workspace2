package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


	@Entity
	@DiscriminatorValue("DEBIT")
	public class debitaccount extends  Account {

	public static final double creditLimit = 0;
	@Column(name="overdraftfee",length=20)
		private double overdraftfee;
	private double overdraftfeet;

	public debitaccount() {

		// TODO Auto-generated constructor stub
	}

	public double getOverdraftFeet() {
		return overdraftfee;
	}

	public void setOverdraftFeet(double overdraftfee) {
		this.overdraftfeet = overdraftfee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(overdraftfee, overdraftfeet);
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
		return Double.doubleToLongBits(overdraftfee) == Double.doubleToLongBits(other.overdraftfee)
				&& Double.doubleToLongBits(overdraftfeet) == Double.doubleToLongBits(other.overdraftfeet);
	}

	
	
	
	}
	


	