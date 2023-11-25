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

public class Admin_Signup extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);
        mAuth = FirebaseAuth.getInstance();

        TextInputEditText email = (TextInputEditText) findViewById(R.id.ed1);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.ed2);
        Button btt = (Button) findViewById(R.id.b1);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = pass.getText().toString();

                if(TextUtils.isEmpty(Email)) {
                    email.requestFocus();
                    email.setError("Enter the Email");
                }
                if(TextUtils.isEmpty(Password)) {
                    pass.requestFocus();
                    pass.setError("Enter the Email");
                }

                mAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Admin_Signup.this, "Account Created!", Toast.LENGTH_SHORT).show();
                                    Intent ii = new Intent(Admin_Signup.this, Admin_login.class);
                                    startActivity(ii);
                                } else {
                                    Toast.makeText(Admin_Signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();;
                                }
                            }
                        });

            }
        });
    }
}