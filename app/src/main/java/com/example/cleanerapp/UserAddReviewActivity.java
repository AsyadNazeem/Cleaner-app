package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserAddReviewActivity extends AppCompatActivity {

    Button buttonSubmit;
    EditText EditTextName,EditTextEmail,EditTextPhoneNo,EditTextReview;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_review);


        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        EditTextName = (EditText) findViewById(R.id.txtUName);
        EditTextEmail = (EditText) findViewById(R.id.txtUEmail);
        EditTextPhoneNo = (EditText) findViewById(R.id.txtUPhoneNo);
        EditTextReview = (EditText) findViewById(R.id.txtUReview);
        buttonSubmit = (Button) findViewById(R.id.btnUSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (EditTextName.getText().toString().isEmpty() ||
                        EditTextEmail.getText().toString().isEmpty() ||
                        EditTextPhoneNo.getText().toString().isEmpty()  ||
                        EditTextReview.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be blank", Toast.LENGTH_LONG).show();
                } else {

                    Review review = new Review(EditTextName.getText().toString(),
                            EditTextEmail.getText().toString(),
                            EditTextPhoneNo.getText().toString(),
                            EditTextReview.getText().toString());

                    if (dbHelper.UserReview(review)) {
                        Toast.makeText(getApplicationContext(), "Review Successfully Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Review Inserted Failed", Toast.LENGTH_LONG).show();
                    }
                }


            }

        });




    }
}