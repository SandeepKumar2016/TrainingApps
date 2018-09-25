package com.example.selfpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  {

    EditText userName, password;
    Button userLoginBtn;
    int counter;//variable
    float attendancePercentage;
    static int counter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.userPwd);
        userLoginBtn = findViewById(R.id.loginBtn);
        TextView signupTxt = findViewById(R.id.signupTxt);



        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userName.getText().toString().contentEquals(password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("UserName", userName.getText().toString());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "username and password is incorrect", Toast.LENGTH_SHORT).show();

                } if (v.getId()==R.id.signupTxt){
                    startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

                }



            }
        });
    }



}
