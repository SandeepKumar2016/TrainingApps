package com.example.sharedpref_practice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView TxtName;
    EditText EditTxtName;

    TextView TxtPassword;
    EditText EditTxtPassword;

    Button btnSave;
    Button btnNextAct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TxtName = findViewById(R.id.txtName);
        EditTxtName = findViewById(R.id.editTxtName);

        TxtPassword = findViewById(R.id.txtPassword);
        EditTxtPassword = findViewById(R.id.editTxtPassword);

        btnSave = findViewById(R.id.btnSave);
        btnNextAct = findViewById(R.id.btnNextAct);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickSave(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nakme",EditTxtName.getText().toString());
        editor.putString("password", EditTxtPassword.getText().toString());

        editor.commit();

        Toast.makeText(this, "Data was saved", Toast.LENGTH_SHORT).show();

    }

    public void onClickNextActivity(View view) {

        Intent intent = new Intent(this,NextActivity.class);
        startActivity(intent);

    }
}
