package com.example.cleanerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContractsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Details> list;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contracts);


        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        recyclerView = findViewById(R.id.rvContracts);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new  DBHelper(this).SubmitForHireCleaner();

        while(cursor.moveToNext())
        {
            Details obj = new Details();

            cursor.getString(1);
            cursor.getString(2);
            cursor.getString(3);
            cursor.getString(4);
            cursor.getString(5);
            cursor.getString(6);
            cursor.getString(7);
            cursor.getString(8);

            list.add(obj);

        }

    }
}
