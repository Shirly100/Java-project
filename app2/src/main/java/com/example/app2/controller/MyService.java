package com.example.app2.controller;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.example.app2.controller.model.backend.factory_dal;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

/**
 * Created by Shirly on 1/18/2018.
 */

public class MyService extends IntentService {
    public static final String ACTION = "com.example.app2.controller.MyService";

    public MyService() {
        // Used to name the worker thread, important only for debugging.
        super("test-service");
    }


    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // This describes what will happen when service is triggered
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean answer= factory_dal.get_dal().getClosedOrders();
                if(answer==true)
                {

                    Log.i(TAG, "refresh car list");
                    Intent in = new Intent(ACTION);
                    in.putExtra("resultValue", "New cars available...");
                    LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(in);




                }
            }

        }, 0, 5000);

    }
}
