package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

public class Address {
    private String address;
    private String city;
    private String pin;

    public Address() {
    }

    public Address(String address, String city, String pin) {
        this.address = address;
        this.city = city;
        this.pin = pin;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

	@Override
	public int hashCode() {
		return Objects.hash(address, city, pin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(pin, other.pin);
	}
    
}