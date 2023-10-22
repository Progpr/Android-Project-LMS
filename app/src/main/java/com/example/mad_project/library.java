package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class library extends AppCompatActivity {

    ImageButton imb1, imb2;
    Spinner spn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inital_page);

        imb1= (ImageButton) findViewById(R.id.imb1);
        imb2= (ImageButton) findViewById(R.id.imb2);
        spn= (Spinner) findViewById(R.id.spinner);

        String[] sections={"Hello User","History", "Due Amount to be Paid", "Check Latest books", "Search for books."};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sections);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedSection = (String) parentView.getItemAtPosition(position);
                if (selectedSection.equals("Hello User")) {
                    Toast.makeText(library.this, "Hello User selected", Toast.LENGTH_SHORT).show();
                } else if (selectedSection.equals("History")) {
                    Intent intent = new Intent(library.this, HistoryActivity.class);
                    startActivity(intent);
                } else if (selectedSection.equals("Due Amount to be Paid")) {
                    Intent intent = new Intent(library.this, DueAmountActivity.class);
                    startActivity(intent);
                } else if (selectedSection.equals("Check Latest books")) {
                    Intent intent = new Intent(library.this, LatestBooksActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here if no item is selected
            }
        });
    }
    public void book(View view) {
        try {
            Intent i = new Intent(library.this, main_book.class);
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}