package com.example.mad_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LatestBooksActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_newbooks);
        TextView back= (TextView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getApplicationContext(), library.class);
                startActivity(i4);
            }
        });

        ListView l =findViewById(R.id.lv);
        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter ad = new ArrayAdapter<String>(this,
                R.layout.listviewitems,R.id.tv1,list);
        l.setAdapter(ad);
        DatabaseReference ref =
                FirebaseDatabase.getInstance().getReference().child("Books");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot parent) {
                list.clear();

                for (DataSnapshot child : parent.getChildren()) {
                    updatehelper4 info = child.getValue(updatehelper4.class);
                    String Title= info.getTitle();
                    list.add(Title);
                }
                ad.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        Button btt2 = (Button) findViewById(R.id.b1);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii7 = new Intent(LatestBooksActivity.this,borrowbook.class);
                startActivity(ii7);
            }
        });
    }
}

