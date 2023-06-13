package com.example.cleanerapp;

public class Billing {

    private int AmountForSQFT;
    private int AmountForRooms;
    private int AmountForBathrooms;
    private int TotalAmount;

    public Billing() {}

    public Billing(int amountForSQFT, int amountForRooms, int amountForBathrooms, int totalAmount) {
        AmountForSQFT = amountForSQFT;
        AmountForRooms = amountForRooms;
        AmountForBathrooms = amountForBathrooms;
        TotalAmount = totalAmount;
    }

    public int getAmountForSQFT() {
        return AmountForSQFT;
    }

    public void setAmountForSQFT(int amountForSQFT) {
        AmountForSQFT = amountForSQFT;
    }

    public int getAmountForRooms() {
        return AmountForRooms;
    }

    public void setAmountForRooms(int amountForRooms) {
        AmountForRooms = amountForRooms;
    }

    public int getAmountForBathrooms() {
        return AmountForBathrooms;
    }

    public void setAmountForBathrooms(int amountForBathrooms) {
        AmountForBathrooms = amountForBathrooms;
    }

    public int getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        TotalAmount = totalAmount;
    }
}