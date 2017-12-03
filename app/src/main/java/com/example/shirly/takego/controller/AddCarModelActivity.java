package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
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
    private EditText turboEditText;
    private EditText Lighted_makeup_mirrorEditText;
    private EditText Digital_radioEditText;
    private EditText PanoramaEditText;
    private EditText Driver_airbagEditText;
    private EditText Emergency_brake_assistEditText;
    private EditText Total_max_powerEditText;
    private Button addCarModelButton1;
    private Spinner spinner1;


    @Override
    public void onClick(View v) {
        if (v == addCarModelButton1) {
            addCarModel();
            //addItemsOnSpinner1();


        }
    }

    private void addCarModel() {
        final ContentValues contentValues = new ContentValues();
        try {

            contentValues.put(CarConst.CarModelConst.MODEL_CODE, this.modelCodeEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.COMPANY, this.companyEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.MODEL_NAME, this.modelNameEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.ENGINE_CAPACITY, this.EngineCapacityEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.GEAR, this.spinner1.getSelectedItem().toString());
            int capacity = Integer.valueOf(this.SeatingCapacityEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.SEATING_CAPICITY, capacity);
            int doors = Integer.valueOf(this.DoorsNumberEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.DOORS_NUMBER, doors);
            contentValues.put(CarConst.CarModelConst.EMPTY_MASS, this.emptyMassEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.FUEL, this.fuelEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.ENGINE_TYPE, this.engine_typeEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.TURBO,this.turboEditText.getText().toString() );
            contentValues.put(CarConst.CarModelConst.LIGHTED_MAKEUP_MIRROR, this.Lighted_makeup_mirrorEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.DIGITAL_RADIO, this.Digital_radioEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.PANORAMA, this.PanoramaEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.DRIVER_AIRBAG, this.Driver_airbagEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.EMERGENCY_BRAKE_ASSIST, this.Emergency_brake_assistEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.TOTAL_MAX_POWER,this.Total_max_powerEditText.getText().toString());
            contentValues.put(CarConst.CarModelConst.EMPTY_MASS, this.Total_max_powerEditText.getText().toString());

            factory_dal.get_dal().addCarModel(contentValues);
            Intent intent=new Intent(this,MenuActivity.class);
            startActivity(intent);
        } catch (Exception e) {
        }
    }




    private void findViews() {
        modelCodeEditText = (EditText)findViewById( R.id.modelCodeEditText );
        companyEditText = (EditText)findViewById( R.id. companyEditText );
        modelNameEditText = (EditText)findViewById( R.id.modelNameEditText );
        EngineCapacityEditText = (EditText)findViewById( R.id.EngineCapacityEditText);
        //gearEditText = (EditText)findViewById( R.id.gearEditText);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(new ArrayAdapter<Enums.Gear>(this, android.R.layout.simple_list_item_1, Enums.Gear.values()));
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        SeatingCapacityEditText = (EditText)findViewById( R.id.SeatingCapacityEditText);
        DoorsNumberEditText= (EditText)findViewById( R.id.DoorsNumberEditText);
        emptyMassEditText = (EditText)findViewById( R.id. emptyMassEditText);
        fuelEditText = (EditText)findViewById( R.id.fuelEditText);
        engine_typeEditText = (EditText)findViewById( R.id.engine_typeEditText);
        turboEditText = (EditText)findViewById( R.id.turboEditText);
        Lighted_makeup_mirrorEditText = (EditText)findViewById( R.id.Lighted_makeup_mirrorEditText);

        Digital_radioEditText = (EditText)findViewById( R.id.Digital_radioEditText);
        PanoramaEditText = (EditText)findViewById( R.id.PanoramaEditText);
        Driver_airbagEditText = (EditText)findViewById( R.id.Driver_airbagEditText);
        Emergency_brake_assistEditText = (EditText)findViewById( R.id.Emergency_brake_assistEditText);
        Total_max_powerEditText = (EditText)findViewById( R.id.Total_max_powerEditText);


        addCarModelButton1 = (Button)findViewById(R.id.addCarModelButton1 );
        addCarModelButton1.setOnClickListener( this );     }













}






























