package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.factory_dal;
import com.example.shirly.takego.model.entities.Client;

import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToClient;

public class AddClientActivity extends Activity implements View.OnClickListener {

    private EditText lastNameEditText;
    private EditText firstNameEditText;
    private EditText phoneNumberEditText;
    private EditText IDEditText;
    private EditText mailEditText;
    private EditText cardNumberEditText;
    private Button addClientButton1;


    @Override
    public void onClick(View v) {
        if (v == addClientButton1) {
            addClient();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        findViews();
    }

    private void findViews() {
        lastNameEditText = (EditText)findViewById( R.id.lastNameEditText );
        firstNameEditText = (EditText)findViewById( R.id.firstNameEditText );
        phoneNumberEditText = (EditText)findViewById( R.id.phoneNumberEditText );
        IDEditText = (EditText)findViewById( R.id.IDEditText);
        mailEditText = (EditText)findViewById( R.id.mailEditText);
        cardNumberEditText= (EditText)findViewById( R.id.cardNumberEditText);
        addClientButton1 = (Button)findViewById( R.id.addClientButton1 );
        addClientButton1.setOnClickListener( this );     }

    private void addClient() {
        final ContentValues contentValues = new ContentValues();
        try {
            int id = Integer.valueOf(this.IDEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.ID, id);
            contentValues.put(CarConst.ClientConst.LAST_NAME, this.lastNameEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.FIRST_NAME, this.firstNameEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.PHONE_NUMBER, this.phoneNumberEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.MAIL, this.mailEditText.getText().toString());
            contentValues.put(CarConst.ClientConst.CARD_NUMBER, this.cardNumberEditText.getText().toString());


            int flag = 0;

           /*if (factory_dal.get_dal().isExistClient(contentValues)) {
                Toast.makeText(getBaseContext(), "Client Already Exist", Toast.LENGTH_LONG).show();
                lastNameEditText.setText("");
                firstNameEditText.setText("");
                phoneNumberEditText.setText("");
                IDEditText.setText("");
                mailEditText.setText("");
                cardNumberEditText.setText("");

                flag = 1;

            } */  //to add!!

            if (flag == 0) {
                //factory_dal.get_dal().addClient(contentValues);
                //Intent intent=new Intent(this,MenuActivity.class);
                //startActivity(intent);
                new AsyncTask<Void, Void, Long>() {
                    @Override
                    protected void onPostExecute(Long idResult) {
                        super.onPostExecute(idResult);
                        if (idResult > 0) {
                            Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(AddClientActivity.this, MenuActivity.class);
                            startActivity(intent);
                        }
                        if(idResult ==0)
                        {
                            Toast.makeText(getBaseContext(), "Client Already Exist", Toast.LENGTH_LONG).show();
                            lastNameEditText.setText("");
                            firstNameEditText.setText("");
                            phoneNumberEditText.setText("");
                            IDEditText.setText("");
                            mailEditText.setText("");
                            cardNumberEditText.setText("");
                        }
                    }

                    @Override
                    protected Long doInBackground(Void... params) {
                        if (factory_dal.get_dal().isExistClient(contentValues)) {
                          long id=0;
                            return id;

                        }

                        else {

                            return factory_dal.get_dal().addClient(contentValues);
                        }



                    }


                }.execute();


            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Error ", Toast.LENGTH_LONG).show();//i added recently
        }


    }








}
