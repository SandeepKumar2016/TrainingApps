package com.example.drrenuacharya.trainingapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//checking version control. Its working

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

     EditText etForUserName,etForPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etForUserName=findViewById(R.id.etForUserName);
          etForPwd =findViewById(R.id.etForPwd);
        Button btnForSignin=findViewById(R.id.btnForSignin);
        btnForSignin.setOnClickListener(this);
//        btnForSignin.setOnClickListener(new View.OnClickListener() { //local scoped interface implementation that creates anonymous interfaceobject and passes to setonclickListner
//            @Override
//            public void onClick(View v) {
//                if(etForUserName.getText().toString().contentEquals(etForPwd.getText().toString()))
//                    Toast.makeText(LoginActivity.this,"Success",Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LoginActivity.class.getSimpleName(),"onstart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LoginActivity.class.getSimpleName(),"onResume()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LoginActivity.class.getSimpleName(),"onstop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LoginActivity.class.getSimpleName(),"onDestroy()");

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnForSignin){
            if(etForUserName.getText().toString().contentEquals(etForPwd.getText().toString())) {
                Intent intentToMain = new Intent(this, MainActivity.class);//from current context to Ongoing Activity
                intentToMain.putExtra("username",etForUserName.getText().toString());//key,value pair
                startActivity(intentToMain);
                finish();// this will destroy the activity
            }else
                Toast.makeText(this,"Username and password mismatch",Toast.LENGTH_SHORT).show();
        }

    }
}
