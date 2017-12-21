package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.factory_dal;

public class AddBranchActivity extends Activity implements View.OnClickListener{

    private EditText cityEditText;
    private EditText streetEditText;
    private EditText numberEditText;
    private EditText branchNumberEditText;
    private EditText parkingEditText;
    private Button addBranchButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if ( v == addBranchButton1)
        {
            addBranch();
        }
    }


    private void addBranch() {
        final ContentValues contentValues = new ContentValues();
        try {
            int parking_spaces = Integer.valueOf(this.parkingEditText.getText().toString());
            contentValues.put(CarConst.BranchConst.PARKING, parking_spaces);
            int branch_number = Integer.valueOf(this.branchNumberEditText.getText().toString());
            contentValues.put(CarConst.BranchConst.BRANCH_NAME, branch_number);
            contentValues.put(CarConst.BranchConst.CITY, this.cityEditText.getText().toString());
            contentValues.put(CarConst.BranchConst.STREET, this. streetEditText.getText().toString());
            int number = Integer.valueOf(this.numberEditText.getText().toString());
            contentValues.put(CarConst.BranchConst.NUMBER, number);



            new AsyncTask<Void, Void, Integer>() {
                @Override
                protected void onPostExecute(Integer branchNumber) {
                    super.onPostExecute(branchNumber);
                    if (branchNumber > 0)
                        Toast.makeText(getBaseContext(), "inserted branch number : " + branchNumber, Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(AddBranchActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
                @Override
                protected Integer doInBackground(Void... params) {

                    return factory_dal.get_dal().addBranch(contentValues);




                }



            }.execute();


        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


    private void findViews() {
        parkingEditText = (EditText)findViewById( R.id.parkingEditText );
        cityEditText = (EditText)findViewById( R.id.CityEditText );
        streetEditText = (EditText)findViewById( R.id.streetEditText );
        numberEditText = (EditText)findViewById( R.id.numberEditText);
        branchNumberEditText = (EditText)findViewById( R.id.branchNumberEditText);
        addBranchButton1 = (Button)findViewById( R.id.addBranchButton1 );
        addBranchButton1.setOnClickListener( this );     }

}
