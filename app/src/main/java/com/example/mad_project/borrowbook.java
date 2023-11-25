package com.example.mad_project;

import static com.example.mad_project.login.book_title;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class borrowbook extends AppCompatActivity {
    String name;

    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrowbook);
        Intent ii3 = getIntent();
        if (ii3 != null) {
            // Check if the intent has the extra data you are trying to retrieve
            name = ii3.getStringExtra(library.name2);
        } else {
            Toast.makeText(this, "null exception", Toast.LENGTH_SHORT).show();
        }

        TextInputEditText ed1 = (TextInputEditText) findViewById(R.id.title);
        TextView back = (TextView) findViewById(R.id.tv1);
        Button btt = (Button) findViewById(R.id.bt1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(borrowbook.this, LatestBooksActivity.class);
                startActivity(i4);
            }
        });

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ed1.getText().toString();

                if (!title.isEmpty()){
                    updatehelper4 uhhhh = new updatehelper4(title);
                    db = FirebaseDatabase.getInstance();
                    ref = db.getReference();

                    if (ref != null) {
                        ref.child("Student Details").child(book_title).child("Borrowed").setValue(uhhhh).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                ed1.setText("");
                                Toast.makeText(borrowbook.this, "Book Borrowed!", Toast.LENGTH_SHORT).show();
                                Intent ii4 = new Intent(borrowbook.this, LatestBooksActivity.class);
                                startActivity(ii4);
                            }
                        });
                    } else {
                        Toast.makeText(borrowbook.this, "Unexpected Error Occurred! ref or pathstr is null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(borrowbook.this, "Title is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}