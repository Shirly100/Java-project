package com.example.app2.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by Shirly on 1/18/2018.
 */

public class broad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // assumes WordService is a registered service
        Intent intent1 = new Intent(context, MyReciever.class);
        context.startService(intent1);
    }
}
