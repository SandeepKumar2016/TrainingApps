package com.example.fragmentwithrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayFullUserDetails extends AppCompatActivity {

    TextView txtReceiveUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_full_user_details);

        txtReceiveUserName = findViewById(R.id.receiveUserName);


    }

    @Override
    protected void onStart() {
        super.onStart();
    txtReceiveUserName.setText( getIntent().getStringExtra("usernamekey"));

    }


}
