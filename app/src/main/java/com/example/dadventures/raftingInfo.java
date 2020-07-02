package com.example.dadventures;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class raftingInfo extends AppCompatActivity {
    private ImageView mybtnWeb, mybtnGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rafting_info);

        mybtnWeb = (ImageView) findViewById(R.id.btnWeb);
        mybtnGallery = (ImageView) findViewById(R.id.btnGallery);

        mybtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(raftingInfo.this, webview1.class);
                startActivity(intent);
            }
        });

        mybtnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(raftingInfo.this, gallery.class);
                startActivity(intent);
            }
        });

    }

}
