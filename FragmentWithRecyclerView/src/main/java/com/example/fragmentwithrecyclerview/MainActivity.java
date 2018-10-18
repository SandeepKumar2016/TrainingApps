package com.example.fragmentwithrecyclerview;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserData> dataArrayList;
    private AdapterForRecyclerView adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        adapter.setOnRecyclerItemClickedListener(this);


        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.frameLayoutInMainActivity, FragmentWithRecyclerView.newInstance("value1", "value2"), FragmentWithRecyclerView.class.getSimpleName());
        //3rd param is tag name just to identify this fragment using findFragmentBytag

        fragmentTransaction.commit();
    }


}
