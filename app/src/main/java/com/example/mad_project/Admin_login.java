package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin_login extends AppCompatActivity {
    FirebaseAuth mAuth;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent ii = new Intent(getApplicationContext(), Admin_Upload.class);
            startActivity(ii);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        mAuth = FirebaseAuth.getInstance();

        TextInputEditText email = (TextInputEditText) findViewById(R.id.ed1);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.ed2);
        Button btt = (Button) findViewById(R.id.b1);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = pass.getText().toString();

                if (TextUtils.isEmpty(Email)) {
                    email.requestFocus();
                    email.setError("Enter the Email");
                }
                if (TextUtils.isEmpty(Password)) {
                    pass.requestFocus();
                    pass.setError("Enter the Email");
                }

                mAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Admin_login.this, "Logged in !", Toast.LENGTH_SHORT).show();
                                    Intent ii2 = new Intent(Admin_login.this, Admin_Upload.class);
                                    startActivity(ii2);

                                } else {
                                    Toast.makeText(Admin_login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    public void signup(View view) {
        Intent i6 = new Intent(Admin_login.this, Admin_Signup.class);
        startActivity(i6);
    }
}