package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class scanpage extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;
    TextView back;
    TextInputEditText Bool, ln;
    ImageButton scan;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanpage);

        back = findViewById(R.id.tv1);
        Bool = findViewById(R.id.bool);
        ln = findViewById(R.id.ln);
        scan = findViewById(R.id.imb1);

        Intent ii4 = getIntent();
        Name = ii4.getStringExtra(library.name2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(scanpage.this, library.class);
                startActivity(i4);
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(scanpage.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan the QR Code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            String contents = intentResult.getContents();
            if (contents != null) {
                String currentTimeAndDate = getCurrentTimeAndDate();
                String UsingLocker = Bool.getText().toString();
                String lnText = ln.getText().toString();

                if (!UsingLocker.isEmpty() && !lnText.isEmpty()) {
                    int ln = Integer.parseInt(lnText);

                    updatehelper2 uhh = new updatehelper2(UsingLocker, ln, currentTimeAndDate);

                    db = FirebaseDatabase.getInstance();
                    ref = db.getReference();
                    ref.child("Student Details").child(Name).child(currentTimeAndDate).setValue(uhh).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(scanpage.this, "Registered!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if(!UsingLocker.isEmpty() && lnText.isEmpty()) {
                    updatehelper5 uhhhhh = new updatehelper5(UsingLocker, currentTimeAndDate);

                    db = FirebaseDatabase.getInstance();
                    ref = db.getReference();
                    ref.child("Student Details").child(Name).child(currentTimeAndDate).setValue(uhhhhh).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(scanpage.this, "Registered!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    private String getCurrentTimeAndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(new Date());
        return dateTime;
    }
}