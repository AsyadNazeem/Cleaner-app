package com.example.cleanerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.AbstractQueue;

public class DBConnector extends SQLiteOpenHelper
{
    public DBConnector(Context context)
    {
        super(context, "Cleaner_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table userInfo (UserID VARCHAR PRIMARY KEY NOT NULL,Password VARCHAR,UserType VARCHAR)");

            sqLiteDatabase.execSQL("create table houseDetails (HouseId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name VARCHAR, Email VARCHAR, PhoneNo VARCHAR ,Address VARCHAR, Squarefeet INTEGER, Rooms INTEGER, Bathrooms INTEGER, Flooring VARCHAR)");

            sqLiteDatabase.execSQL("create table billCalculation (BillId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,AmountForSQFT DOUBLE, AmountForRooms DOUBLE, AmountForBathrooms DOUBLE, TotalAmount DOUBLE )");

            sqLiteDatabase.execSQL("Create table reviewUser (UReviewId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, UName VARCHAR, UEmail VARCHAR, UPHONENo VARCHAR, UReview VARCHAR)");

            sqLiteDatabase.execSQL("create table reviewContractor (CReviewId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CName VARCHAR, CEMAIL VARCHAR, CPhoneNO VARCHAR, CReview VRCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        if (i > i1) {

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM billCalculation"); //delete all rows in a table
            db.close();

            db.execSQL("DROP TABLE IF EXISTS billCalculation");
        }

    }
}
