package com.example.mad_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.jar.Attributes;

public class library extends AppCompatActivity{
//    ImageButton Qr, Books;
//    Spinner spn;


    public static String name2 = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inital_page);

        Intent ii3 = getIntent();
        if (ii3 != null) {
            // Check if the intent has the extra data you are trying to retrieve
            String extraData = ii3.getStringExtra("your_key");
        } else {
            Toast.makeText(this, "null exception", Toast.LENGTH_SHORT).show();
        }

        String name = ii3.getStringExtra(login.Name);

        Spinner spn= (Spinner) findViewById(R.id.spinner);

        ImageButton Qr= (ImageButton) findViewById(R.id.imb1);
        ImageButton Books= (ImageButton) findViewById(R.id.imb2);

        String[] sections={"BookSphere","Home", "Due Amount", "Latest Books", "Search Books", "Logout"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sections);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedSection = (String) parentView.getItemAtPosition(position);
                if (selectedSection.equals("Home")) {
                    Intent intent = new Intent(getApplicationContext(), library.class);
                    startActivity(intent);
                }
                else if (selectedSection.equals("Due Amount")) {
                    Intent intent = new Intent(getApplicationContext(), DueAmountActivity.class);
                    startActivity(intent);
                } else if (selectedSection.equals("Latest Books")) {
                    Intent intent = new Intent(getApplicationContext(), LatestBooksActivity.class);
                    intent.putExtra(name2,name);
                    startActivity(intent);
                }
                else if(selectedSection.equals("Search Books"))
                {
                    Intent ii7 = new Intent(getApplicationContext(), SearchBooksActivity.class);
                    startActivity(ii7);
                }
                else if(selectedSection.equals("Logout"))
                {
                    Intent intent=new Intent(library.this, MainActivity.class);
                    startActivity(intent);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here if no item is selected
            }
        });

        Qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii2 = new Intent(library.this, scanpage.class);
                ii2.putExtra(name2,name);
                startActivity(ii2);
            }
        });

        Books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(library.this, main_book.class);
                i2.putExtra(name2,name);
                startActivity(i2);
            }
        });
    }

    public void books(View view) {
        try {
            Intent i2 = new Intent(library.this, main_book.class);
            startActivity(i2);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}