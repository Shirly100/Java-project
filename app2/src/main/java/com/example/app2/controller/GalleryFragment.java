package com.example.app2.controller;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app2.R;

import static android.R.id.message;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements View.OnClickListener {

    private Button sendMail;
    private Button call;
    private TextView text;


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        text=(TextView) rootView.findViewById(R.id.link);
        text.setMovementMethod(LinkMovementMethod.getInstance());



        sendMail = (Button)rootView.findViewById( R.id.button2 );
        sendMail.setOnClickListener( this );

        call = (Button)rootView.findViewById( R.id.button );
        call.setOnClickListener( this );


        return rootView;
    }
    public void onClick(View v) {
        if ( v ==  sendMail)
        {
            sendUsMail();
        }
        if ( v ==  call)
        {
            callUs();
        }
    }
    private void sendUsMail()
    {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("plain/text");
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "some@email.address" });
//        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
//        intent.putExtra(Intent.EXTRA_TEXT, "mail body");
//        startActivity(Intent.createChooser(intent, ""));



        Intent emailIntent = new Intent(getActivity(),MailActivity.class);
        startActivity(emailIntent);






    }

    private void callUs()
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }




}