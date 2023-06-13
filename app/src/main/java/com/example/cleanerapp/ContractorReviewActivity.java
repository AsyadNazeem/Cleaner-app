package com.example.cleanerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContractorReviewActivity extends AppCompatActivity {

    Button ButtonCAddReview,ButtonCViewUserReview,ButtonCViewContractorsReview;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_review);

        ButtonCAddReview =(Button) findViewById(R.id.btnAddContractorReview);
        ButtonCViewContractorsReview = (Button) findViewById(R.id.btnViewUsersReview);
        ButtonCViewUserReview = (Button) findViewById(R.id.btnViewContractorsReview);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        ButtonCAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCMain =
                        new Intent(ContractorReviewActivity.this,ContractorAddReview.class);
                startActivity(intentCMain);

            }
        });

        ButtonCViewContractorsReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor4 = dbHelper.addforviewuser();
                if (cursor4.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor4.moveToNext()) {
                    buffer.append("Name : " + cursor4.getString(1)+ "\n\n");
                    buffer.append("Phone No : " + cursor4.getString(2)+ "\n\n");
                    buffer.append("Email: " + cursor4.getString(3)+ "\n\n");
                    buffer.append("Review : " + cursor4.getString(4)+ "\n\n");


                    // ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                    // ListViewHouseDetails.setAdapter(listAdapter);
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(ContractorReviewActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Customer Reviews");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });

        ButtonCViewUserReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor5 = dbHelper.addforviewcontractor();
                if (cursor5.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor5.moveToNext()) {
                    buffer.append("Name : " + cursor5.getString(1)+ "\n\n");
                    buffer.append("Phone No : " + cursor5.getString(2)+ "\n\n");
                    buffer.append("Email: " + cursor5.getString(3)+ "\n\n");
                    buffer.append("Review : " + cursor5.getString(4)+ "\n\n");



                }


                AlertDialog.Builder builder = new AlertDialog.Builder(ContractorReviewActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Contractor Reviews");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });



    }
}