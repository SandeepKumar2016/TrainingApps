package com.example.drrenuacharya.trainingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvForDob;
    private EditText etUserNameatSignup, etPwdatSignup, etReenterPwd;
    RadioGroup rgForGender;

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
        etUserNameatSignup = findViewById(R.id.etForUserNameAtsignup);
        etPwdatSignup = findViewById(R.id.etForPwdatSignup);
        etReenterPwd = findViewById(R.id.etForReEnterPwdatSignup);
        rgForGender = findViewById(R.id.rGroupForGenderAtSignup);
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
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    Calendar calendar;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvForDobAtSignup) {
            calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    tvForDob.setText(dayOfMonth + "/" + month + "/" + year);
                }
            },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        } else if (v.getId() == R.id.btnForSignUp) {
            if (isFormValid()) {
                Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show();
                Intent intentToMain = new Intent(this, MainActivity.class);
                intentToMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentToMain);
            }
        }
    }

    boolean isFormValid() {
        if (etUserNameatSignup.getText().toString().isEmpty()) {
            Toast.makeText(this, "username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etUserNameatSignup.getText().toString().length() < 3) {
            Toast.makeText(this, "username must be minimum 3 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPwdatSignup.getText().toString().isEmpty()) {
            Toast.makeText(this, "password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!etReenterPwd.getText().toString().contentEquals(etPwdatSignup.getText().toString())) {
            Toast.makeText(this, "password is mismatched", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tvForDob.getText().toString().isEmpty()) {
            Toast.makeText(this, "plese enter your D.O.B", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
