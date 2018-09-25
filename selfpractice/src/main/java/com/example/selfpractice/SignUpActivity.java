package com.example.selfpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText userNameAtSignup = findViewById(R.id.etForUserNameAtsignup);
        EditText passwordAtSignup = findViewById(R.id.etForPwdatSignup);
        EditText reenterPwdAtSignup = findViewById(R.id.etForReEnterPwdatSignup);
        RadioGroup radiogrp = findViewById(R.id.rGroupForGenderAtSignup);
        TextView tvForCalendar = findViewById(R.id.tvForDobAtSignup);
        Button btnSignup = findViewById(R.id.btnForSignUp);

        if(userNameAtSignup.getText().toString().length()==0){
            Toast.makeText(this, "username is required", Toast.LENGTH_SHORT).show();

        }
        if(passwordAtSignup.getText().toString().length()==0){
            Toast.makeText(this, "password is required", Toast.LENGTH_SHORT).show();

        }

   }

    @Override
    public void onClick(View v) {

    }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
}
