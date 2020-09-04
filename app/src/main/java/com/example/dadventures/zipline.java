package com.example.dadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class zipline extends AppCompatActivity {

    ListView listView;
    String[] zipline_names = {"Zipline Omis", "Zipline Kozjak"};
    String[] zipline_prices = {"50€","50€"};
    String[] zipline_ratings = {"4.8","4.7"};
    int [] zipline_logos = {R.drawable.zipline_omis,R.drawable.zipline_kozjak};


    private Button btnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zipline);

        listView = (ListView) findViewById(R.id.listViewZipline);
        btnMoreInfo = (Button) findViewById(R.id.btnSendZip);

        ZiplineCustomAdapter ziplineCustomAdapter = new ZiplineCustomAdapter();
        listView.setAdapter(ziplineCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(zipline.this, booking.class);
                intent.putExtra("name",zipline_names[position]);
                startActivity(intent);
            }
        });
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(zipline.this, ziplineInfo.class);
                startActivity(intent);
            }
        });
    }

    private class ZiplineCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return zipline_logos.length;
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
            View view4 = getLayoutInflater().inflate(R.layout.list_of_rafting_adventures, null);

            TextView zipline_name = view4.findViewById(R.id.rafting_name);
            TextView zipline_price = view4.findViewById(R.id.price);
            TextView zipline_rating = view4.findViewById(R.id.rating);
            ImageView zipline_logo = view4.findViewById(R.id.rafting_logo);

            zipline_name.setText(zipline_names[position]);
            zipline_price.setText(zipline_prices[position]);
            zipline_rating.setText(zipline_ratings[position]);
            zipline_logo.setImageResource(zipline_logos[position]);

            return view4;
        }

    }
}
