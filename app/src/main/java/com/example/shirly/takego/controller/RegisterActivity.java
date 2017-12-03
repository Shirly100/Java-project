package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shirly.takego.R;

public class RegisterActivity extends Activity implements View.OnClickListener{
    Button bRegister;
    EditText etName,etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName=(EditText)findViewById(R.id.etName);
        etUsername=(EditText)findViewById(R.id.etUsername) ;
        etPassword=(EditText)findViewById(R.id.etPassword) ;
        bRegister=(Button)findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:
                String strUserName = etUsername.getText().toString();
                String strPassword = etPassword.getText().toString();
                String strName = etPassword.getText().toString();
                if (strUserName.trim().equals("")||strPassword.trim().equals("")||strName.trim().equals("") ) {
                    Toast.makeText(this, "enter your details ", Toast.LENGTH_SHORT).show();

                }
                else {
                    startActivity(new Intent(this, MenuActivity.class));
                    break;
                }


        }
    }
}
