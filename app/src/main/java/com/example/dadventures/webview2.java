package com.example.dadventures;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class webview2 extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_web_view2);
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://en.wikipedia.org/wiki/Zip_line");

    }
}
