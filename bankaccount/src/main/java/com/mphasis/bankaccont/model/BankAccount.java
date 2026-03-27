package com.mphasis.bankaccont.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="bankaccount")
public class BankAccount {
	@Id
	@Column(name="accountNumber",length=10)
private String	 accountNumber;
	@Column(name="accntHolderName",length=10)
private String accntHolderName;
	@Column(name="balance",length=10)
private double balance;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="currency_code")
	private Currency currency;
 public BankAccount() {
	 
 }
public BankAccount(String accountNumber, String accntHolderName, double balance) {
	super();
	this.accountNumber = accountNumber;
	this.accntHolderName = accntHolderName;
	this.balance = balance;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getAccntHolderName() {
	return accntHolderName;
}
public void setAccntHolderName(String accntHolderName) {
	this.accntHolderName = accntHolderName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

public BankAccount(Currency currency) {
	super();
	this.currency = currency;
}
public Currency getCurrency() {
	return currency;
}
public void setCurrency(Currency currency) {
	this.currency = currency;
}
@Override
public int hashCode() {
	return Objects.hash(accntHolderName, accountNumber, balance);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BankAccount other = (BankAccount) obj;
	return Objects.equals(accntHolderName, other.accntHolderName) && accountNumber == other.accountNumber
			&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance);
}


 
}
