package com.example.recyclerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements cityAdapter.onRecyclerItemClikedListener{

    ArrayList<nederalndsCities> dataArrayList;
    RecyclerView recyclerView;
    private cityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prepareData();

        initRecyclerView();

    }


    private void initRecyclerView() {
        Log.d("Recycler view", "Recycler view in Main activity is created");

        recyclerView = findViewById(R.id.recyclerviewPractice);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter = new cityAdapter(this, dataArrayList);

        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerItemClickedListener(this);



    }


    public void prepareData() {

        dataArrayList = new ArrayList<nederalndsCities>();

        for (int index = 0; index < 20; index++) {

            dataArrayList.add(new nederalndsCities("Harry Potter", "Amsterdam", R.drawable.ic_launcher_background));
        }

    }


    @Override
    public void onItemClicked(int position) {

        nederalndsCities nederalndsCities = dataArrayList.get(position);

        Toast.makeText(this, nederalndsCities.getPersonName() + " Lives in " + nederalndsCities.getCityName(), Toast.LENGTH_SHORT).show();
    }
}
