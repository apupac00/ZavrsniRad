package com.example.dadventures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class canyoningInfo extends AppCompatActivity {
    private ImageView mybtnWeb, mybtnGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canyoning_info);

        mybtnWeb = (ImageView) findViewById(R.id.btnWeb);
        mybtnGallery = (ImageView) findViewById(R.id.btnGallery);

        mybtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(canyoningInfo.this, webview1.class);
                startActivity(intent);
            }
        });

        mybtnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(canyoningInfo.this, gallery.class);
                startActivity(intent);
            }
        });

    }
}
