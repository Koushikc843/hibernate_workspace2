package com.mphasis.firsthibernateapp;

import java.time.LocalDate;

import com.mphasis.firsthibernateapp.dao.customerDAO;
import com.mphasis.firsthibernateapp.model.customer;

public class App {
    public static void main(String[] args) {

        customerDAO dao = new customerDAO();

        // 1. Save a customer
        customer customer = new customer(
                101L,
                "koushik.c@example.com",
                "koushik",
                "9876543210",
                LocalDate.now()
        );
        dao.saveCustomer(customer);

        // 2. Get customer by ID
        dao.findCustomerById(101L);

        // 3. Update customer's phone number
        dao.updateCustomerPhone(101L, "9998887771");

        // 4. Verify update
        dao.findCustomerById(101L);
    }
}