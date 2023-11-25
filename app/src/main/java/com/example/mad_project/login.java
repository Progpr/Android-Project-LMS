package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    public static String book_title;

    public static String Name = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btt = (Button) findViewById(R.id.b1);
        TextInputEditText edd1 = (TextInputEditText) findViewById(R.id.ed1);
        TextInputEditText edd2 = (TextInputEditText) findViewById(R.id.ed2);
        TextView tvv = (TextView) findViewById(R.id.tv1);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edd1.getText().toString();
                book_title=username;
                String password = edd2.getText().toString();

                DatabaseReference studentnameReference = FirebaseDatabase.getInstance().getReference(username);
                studentnameReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean found = false;
                        for (DataSnapshot studentSnapshot : snapshot.getChildren()) {
                            String Username = studentSnapshot.child("username").getValue(String.class);
                            String Password = studentSnapshot.child("password").getValue(String.class);

                            if ( Username != null && Password != null && Username.equals(username) && Password.equals(password)) {
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            Toast.makeText(login.this, "Logged in!", Toast.LENGTH_SHORT).show();

                        } else {
                            //edd1.requestFocus();
                            //edd1.setError("Invalid username or password");
                            Intent i3 = new Intent(login.this, library.class);
                            i3.putExtra(Name,username);
                            startActivity(i3);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(login.this, "Unexpected Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void register(View view) {
        Intent i2 = new Intent(login.this, register.class);
        startActivity(i2);
    }
}
