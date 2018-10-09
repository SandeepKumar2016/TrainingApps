package com.example.servicesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent serviceIntetn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startUnBindService(View view) {
      serviceIntetn = new Intent(this,UnBoundedService.class);
        serviceIntetn.putExtra("counterValue",200);
        startService(serviceIntetn);//starts servvice specified in intent
    }

    public void stopUnBindService(View view) {
        stopService(serviceIntetn);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(serviceIntetn);
    }
}
