package com.example.practicebroadcastreceivers2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class CheckConnectivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {//this is a intent throwed by system
            Log.d("NetworkCheckReceiver", "NetworkCheckReceiver invoked...");


            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (!noConnectivity) {
                Toast.makeText(context, "Network is connected", Toast.LENGTH_SHORT).show();
                Log.d("NetworkCheckReceiver", "connected");
            }
            else
            {
                Toast.makeText(context, "Network  disconnected", Toast.LENGTH_SHORT).show();

                Log.d("NetworkCheckReceiver", "disconnected");
            }
        }
//        ConnectivityManager cm =
//                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//
//        if (activeNetwork != null) {
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                Toast.makeText(context, "network is connected", Toast.LENGTH_SHORT).show();
//            }
//
//            if (activeNetwork.getType() != ConnectivityManager.TYPE_MOBILE) {
//                Toast.makeText(context, "network is disconnected", Toast.LENGTH_SHORT).show();
//            }
//
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                Toast.makeText(context, "wifi is connected", Toast.LENGTH_SHORT).show();
//
//            }

            //boolean isConnected = activeNetwork != null &&
            //activeNetwork.isConnectedOrConnecting();

            //throw new UnsupportedOperationException("Not yet implemented");
        }
    }

