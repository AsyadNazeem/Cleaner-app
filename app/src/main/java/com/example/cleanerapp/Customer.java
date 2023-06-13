package com.example.cleanerapp;

import java.security.PrivateKey;

public class Customer
{
    private String Name;
    private String Email;
    private String PhoneNo;

    public Customer () {}

    public Customer(String name, String email, String phoneNo) {
        Name = name;
        Email = email;
        PhoneNo = phoneNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
}
