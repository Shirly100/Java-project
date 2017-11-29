package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.factory_dal;
import com.example.shirly.takego.model.entities.Car;

import static com.example.shirly.takego.R.id.addCarButton1;

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
    private Button addCarButton1;



    @Override
    public void onClick(View v) {
        if ( v == addCarButton1 )
        {
            addCar();
        }
    }




    private void addCar() {
        final ContentValues contentValues = new ContentValues();
        try {
            int branchNumber = Integer.valueOf(this.branchNumberEditText.getText().toString());
            contentValues.put(CarConst.CarsConst.BRANCH_NUMBER, branchNumber);
            contentValues.put(CarConst.CarsConst.MODEL_TYPE, this.modelTypeEditText.getText().toString());
            float mileage = Integer.valueOf(this.mileageEditText.getText().toString());
            contentValues.put(CarConst.CarsConst.MILEAGE, mileage);
            long car_number = Integer.valueOf(this.carNumberEditText.getText().toString());
            contentValues.put(CarConst.CarsConst.CAR_NUMBER,car_number);

            factory_dal.get_dal().addCar(contentValues);       }
        catch (Exception e) {}
    }









    private void findViews() {
        branchNumberEditText = (EditText)findViewById( R.id.branchNumberEditText );
        modelTypeEditText = (EditText)findViewById( R.id. modelTypeEditText );
        mileageEditText = (EditText)findViewById( R.id.mileageEditText );
        carNumberEditText = (EditText)findViewById( R.id.carNumberEditText);
        addCarButton1 = (Button)findViewById(R.id.addCarButton1 );
        addCarButton1.setOnClickListener( this );     }




}


