package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    Spinner spn;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_history);
        spn= (Spinner) findViewById(R.id.spn1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedSection = (String) parentView.getItemAtPosition(position);
                    if (selectedSection.equals("History")) {
                        Intent intent = new Intent(HistoryActivity.this, HistoryActivity.class);
                        startActivity(intent);
                    } else if (selectedSection.equals("Home")) {
                        Intent intent = new Intent(HistoryActivity.this, library.class);
                        startActivity(intent);
                    }
                    else if (selectedSection.equals("Due Amount to be Paid")) {
                        Intent intent = new Intent(HistoryActivity.this, DueAmountActivity.class);
                        startActivity(intent);
                    } else if (selectedSection.equals("Check Latest books")) {
                        Intent intent = new Intent(HistoryActivity.this, LatestBooksActivity.class);
                        startActivity(intent);
                    } else if((selectedSection.equals("Search for books")))
                    {
                        Intent intent=new Intent(HistoryActivity.this, SearchBooksActivity.class);
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