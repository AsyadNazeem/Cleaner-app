package com.example.cleanerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper {

    private Context con;
    private SQLiteDatabase db;


    public DBHelper(Context con) {
        this.con = con;
    }

    public DBHelper OpenDB() {

        DBConnector dbCon = new DBConnector(con);
        db = dbCon.getWritableDatabase();
        return this;

    }

    public boolean RegisterUser(User user) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("UserID", user.getUserId());
            cv.put("Password", user.getPassword());
            cv.put("UserType", user.getUserType());

            db.insert("userInfo", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public ArrayList<User> ValidLogin(String UserId, String Password) {
        ArrayList<User> userList = new ArrayList<User>();
        try {
            Cursor cursor = db.rawQuery("Select * From userInfo where UserID='" + UserId + "' and Password='" + Password + "' ", null);

            if (cursor.moveToFirst()) {
                do {
                    User user = new User();
                    user.setUserId(cursor.getString(0));
                    user.setPassword(cursor.getString(1));
                    user.setUserType(cursor.getString(2));

                    userList.add(user);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return userList;
    }


    public boolean HouseDetails(Details details) {


        try {
            ContentValues cv = new ContentValues();
            cv.put("Name", details.getName());
            cv.put("Email", details.getEmail());
            cv.put("PhoneNo", details.getPhoneNo());
            cv.put("Address", details.getAddress());
            cv.put("SquareFeet", details.getSquarefeet());
            cv.put("Rooms", details.getRooms());
            cv.put("Bathrooms", details.getBathrooms());
            cv.put("Flooring", details.getFlooring());


            db.insert("houseDetails", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public Cursor SubmitForHireCleaner()
    {
        Cursor cursor=null;
        try
        {

            cursor=db.rawQuery("Select * from houseDetails" , null);

        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return cursor;
    }


    public boolean BillingDetails(Billing billing) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("AmountForSQFT", billing.getAmountForSQFT());
            cv.put("AmountForRooms", billing.getAmountForRooms());
            cv.put("AmountForBathrooms", billing.getAmountForBathrooms());
            cv.put("TotalAmount", billing.getTotalAmount());

            db.insert("billCalculation", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }



     public Cursor getdata()
    {
      Cursor cursor1=null;
       try
       {

           cursor1=db.rawQuery("Select * from billCalculation" , null);

       }
        catch (Exception ex)
      {
           Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
       }
       return cursor1;
    }


    public Cursor getdata1()
    {
        Cursor cursor2=null;
        try
        {

            cursor2=db.rawQuery("Select * from billCalculation" , null);

        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return cursor2;



    }

    public boolean UserReview(Review review) {

        try {
            ContentValues cv = new ContentValues();
            cv.put("UName", review.getName());
            cv.put("UEmail", review.getEmail());
            cv.put("UPhoneNo", review.getPhoneNo());
            cv.put("UReview", review.getReview());

            db.insert("reviewUser", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public Cursor addforviewuser()
    {
        Cursor cursor4=null;
        try
        {

            cursor4=db.rawQuery("Select * from reviewUser" , null);

        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return cursor4;
    }

    public boolean UserCReview(CReview creview) {

        try {
            ContentValues cv = new ContentValues();
            cv.put("CName", creview.getName());
            cv.put("CEmail", creview.getEmail());
            cv.put("CPhoneNo", creview.getPhoneNo());
            cv.put("CReview", creview.getReview());

            db.insert("reviewContractor", null, cv);
            return true;
        } catch (Exception ex) {
            Toast.makeText(con, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public Cursor addforviewcontractor()
    {
        Cursor cursor5=null;
        try
        {

            cursor5=db.rawQuery("Select * from reviewContractor" , null);

        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return cursor5;
    }

}


