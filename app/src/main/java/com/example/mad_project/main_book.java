package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class main_book extends AppCompatActivity
    {
        Spinner spn2;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.act_book);
            spn2= (Spinner) findViewById(R.id.spinner2);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spn2.setAdapter(adapter);
            spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String selectedSection = (String) parentView.getItemAtPosition(position);


                        if (selectedSection.equals("History")) {
                            Intent intent = new Intent(main_book.this, HistoryActivity.class);
                            startActivity(intent);
                    } else if (selectedSection.equals("Due Amount to be Paid")) {
                        // Open Due Amount activity
                        Intent intent = new Intent(main_book.this, DueAmountActivity.class);
                        startActivity(intent);
                    } else if (selectedSection.equals("Check Latest books")) {
                        // Open Latest Books activity
                        Intent intent = new Intent(main_book.this, LatestBooksActivity.class);
                        startActivity(intent);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Do nothing here if no item is selected
                }
            });
        }
        }


