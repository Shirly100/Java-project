package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shirly.takego.R;
import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.factory_dal;
import com.example.shirly.takego.model.entities.Login;

import java.util.List;

import static com.example.shirly.takego.R.id.lastNameEditText;

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
        if (v == bLogin) {
            Login();


        }
        else
            if(v == tvRegisterLink)
            {
                startActivity(new Intent(this,RegisterActivity.class));

            }
    }

    private void Login() {
        final ContentValues contentValues = new ContentValues();
        try {



            new AsyncTask<Void, Void, List<Login>>() {
                @Override     protected void onPostExecute(List<Login> users) {
                    super.onPostExecute(users);
                    int flag=0;
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getPassword().equals(LoginActivity.this.etPassword.getText().toString()) && users.get(i).getUser().equals(LoginActivity.this.etUsername.getText().toString())) {
                            flag = 1;
                        }
                    }
                    if(flag==0) {
                        Toast.makeText(getBaseContext(), "Wrong user or password", Toast.LENGTH_LONG).show();
                        LoginActivity.this.etPassword.setText("");
                        LoginActivity.this.etUsername.setText("");
                    }
                    else
                    {

                        Toast.makeText(getBaseContext(), "successfully logged in", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }



                }

                @Override
                protected List<Login> doInBackground(Void... params) {

                    return factory_dal.get_dal().getUsers();




                }



            }.execute();


        } catch (Exception e) {
        }
    }

    /*@Override
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

    }*/
}
