package com.example.app2.controller;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.R;
import com.example.app2.controller.model.backend.factory_dal;
import com.example.app2.controller.model.entities.Enums;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class myCar extends Fragment implements View.OnClickListener {


    public myCar() {
        // Required empty public constructor
    }

    private Button upButton;
    private Button downButton;
    private EditText editText;
    private float uprange = 400;
    private float downrange = 0;
    private float values = 0;
    private Spinner spinnerFilling;
    private EditText carNumber;
    private EditText branchNumber;
    private EditText model;
    private EditText date;
    private Button returnCar;
    private EditText quantity;
    private TextView textView2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment;
        View rootView = inflater.inflate(R.layout.my_car, container, false);

        String mileageValue=mileagePicker(rootView);

        spinnerFilling = (Spinner) rootView.findViewById(R.id.fuel);
        setSpeaner(spinnerFilling);
        int clientNumber=2147483647;
        findMyCar(clientNumber,rootView);
        quantity = (EditText) rootView.findViewById(R.id.quantity);
        returnCar = (Button) rootView.findViewById(R.id.returnCar);
        textView2 = (TextView) rootView.findViewById(R.id.textView2);
        textView2.setText(mileageValue);



        return  rootView;

    }

    public String mileagePicker(View rootView) {

        upButton = (Button) rootView.findViewById(R.id.upButton);
        downButton = (Button) rootView.findViewById(R.id.downButton);
        editText = (EditText) rootView.findViewById(R.id.numberEditText);

        upButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                downButton.setBackgroundResource(R.drawable.timepicker_down_normal);
                upButton.setBackgroundResource(R.drawable.timepicker_up_pressed);
                if (values >= downrange && values <= uprange)
                    values+=0.1;
                if (values > uprange)
                    values = downrange;
                editText.setText("" + values);

            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                downButton .setBackgroundResource(R.drawable.timepicker_down_pressed);
                upButton.setBackgroundResource(R.drawable.timepicker_up_normal);
                if (values >= downrange && values <= uprange)
                    values=values-=0.1;

                if (values < downrange)
                    values = uprange;

                editText.setText(values + "");
            }
        });

        String mileageValue=editText.getText().toString();
        return mileageValue;


    }


    private void setSpeaner(Spinner selected) {
        selected.setAdapter(new ArrayAdapter<Enums.Answer>(getActivity(), android.R.layout.simple_list_item_1, Enums.Answer.values()));
        selected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                Toast.makeText(getActivity(), "yes selected", Toast.LENGTH_LONG).show();

            }
            else{
                    Toast.makeText(getActivity(), "no selected", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

    }
    public void findMyCar(int id,View rootView)
    {
        try {


            new AsyncTask<Integer, Void, String[]>() {

                long myCarNumber = 0;
                int myBranchNumber = 0;
                String myModel = "";
                String myDate="";

                @Override
                protected void onPostExecute(String[] values) {
                    carNumber = (EditText) rootView.findViewById(R.id.carNumber);
                    branchNumber = (EditText) rootView.findViewById(R.id.branchNumber);
                    model = (EditText) rootView.findViewById(R.id.model);
                    date=(EditText) rootView.findViewById(R.id.date);

                    carNumber.setText(values[0]);
                    branchNumber.setText(values[1]);
                    model.setText(values[2]);
                    date.setText(values[3]);
                }

                @Override
                protected String[] doInBackground(Integer... params) {
                     String[] values = new String[4];

                    for (int i = 0; i < factory_dal.get_dal().getOrders().size(); i++) {
                        if (factory_dal.get_dal().getOrders().get(i).getClientNumber() == id) {
                            myCarNumber = factory_dal.get_dal().getOrders().get(i).getCarNumber();
                            myDate=factory_dal.get_dal().getOrders().get(i).getRental_srart_date();
                            for (int j = 0; j < factory_dal.get_dal().getCars().size(); i++) {
                                if(factory_dal.get_dal().getCars().get(i).getCarNumber()==myCarNumber)
                                {
                                    myBranchNumber = factory_dal.get_dal().getCars().get(i).getBranchNumber();
                                    myModel = factory_dal.get_dal().getCars().get(i).getModelType();
                                    break;

                                }

                            }
                            break;
                        }


                    }
                    values[0] = Long.toString(myCarNumber);
                    values[1] = String.valueOf(myBranchNumber);
                    values[2] = myModel;
                    values[3]=myDate;
                    return values;


                }


            }.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }



    }
    @Override
    public void onClick(View v) {
        if (v == returnCar) {
            Toast.makeText(getActivity(),"returning car" ,Toast.LENGTH_SHORT).show();
            if(textView2.getVisibility() == View.GONE ){

                textView2.setVisibility(View.VISIBLE);



            }else{

                textView2.setVisibility(View.GONE);
            }





        }
    }







}





