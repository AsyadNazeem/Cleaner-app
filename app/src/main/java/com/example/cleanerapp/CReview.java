package com.example.cleanerapp;

public class CReview {

    private String Name;
    private String Email;
    private String PhoneNo;
    private String Review;

    public CReview () {}

    public CReview(String name, String email, String phoneNo, String review) {
        Name = name;
        Email = email;
        PhoneNo = phoneNo;
        Review = review;
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

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }
}
