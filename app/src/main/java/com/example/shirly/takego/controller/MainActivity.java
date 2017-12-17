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

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button;
    private ImageView imageView;
    TextView tvStart;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStart=(TextView) findViewById(R.id.tvStart);
        imageView= (ImageView) findViewById( R.id.imageView );
        tvStart.setOnClickListener(this);
        }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tvStart:
                startActivity(new Intent(this,LoginActivity.class));
                break;


        }

    }
}



