package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContractorAddReview extends AppCompatActivity {

    Button buttonCSubmit;
    EditText EditTextCName,EditTextCEmail,EditTextCPhoneNo,EditTextCReview;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_add_review);


        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextCName = (EditText) findViewById(R.id.txtCCName);
        EditTextCEmail = (EditText) findViewById(R.id.txtCCEmail);
        EditTextCPhoneNo = (EditText) findViewById(R.id.txtCCPhoneNo);
        EditTextCReview = (EditText) findViewById(R.id.txtCCReview);
        buttonCSubmit = (Button) findViewById(R.id.btnCSubmit);

        buttonCSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (EditTextCName.getText().toString().isEmpty() ||
                        EditTextCEmail.getText().toString().isEmpty() ||
                        EditTextCPhoneNo.getText().toString().isEmpty()  ||
                        EditTextCReview.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be blank", Toast.LENGTH_LONG).show();
                } else {

                    CReview creview = new CReview(EditTextCName.getText().toString(),
                            EditTextCEmail.getText().toString(),
                            EditTextCPhoneNo.getText().toString(),
                            EditTextCReview.getText().toString());

                    if (dbHelper.UserCReview(creview)) {
                        Toast.makeText(getApplicationContext(), "Review Successfully Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Review Inserted Failed", Toast.LENGTH_LONG).show();
                    }
                }


            }

        });

    }
}