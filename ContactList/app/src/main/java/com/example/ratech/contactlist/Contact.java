package com.example.ratech.contactlist;

public class Contact {

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    public Contact(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "name:" + firstName + ", " +
            "lastName:" + lastName + ", " +
            "email:" + email + ", " +
            "phoneNumber:" + phoneNumber;
    }
}
