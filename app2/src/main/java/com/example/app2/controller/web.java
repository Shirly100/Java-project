package com.example.app2.controller;

/**
 * Created by Shirly on 1/14/2018.
 */



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.app2.R;

public class web extends Activity {
    private WebView webView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent myIntent = getIntent();
        String location = myIntent.getStringExtra("link_location");
        webView.loadUrl("https://www.google.com/maps/search/?api=1&query="+location);
                  //String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
                // webView.loadData(customHtml,"text/html","UTF-8");
    }
 }

