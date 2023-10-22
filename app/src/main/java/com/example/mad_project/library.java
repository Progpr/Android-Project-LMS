package com.example.mad_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class library extends AppCompatActivity {

    ImageButton Qr, Books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inital_page);

        Qr = findViewById(R.id.imb1);
        Books = findViewById(R.id.imb2);

        Qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentintegrator = new IntentIntegrator(library.this);
                intentintegrator.setOrientationLocked(true);
                intentintegrator.setPrompt("Scan a QR Code");
                intentintegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentintegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult != null){
            String contents = intentResult.getContents();
            if(contents != null){
                Toast.makeText(this, "Code Scanned!", Toast.LENGTH_SHORT).show();
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}