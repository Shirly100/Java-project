package com.example.shirly.takego.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.factory_dal;
import com.example.shirly.takego.model.entities.Branch;

import java.util.ArrayList;
import java.util.List;

public class showClientListActivity extends Activity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client_list);
        ListView lv=(ListView)findViewById(R.id.lv);
       // factory_dal.get_dal().getClients();
        //for (int i = 0; i < list.size(); i++) {
            //E element = list.get(i);
        List<String> list=new ArrayList<>();


        for (int i = 0; i < factory_dal.get_dal().getClients().size(); i++) {
            list.add((factory_dal.get_dal().getClients().get(i).getFirstName()+" "+factory_dal.get_dal().getClients().get(i).getLastName()));
        }

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
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
        lv.setAdapter(adapter);
    }






    }



