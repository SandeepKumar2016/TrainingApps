package com.example.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       myReceiver= new MyReceiver();

    }

    public void onButtonClicked(View view) {
        //now sending  Intent with our custom Actions as broadcast
        Intent intent=new Intent("com.example.broadcastreciver.CUSTOM_ACTION");
        intent.putExtra("message","Hi i got recieved");
//        sendBroadcast(intent);//send broadcast to android system

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);//send broadacst only to ur app
    }

    public void onRegClicked(View view) {
        IntentFilter intentFilter=new IntentFilter("com.example.broadcastreciver.CUSTOM_ACTION");
//        registerReceiver(myReceiver,intentFilter);//dynamically registering receiver to recieve specific Action from Android apps using intentFilter
LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver,intentFilter);//this  will make receiver scope limited to this app only
    }


    public void onUnregClicked(View view) {
//        unregisterReceiver(myReceiver);  unegister receiver in global scope
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
    }
}
