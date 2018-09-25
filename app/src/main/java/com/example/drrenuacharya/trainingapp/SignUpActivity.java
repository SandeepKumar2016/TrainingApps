package com.example.drrenuacharya.trainingapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvForDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true); //these enables back arrow to goto Home

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        EditText etUserNameatSignup=findViewById(R.id.etForUserNameAtsignup);
        EditText etPwdatSignup = findViewById(R.id.etForPwdatSignup);
        EditText etReenterPwd = findViewById(R.id.etForReEnterPwdatSignup);
        RadioGroup rgForGender = findViewById(R.id.rGroupForGenderAtSignup);
         tvForDob = findViewById(R.id.tvForDobAtSignup);
        Button btnForSignup = findViewById(R.id.btnForSignUp);
        tvForDob.setOnClickListener(this);
        btnForSignup.setOnClickListener(this);
//        rgForGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  //radiobtn change listner to handle any coding changes onchanging radio button slection
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//            }
//        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
Calendar calendar;
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tvForDobAtSignup){
            calendar=Calendar.getInstance();
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
tvForDob.setText(dayOfMonth+"/"+month+"/"+year);
                }
            }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
    }
}
