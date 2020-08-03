package com.example.formvaidation;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;
import java.util.ResourceBundle;

import androidx.annotation.Nullable;

public class Postmaster extends Service{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate();
        ResourceBundle bundle = null;
        String nic = bundle.getString("nic");
        String acc = bundle.getString("acc");
        String data = bundle.getString("data");
        String fname = bundle.getString("fname");
        String lname = bundle.getString("lname");
        String mail = bundle.getString("mail");
        String add = bundle.getString("add");

        StringCharacterIterator tvReceivedData = null;
        tvReceivedData.setText(nic + acc + data + fname + lname + mail + add);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(Postmaster.this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(Postmaster.this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
