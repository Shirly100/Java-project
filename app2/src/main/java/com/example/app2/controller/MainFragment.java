package com.example.app2.controller;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.R;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    TextView textService;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        getActivity().startService(new Intent(getActivity(),MyService.class));
       textService= (TextView)  rootView.findViewById( R.id.descService );


//        final Button mainButton = (Button) rootView.findViewById(R.id.main_button);
//        mainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mainButton.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
//            }
//        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Register for the particular broadcast based on ACTION string
        IntentFilter filter = new IntentFilter(MyService.ACTION);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(testReceiver, filter);
        // or `registerReceiver(testReceiver, filter)` for a normal broadcast
    }

    @Override
    public void onPause() {
        super.onPause();
        // Unregister the listener when the application is paused
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(testReceiver);
        // or `unregisterReceiver(testReceiver)` for a normal broadcast
    }

    private BroadcastReceiver testReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String resultValue = intent.getStringExtra("resultValue");
            Toast.makeText(getActivity(), resultValue, Toast.LENGTH_SHORT).show();
                if(textService.getVisibility() == View.GONE ){
                    Date date = new Date();
                    String now= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date);
                    textService.setText(now+":"+"  "+resultValue);
                    textService.setVisibility(View.VISIBLE);
                }

        }
    };


}