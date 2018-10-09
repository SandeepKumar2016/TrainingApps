package com.example.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class UnBoundedService extends Service {
    TimerTask timerTask;
    int counter = 0;

    public UnBoundedService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("UnboundedSErvice", "service started");
    }

    int counterValue;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { //this function will be called on every start of a service by one or more Actvities
        counterValue = intent.getIntExtra("counterValue", 0);
        printSeconds(counterValue);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        timerTask.cancel();
        Log.d("UnboundedSErvice", "service destroyed");
        super.onDestroy();
    }

    void printSeconds(final int secondsUpTo) {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.d("seconds", counter + "");
                counter++;
                if (counter == secondsUpTo) stopSelf();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);

    }
}
