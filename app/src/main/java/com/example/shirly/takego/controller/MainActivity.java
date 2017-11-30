package com.example.shirly.takego.controller;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.shirly.takego.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {

    private Button button;
    private ImageView imageView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button=(Button)findViewById( R.id.button);
        imageView= (ImageView) findViewById( R.id.imageView );
        }
}



