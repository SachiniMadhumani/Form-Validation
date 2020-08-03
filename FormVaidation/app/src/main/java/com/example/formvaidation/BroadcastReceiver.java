package com.example.formvaidation;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import java.text.StringCharacterIterator;
import java.util.ResourceBundle;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    private static final String TAG = "BroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String log = "Action: " + intent.getAction() + "\n" +
                "URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n";
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();

        BroadcastReceiver br = new BroadcastReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br, filter);
    }

    private void registerReceiver(BroadcastReceiver br, IntentFilter filter) {
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


}
