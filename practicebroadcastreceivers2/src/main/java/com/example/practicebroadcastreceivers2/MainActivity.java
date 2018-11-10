package com.example.practicebroadcastreceivers2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver bR;
    MyReceiverSecond secondReceiver;
    CheckConnectivity connCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bR = new MyBroadcastReceiver();
        secondReceiver = new MyReceiverSecond();

        connCheck = new CheckConnectivity();

    }

    public void onBroadCastClicked(View view) {

        Intent intent = new Intent("This is an unique action Identifier"); //3) Sending the intent with our custom action as broadcast
        intent.putExtra("message", "Broadcast is received");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);//4) send broadcast only to this app

    }

    public void onRegClicked(View view) {

        //1) Register the receiver first
        IntentFilter filter = new IntentFilter("This is an unique action Identifier");

        LocalBroadcastManager.getInstance(this).registerReceiver(bR, filter);    //  2) make scope of this intent to this app only

        Toast.makeText(this, "First Receiver is Registered", Toast.LENGTH_SHORT).show();

        LocalBroadcastManager.getInstance(this).registerReceiver(secondReceiver, filter);

        Toast.makeText(this, "second Receiver is registered", Toast.LENGTH_SHORT).show();
    }

    public void onUnRegClicked(View view) {

        LocalBroadcastManager.getInstance(this).unregisterReceiver(bR);  //5)unregister the receiver

        Toast.makeText(this, "UnRegistered Successfully", Toast.LENGTH_SHORT).show();
    }

    public void CheckConn(View view) {

        IntentFilter connFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");

        LocalBroadcastManager.getInstance(this).registerReceiver(connCheck, connFilter);

        Toast.makeText(this, "Connection receiver is registered", Toast.LENGTH_SHORT).show();

        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                Toast.makeText(this, "Cellular data is connected", Toast.LENGTH_SHORT).show();
//            }
//
//            if (activeNetwork.getType() != ConnectivityManager.TYPE_MOBILE) {
//                Toast.makeText(this, "Cellular data is disconnected", Toast.LENGTH_SHORT).show();
//            }

            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(this, "wifi is connected", Toast.LENGTH_SHORT).show();

            }

        }

        if(activeNetwork == null){
            Toast.makeText(this, "There is no Network Connectivity:", Toast.LENGTH_SHORT).show();
        }

        LocalBroadcastManager.getInstance(this).unregisterReceiver(connCheck);
        Toast.makeText(this,"unregistered Connection checker", Toast.LENGTH_SHORT).show();
    }
}
