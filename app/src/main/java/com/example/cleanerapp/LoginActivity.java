package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText TextLoginUserId, TextLoginPassword;
    Button ButtonLogin, ButtonDontHaveAccount;

    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();


        TextLoginUserId = (EditText) findViewById(R.id.txtLUserId);
        TextLoginPassword = (EditText)  findViewById(R.id.txtLPassword);
        ButtonLogin = (Button) findViewById(R.id.btnLLogin);
        ButtonDontHaveAccount =(Button) findViewById(R.id.btnLDontHaveAccount);

        ButtonDontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin =
                        new Intent(LoginActivity.this,Register_User.class);
                startActivity(intentLogin);


            }
        });

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<User> userDetails=dbHelper.ValidLogin(TextLoginUserId.getText().toString(),
                        TextLoginPassword.getText().toString());

                if(userDetails.size()!=0)
                {
                    User user=userDetails.get(0);
                    String UserType=user.getUserType();

                    Toast.makeText(getApplicationContext(),
                            "User found "+UserType,Toast.LENGTH_LONG).show();

                    if(UserType.equals("Contractor"))
                    {
                        Intent intentRegister = new Intent(LoginActivity.this,
                                ContractorActivity.class);
                        startActivity(intentRegister);

                    }

                    else
                    {
                        Intent intentRegister = new Intent(LoginActivity.this,
                                UserActivity.class);
                        startActivity(intentRegister);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Inavalid User", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}