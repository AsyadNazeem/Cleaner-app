package com.example.cleanerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BillCalculationActivity extends AppCompatActivity {

    Button ButtonBillCalculationMethod,ButtonViewBill;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_calculation);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();


        ButtonBillCalculationMethod = (Button) findViewById(R.id.btnHowBillCalculated);
        ButtonViewBill = (Button) findViewById(R.id.btnViewBill);

        ButtonBillCalculationMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentBCal =
                        new Intent(BillCalculationActivity.this,BillingDetailsActivity.class);
                startActivity(intentBCal);

            }
        });




        ButtonViewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


        Cursor cursor1 = dbHelper.getdata();
        if(cursor1.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(),"No data found", Toast.LENGTH_LONG).show();
        }
        StringBuffer buffer = new StringBuffer();
            while (cursor1.moveToNext())
            {

                buffer.append("Total For SquareFeet : Rs" + cursor1.getString(1)+"\n\n");
                buffer.append("Amount For Rooms : Rs" + cursor1.getString(2)+"\n\n");
                buffer.append("Amount For Bathrooms : Rs" + cursor1.getString(3)+"\n\n");
                buffer.append("Total Bill Amount : Rs" + cursor1.getString(4)+"\n\n\n\n");

            }

                AlertDialog.Builder builder = new AlertDialog.Builder(BillCalculationActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Invoice");
            builder.setMessage(buffer.toString());
            builder.show();

            }
        });


    }

}