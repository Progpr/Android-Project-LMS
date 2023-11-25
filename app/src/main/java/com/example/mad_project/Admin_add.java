package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin_add extends AppCompatActivity {

    Button btt;

    TextInputEditText Id, Title, Units;
    String booktitle;

    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add);

        btt = (Button) findViewById(R.id.b1);
        Id = (TextInputEditText) findViewById(R.id.ID);
        Title = (TextInputEditText) findViewById(R.id.Title);
        Units = (TextInputEditText) findViewById(R.id.units);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Admin_add.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);

            }
        }



        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = Id.getText().toString();
                booktitle = Title.getText().toString();
                String units = Units.getText().toString();

                if (!ID.isEmpty() && !booktitle.isEmpty() && units!=null){
                    int unit = Integer.parseInt(units);
                    updatehelper3 uhhh = new updatehelper3(ID, booktitle, unit);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference();

                    reference.child("Books").child(ID).setValue(uhhh).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Id.setText("");
                            Title.setText("");
                            Units.setText("");
                            Toast.makeText(Admin_add.this, "Book added", Toast.LENGTH_SHORT).show();
                            Intent ii4 = new Intent(Admin_add.this, Admin_Upload.class);
                            startActivity(ii4);

                            makeNotification();
                        }
                    });
                }
            }
        });

    }
    public void makeNotification() {
        String channelID = "channel1";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channelID);
        builder.setSmallIcon(R.drawable.book)
                .setContentTitle("New Book Added!")
                .setContentText(booktitle + " was just added to the library")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent ii3 = new Intent(getApplicationContext(), login.class);
        ii3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pdi = PendingIntent.getActivity(getApplicationContext(),0,ii3, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pdi);
        NotificationManager notimanager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= 32) {
            NotificationChannel notificationChannel = notimanager.getNotificationChannel(channelID);

            if(notificationChannel == null) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                 notificationChannel = new NotificationChannel(channelID, "Book Description",importance);
                 notificationChannel.setLightColor(Color.GREEN);
                 notificationChannel.enableVibration(true);
                 notimanager.createNotificationChannel(notificationChannel);
            }
        }

        notimanager.notify(0,builder.build());
    }
}