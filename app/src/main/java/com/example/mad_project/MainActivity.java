package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void user(View view)
    {
        Intent i = new Intent(MainActivity.this,login.class);
        startActivity(i);
    }
    public void admin(View view)
    {
        Intent i = new Intent(MainActivity.this,Admin_login.class);
        startActivity(i);
    }
}