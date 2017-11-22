package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.factory_dal;

public class AddClientActivity extends Activity implements View.OnClickListener{

private EditText lastNameEditText;
private EditText firstNameEditText;
private EditText phoneNumberEditText;
private EditText IDEditText;
private EditText mailEditText;
private EditText cardNumberEditText;
private Button addClientButton;


    @Override
    public void onClick(View v) {
        if ( v == addClientButton )
        {              addClient();
        }
    }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        findViews();
        }

    private void addClient() {
        final ContentValues contentValues = new ContentValues();
        try {
            int id = Integer.valueOf(this.IDEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.ID, id);
            contentValues.put(CarConst.ClientConst.LAST_NAME, this.lastNameEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.FIRST_NAME, this. firstNameEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.PHONE_NUMBER, this. phoneNumberEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.MAIL, this. mailEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.CARD_NUMBER, this.cardNumberEditText.getText().toString());

            factory_dal.get_dal().addClient(contentValues);       }
        catch (Exception e) {}
        }

    private void findViews() {
        lastNameEditText = (EditText)findViewById( R.id.lastNameEditText );
        firstNameEditText = (EditText)findViewById( R.id.firstNameEditText );
        phoneNumberEditText = (EditText)findViewById( R.id.phoneNumberEditText );
        IDEditText = (EditText)findViewById( R.id.IDEditText);
        mailEditText = (EditText)findViewById( R.id.mailEditText);
        cardNumberEditText= (EditText)findViewById( R.id.cardNumberEditText);
        addClientButton = (Button)findViewById( R.id.addClientButton );
        addClientButton.setOnClickListener( this );     }




}
