package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register_User extends AppCompatActivity {


    EditText EditTextName,EditTextPassword,EditTextConformPassword;
    Spinner SpinnerUserType;
    Button ButtonRegister,ButtonAllReadyHaveAccount;
    String UserType[]={"User","Contractor"};

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextName=(EditText) findViewById(R.id.txtRUserId);
        EditTextPassword=(EditText) findViewById(R.id.txtRPassword);
        EditTextConformPassword=(EditText) findViewById(R.id.txtRCPassword);
        ButtonRegister=(Button) findViewById(R.id.btnRRegister);
        ButtonAllReadyHaveAccount = (Button) findViewById(R.id.btnRAlreadyHaveAccount);


        SpinnerUserType=(Spinner) findViewById(R.id.spRUserType);

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,UserType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerUserType.setAdapter(ad);

        ButtonAllReadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin =
                        new Intent(Register_User.this,LoginActivity.class);
                startActivity(intentLogin);

            }
        });

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(EditTextName.getText().toString().isEmpty() ||
                        EditTextPassword.getText().toString().isEmpty() ||
                        EditTextConformPassword.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields Can't be blank",Toast.LENGTH_LONG).show();
                }
                else if (EditTextPassword.getText().toString().length()<3)
                {
                    Toast.makeText(getApplicationContext(),"password must have more than 3 characters",Toast.LENGTH_LONG).show();
                }
                else if(!EditTextPassword.getText().toString().equals(EditTextConformPassword.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"password and conform password should match", Toast.LENGTH_LONG).show();
                }
                else
                {
                    User user=new User(EditTextName.getText().toString(), EditTextPassword.getText().toString(),
                            SpinnerUserType.getSelectedItem().toString());
                    if (dbHelper.RegisterUser(user))
                    {
                        Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Could not create user", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}