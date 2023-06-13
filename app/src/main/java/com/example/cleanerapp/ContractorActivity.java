package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContractorActivity extends AppCompatActivity {

    CardView cvContracts,cvReview,cvAboutUs,cvLogout;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor);


        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        cvContracts =(CardView) findViewById(R.id.btnContracts);
        cvReview =(CardView) findViewById(R.id.btnReview);
        cvAboutUs = (CardView) findViewById(R.id.btnAboutUs);
        cvLogout = (CardView) findViewById(R.id.btnLogout);

        cvContracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCMain =
                        new Intent(ContractorActivity.this,ContractsActivity.class);
                startActivity(intentCMain);

            }
        });

        cvReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCMain =
                        new Intent(ContractorActivity.this,ContractorReviewActivity.class);
                startActivity(intentCMain);

            }
        });

        cvAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCMain =
                        new Intent(ContractorActivity.this,About_Us_Activity.class);
                startActivity(intentCMain);

            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCMain = new Intent(ContractorActivity.this,LoginActivity.class);
                startActivity(intentCMain);
                Toast.makeText(ContractorActivity.this,"Logout Successful",Toast.LENGTH_LONG).show();


            }
        });


    }
}