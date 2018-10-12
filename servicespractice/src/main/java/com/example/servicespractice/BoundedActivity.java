package com.example.servicespractice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class BoundedActivity extends AppCompatActivity {

    //This is an activity that binds to BoundedService and calls getRandomNumber() when a button is clicked:

    BoundedService mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(this, BoundedService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unbindService(mConnection);
        mBound=false;
    }


    public void genRandomNum(View view) {

        ///Call a method from the BoundedService.
        // However, if this call were something that might hang, then this request should
        // occur in a separate thread to avoid slowing down the activity performance.

        if (mBound){
            int num = mService.getRandomNum();
            Toast.makeText(this, "number:" + num, Toast.LENGTH_SHORT).show();
        }
    }


    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


        BoundedService.MyActCanCall localBinder = (BoundedService.MyActCanCall)service;
        mService = localBinder.getService();
        mBound=true;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound=false;

        }
    };
}
