package com.example.cleanerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    CardView cvHireCleaner,cvReview,cvHouseDetails,cvAmount,cvAboutUs,cvLogout;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        cvHireCleaner = (CardView)findViewById(R.id.btnHireCleaner);
        cvHouseDetails = (CardView)findViewById(R.id.btnHouseDetails);
        cvReview = (CardView)findViewById(R.id.btnUReview);
        cvAmount =(CardView)findViewById(R.id.btnAmount);
        cvAboutUs =(CardView)findViewById(R.id.btnAboutus);
        cvLogout = (CardView)findViewById(R.id.btnULogOut);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();


        cvHireCleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Cursor cursor = dbHelper.SubmitForHireCleaner();
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("Name : " + cursor.getString(1)+ "\n\n");
                    buffer.append("Phone No : " + cursor.getString(2)+ "\n\n");
                    buffer.append("Email: " + cursor.getString(3)+ "\n\n");
                    buffer.append("Address : " + cursor.getString(4)+ "\n\n");
                    buffer.append("SquareFeet Amount : " + cursor.getString(5)+ "\n\n");
                    buffer.append("Room Amount : " + cursor.getString(6)+ "\n\n");
                    buffer.append("Bathroom Amount : " + cursor.getString(7)+ "\n\n");
                    buffer.append("Flooring Type : " + cursor.getString(8) + "\n\n\n\n");


                    // ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                    // ListViewHouseDetails.setAdapter(listAdapter);
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Jobs");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });

        cvReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentUMain =
                        new Intent(UserActivity.this,UserReviewActivity.class);
                startActivity(intentUMain);
            }
        });

        cvHouseDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentUMain =
                        new Intent(UserActivity.this,House_details_Activity.class);
                startActivity(intentUMain);

            }
        });

        cvAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentUMain =
                        new Intent(UserActivity.this,BillCalculationActivity.class);
                startActivity(intentUMain);

            }
        });

        cvAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentUMain =
                        new Intent(UserActivity.this,About_Us_Activity.class);
                startActivity(intentUMain);

            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentUMain = new Intent(UserActivity.this,LoginActivity.class);
                startActivity(intentUMain);
                Toast.makeText(UserActivity.this,"Logout Successful",Toast.LENGTH_LONG).show();

            }
        });

    }
}