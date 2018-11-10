package com.example.threads_practice;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String someText;
    String anotherText;
    Handler handler;

    TextView textView;
    EditText timeinSeconds;
    Button btnAsync;
    TextView result;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.i("thread ID:---->>", String.valueOf(Thread.currentThread().getId()));

        textView = findViewById(R.id.txtView);

        timeinSeconds = findViewById(R.id.in_time);

        btnAsync = findViewById(R.id.btn_run);

        result = findViewById(R.id.tv_result);
progressBar=findViewById(R.id.progressBArAtMain);
        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoingAsyncTask doingAsyncTaskone = new DoingAsyncTask();

                //In this tutorial we’ll implement an AsyncTask that makes a process to go to
                // sleep for a given period of time as set by the user.

                String sleepTime = timeinSeconds.getText().toString();


                doingAsyncTaskone.execute(sleepTime);
                Log.d("sleep time given byuser", sleepTime);

            }
        });


         handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                textView.setText((CharSequence)msg.obj);
                //Toast.makeText(MainActivity.this, (CharSequence) msg.obj, Toast.LENGTH_SHORT).show();
//new Handler().postDelayed(new Runnable() {
//    @Override
//    public void run() {//posts this Runnable to calling Thread(here it is main thread)
//
//    }
//},2000);

            }
        };
    }

    public class DoingAsyncTask extends AsyncTask<String, String, String>{

//        ProgressDialog progressDialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            progressDialog = ProgressDialog.show(MainActivity.this,"progressDialog","some");
progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {//here resp comes
            super.onPostExecute(s);

            result.setText(s);

//            progressDialog.dismiss();
            progressBar.setVisibility(View.GONE);

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected String doInBackground(String... params) {



            int time = Integer.parseInt(params[0])*1000;
            String resp = null;
            try {
                Thread.sleep(time);
                resp = "slept for" +params[0] + "seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return resp;//this resp goes to onpostexecute as string
        }
    }



    Runnable RunObj = new Runnable() {
        @Override
        public void run() {

            someText="";

            for (int i=0;i<5;i++){

                someText = someText + "Eindhoven"+i;

            }
            Log.i("thread ID:---->>", String.valueOf(Thread.currentThread().getId()));

            //Log.d("thread---->>",someText);


            runOnUiThread(new Runnable() {//This accepts runnable argument and runs that in UiThread
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this,someText, Toast.LENGTH_SHORT).show();
                }
            });

        }
    };


    public void onClickRunnable(View view) {

        Thread th = new Thread(RunObj);
        th.start();


    }


    public void ThreadHandler(View view) {

        new Thread(){

            @Override
            public void run() {
                super.run();

                anotherText=" ";
                for (int i=0;i<5;i++){

                    anotherText = anotherText + "Rotterdam"+i;

                }

                Log.i("thread ID:---->>", String.valueOf(Thread.currentThread().getId()));


                Message myMessage = new Message();
                myMessage.obj = anotherText;
                Log.d("message obj contains-->", (String) myMessage.obj);
                myMessage.what=12;

                handler.sendMessage(myMessage);//send message using handler to the MainThread

            }
        }.start();
    }
}












