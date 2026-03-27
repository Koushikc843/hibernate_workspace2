package com.mphasis.bankaccont.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Currency")
public class Currency {
	@Id
	@Column(name="currencyCode",length=10)
private String currencyCode;
	@Column(name="currencySysmbol",length=10)
private String currencySysmbol;
	@Column(name="locale",length=10)
private String locale;
public Currency() {
	
	// TODO Auto-generated constructor stub
}
public Currency(String currencyCode, String currencySysmbol, String locale) {
	super();
	this.currencyCode = currencyCode;
	this.currencySysmbol = currencySysmbol;
	this.locale = locale;
}
public String getCurrencyCode() {
	return currencyCode;
}
public void setCurrencyCode(String currencyCode) {
	this.currencyCode = currencyCode;
}
public String getCurrencySysmbol() {
	return currencySysmbol;
}
public void setCurrencySysmbol(String currencySysmbol) {
	this.currencySysmbol = currencySysmbol;
}
public String getLocale() {
	return locale;
}
public void setLocale(String locale) {
	this.locale = locale;
}
@Override
public int hashCode() {
	return Objects.hash(currencyCode, currencySysmbol, locale);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Currency other = (Currency) obj;
	return Objects.equals(currencyCode, other.currencyCode) && Objects.equals(currencySysmbol, other.currencySysmbol)
			&& Objects.equals(locale, other.locale);
}

}
