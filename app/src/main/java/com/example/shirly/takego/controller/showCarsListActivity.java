package com.example.shirly.takego.controller;

import android.app.Activity;
import android.os.AsyncTask;
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
        final ListView lvCar = (ListView) findViewById(R.id.lvCar);




      new AsyncTask<String, Void, List<String>>() {
        List<String> list = new ArrayList<>();
        @Override
        protected void onPostExecute(List<String> list) {
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(showCarsListActivity.this,android.R.layout.simple_list_item_1,list)
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
        @Override
        protected List<String> doInBackground(String... params) {

            for (int i = 0; i < factory_dal.get_dal().getCars().size(); i++) {
                list.add((factory_dal.get_dal().getCars().get(i).getCarNumber()+", "+factory_dal.get_dal().getCars().get(i).getModelType()));
            }

            return list;
        }



    }.execute();





    }
}
