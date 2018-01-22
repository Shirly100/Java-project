package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.factory_dal;
import com.example.shirly.takego.model.entities.Car;
import com.example.shirly.takego.model.entities.Enums;

import static com.example.shirly.takego.R.id.addCarButton1;
//The AddCarActivity inserts the data from the user to the cars table in the database
public class AddCarActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }

    private EditText branchNumberEditText;
    private EditText modelTypeEditText;
    private EditText mileageEditText;
    private EditText carNumberEditText;
    private Spinner occupied;
    private Button addCarButton1;


    /**
     * The function onClick handle the click event
     * @param v
     */
    @Override
    public void onClick(View v) {
        if ( v == addCarButton1 )
        {
            addCar();
        }
    }



    /**
     * The function addCar takes the information that the user insert into the textViews and add it to the cars table in
     * the database
     */
    private void addCar() {
        final ContentValues contentValues = new ContentValues();
        try {
            int branchNumber = Integer.valueOf(this.branchNumberEditText.getText().toString());
            contentValues.put(CarConst.CarsConst.BRANCH_NUMBER, branchNumber);
            contentValues.put(CarConst.CarsConst.MODEL_TYPE, this.modelTypeEditText.getText().toString());
            float mileage = Float.valueOf(this.mileageEditText.getText().toString());
            contentValues.put(CarConst.CarsConst.MILEAGE, mileage);
            long car_number = Integer.valueOf(this.carNumberEditText.getText().toString());
            contentValues.put(CarConst.CarsConst.CAR_NUMBER,car_number);
            contentValues.put(CarConst.CarsConst.OCCUPIED, this.occupied.getSelectedItem().toString());


//the AsyncTask handle the insertion of the information into the database
            new AsyncTask<Void, Void, Long>() {
                @Override     protected void onPostExecute(Long carNumber) {
                    super.onPostExecute(carNumber);
                    if (carNumber > 0)
                        Toast.makeText(getBaseContext(), "inserted carNumber: " + carNumber, Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(AddCarActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
                @Override
                protected Long doInBackground(Void... params) {

                    return factory_dal.get_dal().addCar(contentValues);



                }



            }.execute();

        }
        catch (Exception e) {}
    }









    private void findViews() {
        branchNumberEditText = (EditText)findViewById( R.id.branchNumberEditText );
        modelTypeEditText = (EditText)findViewById( R.id. modelTypeEditText );
        mileageEditText = (EditText)findViewById( R.id.mileageEditText );
        carNumberEditText = (EditText)findViewById( R.id.carNumberEditText);
        occupied = (Spinner) findViewById(R.id.spinnerOccupied);
        setOccupied(occupied);
        addCarButton1 = (Button)findViewById(R.id.addCarButton1 );
        addCarButton1.setOnClickListener( this );     }

    private void setOccupied(Spinner selected) {
        selected.setAdapter(new ArrayAdapter<Enums.Answer>(this, android.R.layout.simple_list_item_1, Enums.Answer.values()));
        selected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

    }




}


