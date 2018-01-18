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
import com.example.app2.controller.model.backend.factory_dal;
import com.example.app2.controller.model.entities.Login;


import java.util.List;

public class LoginActivity extends Activity implements View.OnClickListener{
    public static int clientNumber;

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //starts service


        setContentView(R.layout.activity_login);
        etUsername=(EditText)findViewById(R.id.userName) ;
        etPassword=(EditText)findViewById(R.id.password) ;
        tvRegisterLink=(TextView) findViewById(R.id.link_signup);
        bLogin=(Button)findViewById(R.id.btn_login);
        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString()!="")
                {
                    loadSharedPreferences(etUsername.getText().toString());
                }

            }
        });



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
                    Boolean answer =existInSharedPreferences();
                     clientNumber=0;
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getPassword().equals(LoginActivity.this.etPassword.getText().toString()) && users.get(i).getUser().equals(LoginActivity.this.etUsername.getText().toString())) {
                            flag = 1;
                            clientNumber=users.get(i).getClientNumber();
                            break;


                        }
                    }
                    if(flag==0) {
                        Toast.makeText(getBaseContext(), "Wrong user or password", Toast.LENGTH_LONG).show();
                        LoginActivity.this.etPassword.setText("");
                        LoginActivity.this.etUsername.setText("");
                    }
                    else
                    {
                        if(answer==false)
                        {
                            Toast.makeText(getBaseContext(), "not in sharedPreferences", Toast.LENGTH_LONG).show();
                            saveSharedPreferences();

                        }
                        else {

                            Toast.makeText(getBaseContext(), "successfully logged in", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                            startActivity(intent);




                        }
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
    private Boolean existInSharedPreferences()
    {
        String Username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String key=Username;
        String value = Username+"_Password";;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (sharedPreferences.contains(key)&&sharedPreferences.contains(value))
        {
            return true;

        }
        return  false;

    }
    private void saveSharedPreferences() {
        try {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String Username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            String key=Username;
            String value = Username+"_Password";
            editor.putString(key, Username);
            editor.commit();
            editor.putString(value, password);
            editor.commit();
            Toast.makeText(this, "save username and password Preferences", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "failed to save Preferences", Toast.LENGTH_SHORT).show();
        } }


    private void loadSharedPreferences(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.contains(key+"_Password")) {
            etPassword.setText(sharedPreferences.getString(key+"_Password", null));
            Toast.makeText(this, "load password", Toast.LENGTH_SHORT).show();
        }


    }



}
