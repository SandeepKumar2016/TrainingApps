package com.example.servicespractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent startserviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
         startserviceIntent = new Intent(this, UnboundedService.class);
        startserviceIntent.putExtra("somevalue", 5);
        startService(startserviceIntent);

    }

    public void stopService(View view) {
        Log.d("Destroy", "Unbound service destroyed;--->");
        super.onDestroy();

        stopService(startserviceIntent);
        Log.d("Stop", "Unbound service stop:-->");


    }
}
