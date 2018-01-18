package com.example.app2.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.R;
import com.example.app2.controller.model.backend.CarConst;
import com.example.app2.controller.model.backend.factory_dal;

public class RegisterActivity extends Activity implements View.OnClickListener {
    Button bRegister;
    EditText etUsername1, etPassword1;
    TextView tvLoginLink;

    private EditText lastNameEditText;
    private EditText firstNameEditText;
    private EditText phoneNumberEditText;
    private EditText IDEditText;
    private EditText mailEditText;
    private EditText cardNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //etName=(EditText)findViewById(R.id.name);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        IDEditText = (EditText) findViewById(R.id.IDEditText);
        mailEditText = (EditText) findViewById(R.id.mailEditText);
        cardNumberEditText = (EditText) findViewById(R.id.cardNumberEditText);

        etUsername1 = (EditText) findViewById(R.id.username_reg);
        etPassword1 = (EditText) findViewById(R.id.password_reg);
        bRegister = (Button) findViewById(R.id.btn_signup);
        tvLoginLink = (TextView) findViewById(R.id.link_login);
        bRegister.setOnClickListener(this);
        tvLoginLink.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == bRegister) {
            Toast.makeText(getBaseContext(), "registering...", Toast.LENGTH_LONG).show();
            Register();

        } else if (v == tvLoginLink) {
            startActivity(new Intent(this, LoginActivity.class));

        }

    }

    private void Register() {
        final ContentValues contentValues = new ContentValues();
        final ContentValues cv = new ContentValues();
        try {
            contentValues.put(CarConst.LoginConst.USERNAME, this.etUsername1.getText().toString());
            contentValues.put(CarConst.LoginConst.PASSWORD, this.etPassword1.getText().toString());
            int id = Integer.valueOf(this.IDEditText.getText().toString());
            contentValues.put(CarConst.LoginConst.CLIENTNUMBER, id);


            int id1 = Integer.valueOf(this.IDEditText.getText().toString());
            cv.put(CarConst.ClientConst.ID, id1);
            cv.put(CarConst.ClientConst.LAST_NAME, this.lastNameEditText.getText().toString());
            cv.put(CarConst.ClientConst.FIRST_NAME, this.firstNameEditText.getText().toString());
            cv.put(CarConst.ClientConst.PHONE_NUMBER, this.phoneNumberEditText.getText().toString());
            cv.put(CarConst.ClientConst.MAIL, this.mailEditText.getText().toString());
            cv.put(CarConst.ClientConst.CARD_NUMBER, this.cardNumberEditText.getText().toString());


            new AsyncTask<Void, Void, String>() {
                @Override
                protected void onPostExecute(String user) {
                    super.onPostExecute(user);
                    saveSharedPreferences();
                    Toast.makeText(getBaseContext(), "your userName is: " + user, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, Main2Activity.class);
                    startActivity(intent);


                }

                @Override
                protected String doInBackground(Void... params) {

                    factory_dal.get_dal().addClient(cv);

                    return factory_dal.get_dal().addUser(contentValues);


                }


            }.execute();


        } catch (Exception e) {
        }
    }

    private void saveSharedPreferences() {
        try {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String Username = etUsername1.getText().toString();
            String password = etPassword1.getText().toString();
            String key = Username;
            String value = Username+"_Password";
            editor.putString(key, Username);
            editor.commit();
            editor.putString(value, password);
            editor.commit();
            Toast.makeText(this, "save username and password Preferences", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "failed to save Preferences", Toast.LENGTH_SHORT).show();
        }
    }


}
