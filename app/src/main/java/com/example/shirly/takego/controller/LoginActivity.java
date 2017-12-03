package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shirly.takego.R;

public class LoginActivity extends Activity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername=(EditText)findViewById(R.id.etUsername) ;
        etPassword=(EditText)findViewById(R.id.etPassword) ;
        tvRegisterLink=(TextView) findViewById(R.id.tvRegisterLink);
        bLogin=(Button)findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                String strUserName = etUsername.getText().toString();
                String strPassword = etPassword.getText().toString();
                if (strUserName.trim().equals("")||strPassword.trim().equals("") ) {
                    Toast.makeText(this, "enter username and password ", Toast.LENGTH_SHORT).show();

                }
                else {
                    startActivity(new Intent(this, MenuActivity.class));
                }
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,RegisterActivity.class));
                break;

        }

    }
}
