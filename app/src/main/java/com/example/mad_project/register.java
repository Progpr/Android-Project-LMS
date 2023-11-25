package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class register extends AppCompatActivity {

    Button btt;
    EditText name, school, year, sem, password, roll, sap;

    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btt = findViewById(R.id.b1);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        sem = findViewById(R.id.sem);
        year = findViewById(R.id.year);
        roll = findViewById(R.id.roll);
        school = findViewById(R.id.school);
        sap= findViewById(R.id.sap);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = name.getText().toString();
                String Password = password.getText().toString();
                String School = school.getText().toString();
                String Roll = roll.getText().toString();
                String Year = year.getText().toString();
                String Sem = sem.getText().toString();
                String Sap = sap.getText().toString();


                if(!Roll.isEmpty() || !Username.isEmpty() || !Password.isEmpty() ||
                !School.isEmpty() || !Year.isEmpty() || !Sem.isEmpty() || !Sap.isEmpty())
                {
                    updatehelper uh = new updatehelper(Username, Password, Roll, Sap,
                            Sem, Year, School);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference();

                    reference.child("Student Details").child(Username).setValue(uh).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            name.setText("");
                            password.setText("");
                            school.setText("");
                            roll.setText("");
                            school.setText("");
                            year.setText("");
                            sap.setText("");
                            sem.setText("");
                            Toast.makeText(register.this, "Student Details Saved !", Toast.LENGTH_SHORT).show();
                            Intent ii = new Intent(register.this,login.class);
                            startActivity(ii);
                        }
                    });
                }
            }
        });
    }
}