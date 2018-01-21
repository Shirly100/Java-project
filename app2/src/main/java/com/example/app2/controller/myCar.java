package com.example.app2.controller;


import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
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
import com.example.app2.controller.model.backend.CarConst;
import com.example.app2.R;
import com.example.app2.controller.model.backend.factory_dal;
import com.example.app2.controller.model.entities.Enums;
import com.example.app2.controller.model.entities.Wrapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.text.format.DateFormat;
import java.util.Date;
import java.util.List;


import static com.example.app2.controller.LoginActivity.clientNumber;
import static java.lang.String.valueOf;

/**
 * A simple {@link Fragment} subclass.
 */
public class myCar extends Fragment implements View.OnClickListener {


//    public myCar() {
//        // Required empty public constructor
//    }

    private Button upButton;
    private Button downButton;
    private EditText editText;
    private float uprange = 100000;
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

        textView2 = (TextView) rootView.findViewById(R.id.textView2);
       mileagePicker(rootView,textView2);

        spinnerFilling = (Spinner) rootView.findViewById(R.id.fuel);
        setSpeaner(spinnerFilling);
        findMyCar(LoginActivity.clientNumber,rootView);
        quantity = (EditText) rootView.findViewById(R.id.quantity);

        returnCar = (Button) rootView.findViewById(R.id.returnCar);
        returnCar.setOnClickListener( this );






        return  rootView;

    }

    public void mileagePicker(View rootView, TextView textView2) {

        upButton = (Button) rootView.findViewById(R.id.upButton);
        downButton = (Button) rootView.findViewById(R.id.downButton);
        editText = (EditText) rootView.findViewById(R.id.numberEditText);


        upButton.setOnClickListener(new View.OnClickListener() {

            /**
             * @param v
             */
            public void onClick(View v) {
                downButton.setBackgroundResource(R.drawable.timepicker_down_normal);
                upButton.setBackgroundResource(R.drawable.timepicker_up_pressed);
                if (values >= downrange && values <= uprange)
                    values+=0.7;
                if (values > uprange)
                    values = downrange;
                editText.setText(String.format("%.2f", values));
                String mileage= valueOf(values);
                myCar.this.textView2.setText(mileage);


            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                downButton .setBackgroundResource(R.drawable.timepicker_down_pressed);
                upButton.setBackgroundResource(R.drawable.timepicker_up_normal);
                if (values >= downrange && values <= uprange)
                    values=values-=0.7;

                if (values < downrange)
                    values = uprange;


                editText.setText(String.format("%.2f", values));
                String mileage= valueOf(values);
                myCar.this.textView2.setText(mileage);
            }
        });





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
                        if (factory_dal.get_dal().getOrders().get(i).getClientNumber() == id&&factory_dal.get_dal().getOrders().get(i).getOrder().toString() == "OPEN") {
                            myCarNumber = factory_dal.get_dal().getOrders().get(i).getCarNumber();
                            myDate=factory_dal.get_dal().getOrders().get(i).getRental_srart_date();
                            for (int j = 0; j < factory_dal.get_dal().getCars().size(); j++) {
                                if(factory_dal.get_dal().getCars().get(j).getCarNumber()==myCarNumber)
                                {
                                    myBranchNumber = factory_dal.get_dal().getCars().get(j).getBranchNumber();
                                    myModel = factory_dal.get_dal().getCars().get(j).getModelType();
                                    break;

                                }

                            }
                            break;
                        }


                    }
                    values[0] = Long.toString(myCarNumber);
                    values[1] = valueOf(myBranchNumber);
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
            final ContentValues contentValues = new ContentValues();

            float mileage_now =Float.parseFloat(myCar.this.textView2.getText().toString());

            contentValues.put(CarConst.OrderConst.FUEL_FILLING, myCar.this.spinnerFilling.getSelectedItem().toString());
            String isFill=myCar.this.spinnerFilling.getSelectedItem().toString();
            contentValues.put(CarConst.OrderConst.QUANTITY_OF_FUEL, myCar.this.quantity.getText().toString());
            float amount = Float.parseFloat(myCar.this.quantity.getText().toString());
            Date date = new Date();
            String rental_end= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date);


            contentValues.put(CarConst.OrderConst.RENTAL_END_DATE, rental_end);



            new AsyncTask<Void, Void, String>() {
                @Override
                protected void onPostExecute(String pay) {
                    super.onPostExecute(pay);
                    myCar.this.textView2.setText("Payment: "+pay);
                    textView2.setVisibility(View.VISIBLE);

                }

                @Override
                protected String doInBackground(Void... params) {

                    for (int i = 0; i < factory_dal.get_dal().getOrders().size(); i++) {
                        if (factory_dal.get_dal().getOrders().get(i).getClientNumber() == LoginActivity.clientNumber&&valueOf(factory_dal.get_dal().getOrders().get(i).getOrder()).toString()=="OPEN") {
                            long orderNumber = factory_dal.get_dal().getOrders().get(i).getOrderNumber();
                            contentValues.put(CarConst.OrderConst.ORDER_NUMBER, valueOf(orderNumber).toString());
                            float mileage_start = (factory_dal.get_dal().getOrders().get(i).getMileage_start_value());
                            String rental_start = (factory_dal.get_dal().getOrders().get(i).getRental_srart_date());
                            float totalMileage=mileage_now+mileage_start;


                            long second = 1000l;
                            long minute = 60l * second;
                            long hour = 60l * minute;
                            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                            Date dateStart = null;
                            try {
                                dateStart = sdf.parse(rental_start);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                            Date dateEnd = null;
                            try {
                                dateEnd = sdf1.parse(rental_end);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            long diff = dateEnd.getTime() - dateStart.getTime();
                            float hh = diff/ (3600 * 1000);
                            float mm = (diff - hh * 3600 * 1000) / (60 * 1000);
                            float minutes=(float)((hh*60)+mm)/60;


                            String time=valueOf(minutes).toString();
                            float total_mileage = mileage_now -mileage_start;
                            double payment=0;
                            if(isFill=="YES")
                            {
                                payment = ((total_mileage*minutes)*6.06)-(6.06*amount);

                            }
                            else
                            {
                                payment = ((total_mileage*minutes)*6.06);

                            }

                            String strpayment = String.format("%.2f", payment);
                            Enums.Order returnOrder = Enums.Order.CLOSE;
                            contentValues.put(CarConst.OrderConst.PAYMENT, strpayment);
                            contentValues.put(CarConst.OrderConst.ORDER, returnOrder.toString());
                            contentValues.put(CarConst.OrderConst.MILEAGE_END_VALUE, valueOf(mileage_now).toString());

                            ContentValues CV = new ContentValues();
                            long mycarNumber = factory_dal.get_dal().getOrders().get(i).getCarNumber();
                            CV.put(CarConst.CarsConst.CAR_NUMBER, mycarNumber);
                            CV.put(CarConst.CarsConst.MILEAGE, valueOf(mileage_now).toString());
                            factory_dal.get_dal().returnCar(CV);
                            factory_dal.get_dal().updateOrder(contentValues);
                            //return strpayment;
                            return strpayment;


                        }
                    }
                    return null;



                }






            }.execute();

            Toast.makeText(getActivity(),"returning car" ,Toast.LENGTH_SHORT).show();
//            if(textView2.getVisibility() == View.GONE ){
//                textView2.setVisibility(View.VISIBLE);
//
//
//
//
//            }else{
//
//                textView2.setVisibility(View.GONE);
//            }





        }
    }

    private final BroadcastReceiver brod = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {

            Toast.makeText(context,"New cars are available",Toast.LENGTH_LONG).show();
        }
    };



    @Override
    public void onResume(){
        super.onResume();
        // put your code here...



        getActivity().startService(new Intent(getActivity(),MyReciever.class));

    }






    }





