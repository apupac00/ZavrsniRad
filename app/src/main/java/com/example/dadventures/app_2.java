package com.example.dadventures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class app_2 extends AppCompatActivity {

    ListView listView;
    String[] adventure_names = {"Rafting", "Zipline", "Canyoning"};
    int[] adventure_logos = {R.drawable.rafting, R.drawable.zipline, R.drawable.canyoning};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_2);


        listView = (ListView) findViewById(R.id.listView);

        CostumAdapter costumAdapter = new CostumAdapter();
        listView.setAdapter(costumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), rafting.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), zipline.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), canyoning.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

    }

    private class CostumAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return adventure_logos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.list_of_adventures, null);

            TextView adventure_name = view1.findViewById(R.id.adventure_name);
            ImageView adventure_logo = view1.findViewById(R.id.adventure_logo);

            adventure_name.setText(adventure_names[position]);
            adventure_logo.setImageResource(adventure_logos[position]);

            return view1;

        }
    }
}
