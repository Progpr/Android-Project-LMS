package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin_Upload extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_upload);
        Button btt = (Button) findViewById(R.id.bt1);

        mAuth = FirebaseAuth.getInstance();
        Button Logout = (Button) findViewById(R.id.logout);

        user = mAuth.getCurrentUser();
        if(user==null){
            Intent ii2 = new Intent(getApplicationContext(), Admin_login.class);
            startActivity(ii2);
            finish();
        }

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent ii9 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ii9);
                finish();
            }
        });

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii3 = new Intent(getApplicationContext(), Admin_add.class);
                startActivity(ii3);
            }
        });
    }
}