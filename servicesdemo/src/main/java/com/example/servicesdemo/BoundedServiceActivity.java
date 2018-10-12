package com.example.servicesdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class BoundedServiceActivity extends AppCompatActivity {
Intent boundedServiceIntent;
BoundedService boundedService;
boolean onBind=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service);
        boundedServiceIntent=new Intent(this,BoundedService.class);
    }

    public void onBindServiceBtnClick(View view) {
        bindService(boundedServiceIntent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void onUnBindServiceBtnClick(View view) {
        unbindService(serviceConnection);
        onBind=false;
    }



    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder ibinder) {
            BoundedService.LocalBinder localBinder=(BoundedService.LocalBinder)ibinder;
            boundedService=localBinder.getService();
            Log.d("Activity","Service binded");
            onBind=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            onBind=false;
        }
    };

    public void onShowRandomNumBtnClick(View view) {
        if (onBind)
           Toast.makeText(this, boundedService.getRandomNumber()+"",Toast.LENGTH_SHORT).show();
        else Toast.makeText(this,"Service unbinded. Please bind for number",Toast.LENGTH_SHORT).show();
    }
}
