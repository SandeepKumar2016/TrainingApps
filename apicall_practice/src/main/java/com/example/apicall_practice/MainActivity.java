package com.example.apicall_practice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public TextView txtResult;
    Button btnParse, btnPostApiCall;

    RequestQueue mQueue;
    RequestQueue mQueueOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = findViewById(R.id.myText);
        btnParse = findViewById(R.id.parse);

        // Instantiate the RequestQueue.
        mQueue = Volley.newRequestQueue(this);
        mQueueOne = Volley.newRequestQueue(this);

//        btnParse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MethodToParse();
//            }
//        });

//        btnPostApiCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendWorkPostRequest();
//            }
//        });

    }


    private void MethodToParse() {
        String myUrl = "https://api.github.com/search/repositories?q=rails/rails";
        Log.d("thread ID:---->>", String.valueOf(Thread.currentThread().getId()));

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, myUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                        public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("items");

                            for (int i = 0; i < 1; i++) {

                                JSONObject items = jsonArray.getJSONObject(i);

                                String fullName = items.getString("full_name");

                                txtResult.append((CharSequence) fullName+"\n");
                                //txtResult.setText((CharSequence) fullName);

                                // Log.d("git arraylist", String.valueOf(items));

                                Log.d("git arraylist", String.valueOf(fullName));


                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                    }
                });
        mQueue.add(request);

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

    public void sendWorkPostRequest(View view) {
        try {
            String postURL = "http://developer.dairyplus.in/oauth/token";

            StringRequest stringRequest = new StringRequest(Request.Method.PUT, postURL,

                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {


                            Log.d("post login", response);

                        }

                    },
                    new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
            )


             {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("UserName", "sandeept");
                    params.put("Password", "yetanotherwin");

                    params.put("client_id", "DPLUSAPP");
                    params.put("grant_type", "password");

                    params.put("client_secret", "E11F8358-FCAB-4EFC-97B0-511BC9F782B4");

                    return params;
                }
                 @Override
                 public Map<String, String> getHeaders() throws AuthFailureError {
                     Map<String,String> params = new HashMap<String, String>();
                     params.put("Content-Type","application/text");
                     return params;
                 }
            };
            mQueueOne.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
