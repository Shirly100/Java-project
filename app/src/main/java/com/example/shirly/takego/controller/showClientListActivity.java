package com.example.shirly.takego.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.factory_dal;
import com.example.shirly.takego.model.entities.Branch;
import com.example.shirly.takego.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class showClientListActivity extends Activity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client_list);
        final ListView lv=(ListView)findViewById(R.id.lv);


       new AsyncTask<String, Void, List<String>>() {
            List<String> list = new ArrayList<>();
            @Override
            protected void onPostExecute(List<String> list) {
                ArrayAdapter<String>adapter=new ArrayAdapter<String>(showClientListActivity.this,android.R.layout.simple_list_item_1,list)
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
            @Override
            protected List<String> doInBackground(String... params) {

                for (int i = 0; i < factory_dal.get_dal().getClients().size(); i++) {
                    list.add((factory_dal.get_dal().getClients().get(i).getFirstName()+" "+factory_dal.get_dal().getClients().get(i).getLastName()));
                }


                return list;
            }



        }.execute();








    }

}



