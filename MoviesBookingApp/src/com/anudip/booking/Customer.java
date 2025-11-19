package com.anudip.booking;

/**
 * The Customer class holds basic information about a person booking tickets.
 */
public class Customer {
    private int customerId;
    private String name;
    private String phone;

    // Constructor
    public Customer(int customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    // Getters 
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // We don't need Setters yet, as we might not change customer data after creation.

    @Override
    public String toString() {
        return "Customer ID: " + customerId + 
               " | Name: " + name + 
               " | Phone: " + phone;
    }
}