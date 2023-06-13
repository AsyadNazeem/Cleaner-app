package com.example.cleanerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class House_details_Activity extends AppCompatActivity {

    ImageView AddImage, AddFromCamera, AddFromGallery;
    Button ButtonHouseDetailsSubmit, ButtonCalculateAmount;
    Spinner SpinnerFlooringType;
    EditText TextAddress, TextSquareFeet, TextAmountOfRooms, TextAmountOfBathrooms, TextCustomerName, TextCustomerEmail, TextCustomerPhoneNo;

    String FlooringType[] = {"Cement", "Marble", "Tiles", "Wood", "Other"};

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_details);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        TextCustomerName = (EditText) findViewById(R.id.txtCName);
        TextCustomerEmail = (EditText) findViewById(R.id.txtCEmail);
        TextCustomerPhoneNo = (EditText) findViewById(R.id.txtCPhoneNo);
        TextAddress = (EditText) findViewById(R.id.txtAddress);
        TextSquareFeet = (EditText) findViewById(R.id.txtSquareFeet);
        TextAmountOfRooms = (EditText) findViewById(R.id.txtAmountOfRooms);
        TextAmountOfBathrooms = (EditText) findViewById(R.id.txtAmountOfBathrooms);
        SpinnerFlooringType = (Spinner) findViewById(R.id.spFlooringType);
        ButtonHouseDetailsSubmit = (Button) findViewById(R.id.btnHouseDetailsSubmit);
        ButtonCalculateAmount = (Button) findViewById(R.id.btnCalculateAmount);
        AddImage = (ImageView) findViewById(R.id.imgAddImage);


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, FlooringType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerFlooringType.setAdapter(ad);

        ButtonCalculateAmount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//======================================================How the bill is calculated========================================================================//
//-----------------------------------------------------Square Feet Total calculation-------------------------------------------------------------------//

                String sqft = TextSquareFeet.getText().toString();
                int stringamnt = Integer.parseInt(sqft);
                int AmountForSquareFeet = stringamnt * 5;



//------------------------------------------------------------Room Total Calculation -----------------------------------------------------------//

                String Rooms = TextAmountOfRooms.getText().toString();
                int stringRooms = Integer.parseInt(Rooms);

                int AmountOfRooms = stringRooms;

                if(stringRooms <= 3)
                {
                    AmountOfRooms = stringRooms * 0;
                }
                else if (stringRooms > 3)
                {
                    AmountOfRooms = (stringRooms - 3) * 1000;
                }

//------------------------------------------------------------Bathroom Total Calculation -----------------------------------------------------------//

                String Bathrooms = TextAmountOfBathrooms.getText().toString();
                int stringBathrooms = Integer.parseInt(Bathrooms);
                int AmountOfBathrooms = stringBathrooms;

                if(stringBathrooms <= 2)
                {
                    AmountOfBathrooms = stringBathrooms * 0;
                }
                else if (stringBathrooms > 2)
                {
                    AmountOfBathrooms = (stringBathrooms - 2) * 2000;
                }

                int Totalbillamount = AmountForSquareFeet + AmountOfRooms + AmountOfBathrooms;
                Toast.makeText(getApplicationContext(), "Total Bill Amount = Rs " + Totalbillamount ,Toast.LENGTH_LONG ).show();

                Billing billing = new Billing(AmountForSquareFeet , AmountOfRooms, AmountOfBathrooms, Totalbillamount);

                if (dbHelper.BillingDetails(billing)) {
                    Toast.makeText(getApplicationContext(), "Billing details Successfully Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Billing details Inserted Failed", Toast.LENGTH_LONG).show();
                }

                Cursor cursor2 = dbHelper.getdata1();
                if(cursor2.getCount() == 0)
                {
                    Toast.makeText(getApplicationContext(),"No data found", Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor2.moveToNext())
                {

                    buffer.append("Total For SquareFeet : Rs" + cursor2.getString(1)+"\n\n");
                    buffer.append("Amount For Rooms : Rs" + cursor2.getString(2)+"\n\n");
                    buffer.append("Amount For Bathrooms : Rs" + cursor2.getString(3)+"\n\n");
                    buffer.append("Total Bill Amount : Rs" + cursor2.getString(4)+"\n\n\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(House_details_Activity.this);
                builder.setCancelable(true);
                builder.setTitle("Invoice");
                builder.setMessage(buffer.toString());
                builder.show();

            }

        });

        ButtonHouseDetailsSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextCustomerName.getText().toString().isEmpty() ||
                        TextCustomerEmail.getText().toString().isEmpty() ||
                        TextCustomerPhoneNo.getText().toString().isEmpty()  ||
                        TextAddress.getText().toString().isEmpty() ||
                        TextSquareFeet.getText().toString().isEmpty() ||
                        TextAmountOfRooms.getText().toString().isEmpty() ||
                        TextAmountOfBathrooms.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Can't be blank", Toast.LENGTH_LONG).show();
                } else {
                    Details details = new Details(TextCustomerName.getText().toString(),
                            TextCustomerPhoneNo.getText().toString(),
                            TextCustomerEmail.getText().toString(),TextAddress.getText().toString(),
                            TextSquareFeet.getText().toString(), TextAmountOfRooms.getText().toString(),
                            TextAmountOfBathrooms.getText().toString(), SpinnerFlooringType.getSelectedItem().toString());

                    if (dbHelper.HouseDetails(details)) {
                        Toast.makeText(getApplicationContext(), "House details Successfully Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "House details Inserted Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }


        });


    }
}