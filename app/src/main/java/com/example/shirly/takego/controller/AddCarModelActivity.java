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
import com.example.shirly.takego.model.entities.CarModel;
import com.example.shirly.takego.model.entities.Enums;

import java.util.ArrayList;
import java.util.List;
//The AddCarModelActivity inserts the data from the user to the models table in the database
public class AddCarModelActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
        findViews();
    }

    private EditText modelCodeEditText;
    private EditText companyEditText;
    private EditText modelNameEditText;
    private EditText EngineCapacityEditText;
    //private EditText gearEditText;
    private EditText SeatingCapacityEditText;
    private EditText DoorsNumberEditText;
    private EditText emptyMassEditText;
    private EditText fuelEditText;
    private EditText engine_typeEditText;
    private EditText Driver_airbagEditText;
    private EditText Emergency_brake_assistEditText;
    private EditText Total_max_powerEditText;
    private Button addCarModelButton1;
    private Spinner spinnerGear;
    private Spinner spinnerTurbo;
    private Spinner spinnerMirror;
    private Spinner spinnerRadio;
    private Spinner spinnerPanorama;
    private Spinner spinnerAirBags;
    private Spinner spinnerBrake;

    /**
     * The function onClick handle the click event
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v == addCarModelButton1) {
            addCarModel();


        }
    }
    /**
     * The function addCarModel takes the information that the user insert into the textViews and add it to the models table in
     * the database
     */
    private void addCarModel() {
        final ContentValues contentValues = new ContentValues();
        try {

            contentValues.put(CarConst.CarModelConst.MODEL_CODE, this.modelCodeEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.COMPANY, this.companyEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.MODEL_NAME, this.modelNameEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.ENGINE_CAPACITY, this.EngineCapacityEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.GEAR, this.spinnerGear.getSelectedItem().toString());
            int capacity = Integer.valueOf(this.SeatingCapacityEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.SEATING_CAPICITY, capacity);
            int doors = Integer.valueOf(this.DoorsNumberEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.DOORS_NUMBER, doors);
            contentValues.put(CarConst.CarModelConst.EMPTY_MASS, this.emptyMassEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.FUEL, this.fuelEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.ENGINE_TYPE, this.engine_typeEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.TURBO, this.spinnerTurbo.getSelectedItem().toString());
            contentValues.put(CarConst.CarModelConst.LIGHTED_MAKEUP_MIRROR, this.spinnerMirror.getSelectedItem().toString());
            contentValues.put(CarConst.CarModelConst.DIGITAL_RADIO, this.spinnerRadio.getSelectedItem().toString());
            contentValues.put(CarConst.CarModelConst.PANORAMA, this.spinnerPanorama.getSelectedItem().toString());
            contentValues.put(CarConst.CarModelConst.DRIVER_AIRBAG, this.spinnerAirBags.getSelectedItem().toString());
            contentValues.put(CarConst.CarModelConst.EMERGENCY_BRAKE_ASSIST, this.spinnerBrake.getSelectedItem().toString());
            contentValues.put(CarConst.CarModelConst.TOTAL_MAX_POWER, this.Total_max_powerEditText.getText().toString());

            new AsyncTask<Void, Void, String>() {
                @Override     protected void onPostExecute(String code) {
                    super.onPostExecute(code);
                        Toast.makeText(getBaseContext(), "inserted model code: " + code, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddCarModelActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
                @Override
                protected String doInBackground(Void... params) {

                    return factory_dal.get_dal().addCarModel(contentValues);



                }



            }.execute();


        } catch (Exception e) {
        }
    }


    private void findViews() {
        modelCodeEditText = (EditText) findViewById(R.id.modelCodeEditText);
        companyEditText = (EditText) findViewById(R.id.companyEditText);
        modelNameEditText = (EditText) findViewById(R.id.modelNameEditText);
        EngineCapacityEditText = (EditText) findViewById(R.id.EngineCapacityEditText);
        spinnerGear = (Spinner) findViewById(R.id.spinnerGear);
        setSpeanerGear();
        SeatingCapacityEditText = (EditText) findViewById(R.id.SeatingCapacityEditText);
        DoorsNumberEditText = (EditText) findViewById(R.id.DoorsNumberEditText);
        emptyMassEditText = (EditText) findViewById(R.id.emptyMassEditText);
        fuelEditText = (EditText) findViewById(R.id.fuelEditText);
        engine_typeEditText = (EditText) findViewById(R.id.engine_typeEditText);
        spinnerTurbo = (Spinner) findViewById(R.id.spinnerTurbo);
        setSpeaner(spinnerTurbo);
        spinnerMirror = (Spinner) findViewById(R.id.spinnerMirror);
        setSpeaner(spinnerMirror);
        spinnerRadio = (Spinner) findViewById(R.id.spinnerRadio);
        setSpeaner(spinnerRadio);
        spinnerPanorama = (Spinner) findViewById(R.id.spinnerPanorama);
        setSpeaner(spinnerPanorama);
        spinnerAirBags = (Spinner) findViewById(R.id.spinnerAirBags);
        setSpeaner(spinnerAirBags);
        spinnerBrake = (Spinner) findViewById(R.id.spinnerBrake);
        setSpeaner(spinnerBrake);
        Total_max_powerEditText = (EditText) findViewById(R.id.Total_max_powerEditText);


        addCarModelButton1 = (Button) findViewById(R.id.addCarModelButton1);
        addCarModelButton1.setOnClickListener(this);
    }


    private void setSpeanerGear() {
        spinnerGear.setAdapter(new ArrayAdapter<Enums.Gear>(this, android.R.layout.simple_list_item_1, Enums.Gear.values()));
        spinnerGear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

    }


    private void setSpeaner(Spinner selected) {
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





































