package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ButtonCallRegister,ButtonCallLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonCallRegister=(Button) findViewById(R.id.btnCallRegister);
        ButtonCallLogin=(Button) findViewById(R.id.btnCallLogin);

        ButtonCallLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin =
                        new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentLogin);
            }
        });
        ButtonCallRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentRegister =
                        new Intent(MainActivity.this,Register_User.class);
                startActivity(intentRegister);
            }
        });



    }
}