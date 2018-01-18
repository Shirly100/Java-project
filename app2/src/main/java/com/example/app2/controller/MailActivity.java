package com.example.app2.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.textservice.SentenceSuggestionsInfo;
import android.widget.Button;
import android.widget.EditText;

import com.example.app2.R;

public class MailActivity extends Activity {
    EditText et_email,et_subject,et_message;
    Button b_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);
        et_email=(EditText)findViewById(R.id.et_mail);
        et_subject=(EditText)findViewById(R.id.et_subjecy);
        et_message=(EditText)findViewById(R.id.et_message);
        b_send=(Button)findViewById(R.id.b_send);
        et_email.setText("Take&Go@gmail.com");
        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=et_email.getText().toString();
                String subject=et_subject.getText().toString();
                String message=et_message.getText().toString();

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent," Select Email app"));


            }
        });
    }
}
