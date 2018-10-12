package com.example.servicespractice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class UnboundedService extends Service {
    public UnboundedService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    int valuehere;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        valuehere = intent.getIntExtra("somevalue", 0);

        Log.d("Unbounded", valuehere + "Unbounded service started--->");


        for (int i =0; i<valuehere; i++){

        Log.d("value is", i +"values are <<<---");
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
