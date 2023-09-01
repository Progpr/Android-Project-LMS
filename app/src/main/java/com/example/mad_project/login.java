package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {
    Intent ii = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //login validation

        //password criteria
        //one digit
        //one special character
        //one lowercase
        //one uppercase
        //length - 8 (minimum)

        //username criteria
        //no space
        //no symbols

        Button btt = (Button) findViewById(R.id.b1);
        TextInputEditText edd1 = (TextInputEditText) findViewById(R.id.ed1);
        TextInputEditText edd2 = (TextInputEditText) findViewById(R.id.ed2);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edd1.getText().toString();
                String password = edd2.getText().toString();

                if(username.length() == 0){
                    edd1.requestFocus();
                    edd1.setError("Username cannot be empty");
                }
                if(password.length()==0){
                    edd2.requestFocus();
                    edd2.setError("Password cannot be empty");
                }
            }
        });

    }

}