package com.mphasis.firsthibernateapp.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "shop_customers",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_customer_email", columnNames = "email")
        },
        indexes = {
                @Index(name = "idx_phone_number", columnList = "phoneNumber")
        }
)
public class customer {

    @Id
    private Long customerId;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(length = 20)
    private String phoneNumber;

    private LocalDate registrationDate;

    public customer() {}

    public customer(Long customerId, String email, String fullName,
                    String phoneNumber, LocalDate registrationDate) {
        this.customerId = customerId;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    // Getters & Setters

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { 
        this.registrationDate = registrationDate; 
    }

    @Override
    public String toString() {
        return customerId + " | " + fullName + " | " + email + 
               " | " + phoneNumber + " | " + registrationDate;
    }
}