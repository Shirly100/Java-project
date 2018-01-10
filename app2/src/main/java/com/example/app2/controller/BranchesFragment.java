package com.example.app2.controller;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.R;
import com.example.app2.controller.model.backend.CarConst;
import com.example.app2.controller.model.backend.factory_dal;
import com.example.app2.controller.model.entities.Enums;
import com.example.app2.controller.model.entities.Wrapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class BranchesFragment extends Fragment    {


   /* ListView lv;
    SearchView sv;
    String[] teams={"Man Utd","Man City","Chelsea","Arsenal","Liverpool","Totenham"};
    ArrayAdapter<String> adapter;
    public BranchesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_branches, container, false);
        lv=(ListView) rootView.findViewById(R.id.listView1);
        sv=(SearchView) rootView.findViewById(R.id.searchView1);
        adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,teams);
        lv.setAdapter(adapter);





        sv.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });
        return rootView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater);
    }*/


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
       //=====================================================




       // ================================================
       // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.branches_and_cars, container, false);
       final ListView lv=(ListView) rootView.findViewById(R.id.listView1);
       final SearchView sv=(SearchView) rootView.findViewById(R.id.searchView1);
       List<String> str;

       new AsyncTask<String, Void, List<String>>() {
           List<String> list1 = new ArrayList<>();
           @Override
           protected void onPostExecute(List<String> list1) {
               ArrayAdapter<String> adapter;
               adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list1);
               lv.setAdapter(adapter);



               sv.setOnQueryTextListener(new OnQueryTextListener() {
                   @Override
                   public boolean onQueryTextSubmit(String text) {
                       // TODO Auto-generated method stub
                       return false;
                   }
                   @Override
                   public boolean onQueryTextChange(String text) {
                       adapter.getFilter().filter(text);
                       return false;
                   }
               });



           }



           @Override
           protected List<String> doInBackground(String... params) {
               for (int i = 0; i < factory_dal.get_dal().getBranches().size(); i++) {
                   list1.add("Branch Number: " + (factory_dal.get_dal().getBranches().get(i).getBranchNumber())+" "+(factory_dal.get_dal().getBranches().get(i).getCity()));


               }

               return list1;




           }



       }.execute();

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           public void onItemClick(AdapterView<?> parent, View view, int position,
                                   long id) {
               TextView text=(TextView) rootView.findViewById(R.id.desc);
               ListView lv2=(ListView) rootView.findViewById(R.id.listviewt2);
              // Object index=parent.getItemAtPosition(position);
               //final int index1=(int)index;
               String[] value = lv.getItemAtPosition(position).toString().split(" ");
               int branch_number=Integer.parseInt(value[2]);




               new AsyncTask<String, Void, Wrapper>() {
                   List<String> list = new ArrayList<>();

                   @Override
                   protected void onPostExecute(Wrapper w) {
                       ArrayAdapter<String> adapter;
                       adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,w.getList());
                       lv2.setAdapter(adapter);
                       if(lv2.getVisibility() == View.GONE && text.getVisibility() == View.GONE){
                           text.setText(w.getDec());
                           text.setVisibility(View.VISIBLE);

                           lv2.setVisibility(View.VISIBLE);


                       }else{
                           lv2.setVisibility(View.GONE);
                           text.setVisibility(View.GONE);
                       }





                   }



                   @Override
                   protected Wrapper doInBackground(String... params) {
                       int Bnumber=0;
                       int parking=0;
                       String city=null;
                       String street=null;
                       int Anumber=0;


                       for (int i = 0; i < factory_dal.get_dal().getBranches().size(); i++) {
                           if (factory_dal.get_dal().getBranches().get(i).getBranchNumber() == branch_number) {
                               Bnumber = factory_dal.get_dal().getBranches().get(i).getBranchNumber();
                               parking = factory_dal.get_dal().getBranches().get(i).getParking_spacees();
                               city = factory_dal.get_dal().getBranches().get(i).getCity();
                                street = factory_dal.get_dal().getBranches().get(i).getStreet();
                               Anumber = factory_dal.get_dal().getBranches().get(i).getNumber();
                               break;


                           }
                       }
                       final ContentValues contentValues = new ContentValues();
                       contentValues.put(CarConst.BranchConst.PARKING, parking);
                       contentValues.put(CarConst.BranchConst.BRANCH_NAME, Bnumber);
                       contentValues.put(CarConst.BranchConst.CITY, city);
                       contentValues.put(CarConst.BranchConst.STREET, street);
                       contentValues.put(CarConst.BranchConst.NUMBER, Anumber);









                       try{
                           for (int i = 0; i < factory_dal.get_dal().getBranchCars(contentValues).size(); i++) {
                               list.add("Car Number: " + (factory_dal.get_dal().getBranchCars(contentValues).get(i).getCarNumber())+"\n"+"model Type: "+(factory_dal.get_dal().getBranchCars(contentValues).get(i).getModelType()));

                           }
                       }
                       catch (Exception e)
                       {
                           list.add("Nothing to show\n");
                       }



                       Wrapper w = new Wrapper();
                       w.setList(list);
                       String desc="\n"+factory_dal.get_dal().getDesc(id);
                       w.setDec(desc);

                       return w;




                   }



               }.execute();

               lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   public void onItemClick(AdapterView<?> parent, View view, int position,
                                           long id) {
                       String[] value = lv2.getItemAtPosition(position).toString().split(" ");
                       String[] value2=value[2].split("\n");
                       long car_number=Integer.parseInt(value2[0]);

                       new AsyncTask<Void, Void, Integer>() {

                           @Override
                           protected void onPostExecute(Integer orderNumber) {
                               super.onPostExecute(orderNumber);

                               Toast.makeText(getActivity(),"order number : " + orderNumber,Toast.LENGTH_SHORT).show();



                           }



                           @Override
                           protected Integer doInBackground(Void... params) {
                               long carNumber=car_number;
                               float mileage=0;



                               for (int i = 0; i < factory_dal.get_dal().getCars().size(); i++) {
                                   if (factory_dal.get_dal().getCars().get(i).getCarNumber() == car_number) {
                                       int branch_number=factory_dal.get_dal().getCars().get(i).getBranchNumber();
                                       String model=factory_dal.get_dal().getCars().get(i).getModelType();
                                       mileage=factory_dal.get_dal().getCars().get(i).getMileage();
                                       Enums.Answer occupied=factory_dal.get_dal().getCars().get(i).getOccupied();

                                       ContentValues c = new ContentValues();
                                       c.put(CarConst.CarsConst.CAR_NUMBER,carNumber);
                                       c.put(CarConst.CarsConst.BRANCH_NUMBER,branch_number);
                                       c.put(CarConst.CarsConst.MODEL_TYPE,model);
                                       c.put(CarConst.CarsConst.MILEAGE,mileage);
                                       c.put(CarConst.CarsConst.OCCUPIED,occupied.toString());
                                       String str=factory_dal.get_dal().updateOccupied(c);





                                   }
                               }
                               Date date = new Date();
                               String rental_start= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                               Random r = new Random();
                               float mileage_start = mileage;
                               Enums.Order order= Enums.Order.OPEN;
                               String clientNumber="314793910";

                               final ContentValues contentValues = new ContentValues();


                               contentValues.put(CarConst.OrderConst.ORDER, order.toString());
                               contentValues.put(CarConst.OrderConst.MILEAGE_START_VALUE,mileage_start);
                               contentValues.put(CarConst.OrderConst.CLIENT_NUMBER,clientNumber);
                               contentValues.put(CarConst.OrderConst.CAR_NUMBER, carNumber);
                               contentValues.put(CarConst.OrderConst.RENTAL_START_DATE, rental_start);
                               return factory_dal.get_dal().addOrder(contentValues);

                           }



                       }.execute();
                   }
               });





           }
       });
       return rootView;
   }
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater);
    }





}