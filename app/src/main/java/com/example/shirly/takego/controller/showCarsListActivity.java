package com.example.shirly.takego.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.factory_dal;

import java.util.ArrayList;
import java.util.List;

public class showCarsListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cars_list);
        ListView lvCar=(ListView)findViewById(R.id.lvCar);
        // factory_dal.get_dal().getClients();
        //for (int i = 0; i < list.size(); i++) {
        //E element = list.get(i);
        List<String> list=new ArrayList<>();


        for (int i = 0; i < factory_dal.get_dal().getCars().size(); i++) {
            list.add("Car Number: "+(factory_dal.get_dal().getCars().get(i).getCarNumber()));
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        {

            public View getView(int position, View convertView, ViewGroup parent) {
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 35);

                // Return the view
                return view;
            }
        };
        lvCar.setAdapter(adapter);
    }
}
