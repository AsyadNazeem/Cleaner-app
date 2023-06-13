package com.example.cleanerapp;

public class Details {

    private String Name;
    private String Email;
    private String PhoneNo;
    private String Address;
    private String Squarefeet;
    private String Rooms;
    private String Bathrooms;
    private String Flooring;

    public Details(){}

    public Details(String name, String email, String phoneNo, String address, String squarefeet, String rooms, String bathrooms, String flooring) {
        Name = name;
        Email = email;
        PhoneNo = phoneNo;
        Address = address;
        Squarefeet = squarefeet;
        Rooms = rooms;
        Bathrooms = bathrooms;
        Flooring = flooring;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSquarefeet() {
        return Squarefeet;
    }

    public void setSquarefeet(String squarefeet) {
        Squarefeet = squarefeet;
    }

    public String getRooms() {
        return Rooms;
    }

    public void setRooms(String rooms) {
        Rooms = rooms;
    }

    public String getBathrooms() {
        return Bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        Bathrooms = bathrooms;
    }

    public String getFlooring() {
        return Flooring;
    }

    public void setFlooring(String flooring) {
        Flooring = flooring;
    }
}