package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SearchBooksActivity extends AppCompatActivity {

    Spinner spn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_searchbar);
        spn2= (Spinner) findViewById(R.id.spn4);

        String[] sections={"Hello User","History", "Due Amount to be Paid", "Check Latest books", "Search for books."};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sections);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn2.setAdapter(adapter);

        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedSection = (String) parentView.getItemAtPosition(position);
                if(selectedSection.equals("Home")){
                    Intent intent= new Intent(SearchBooksActivity.this, library.class);
                    startActivity(intent);
                }
                else if (selectedSection.equals("History")) {
                    Intent intent = new Intent(SearchBooksActivity.this, HistoryActivity.class);
                    startActivity(intent);
                } else if (selectedSection.equals("Due Amount to be Paid")) {
                    Intent intent = new Intent(SearchBooksActivity.this, DueAmountActivity.class);
                    startActivity(intent);
                } else if (selectedSection.equals("Check Latest books")) {
                    Intent intent = new Intent(SearchBooksActivity.this, LatestBooksActivity.class);
                    startActivity(intent);
                } else if((selectedSection.equals("Search for books")))
                {
                    Intent intent=new Intent(SearchBooksActivity.this, SearchBooksActivity.class);
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
