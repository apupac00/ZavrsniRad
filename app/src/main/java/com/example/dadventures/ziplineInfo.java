package com.example.dadventures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ziplineInfo extends AppCompatActivity {
    private ImageView mybtnWeb, mybtnGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zipline_info);

        mybtnWeb = (ImageView) findViewById(R.id.btnWeb);
        mybtnGallery = (ImageView) findViewById(R.id.btnGallery);

        mybtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ziplineInfo.this, webview2.class);
                startActivity(intent);
            }
        });

        mybtnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ziplineInfo.this, gallery.class);
                startActivity(intent);
            }
        });

    }
}
