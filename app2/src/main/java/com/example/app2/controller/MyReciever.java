package com.example.app2.controller;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.app2.controller.model.backend.factory_dal;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Shirly on 1/9/2018.
 */

public class MyReciever extends Service{
    private static final String TAG = "HelloService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand");

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean answer= factory_dal.get_dal().getClosedOrders();
                if(answer==true)
                {

                    Log.i(TAG, "refresh car list");



                }
            }
        }, 0, 5000);
        return Service.START_STICKY;

    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;

        Log.i(TAG, "Service onDestroy");
    }


}
