package com.example.dadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class canyoning extends AppCompatActivity {

    ListView listView;
    String[] canyoning_names = {"Slap","Split Adventure", "Adventure Omis","Raftrek", "Red Adventures"};
    String[] canyoning_prices = {"50€","50€", "50€","50€", "50€"};
    String[] canyoning_ratings = {"5","5", "5","5", "5"};
    int[] canyoning_logos={R.drawable.slap1,R.drawable.split_adventure,R.drawable.adventure_omis,R.drawable.raftrek,R.drawable.red_adventures};

    private Button btnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canyoning);

        listView = (ListView) findViewById(R.id.listViewCanyoning);
        btnMoreInfo = (Button) findViewById(R.id.btnSendCan);
        CanyoningCostumAdapter canyoningCostumAdapter = new CanyoningCostumAdapter();
        listView.setAdapter(canyoningCostumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(canyoning.this, booking.class);
                intent.putExtra("name",canyoning_names[position]);
                startActivity(intent);
            }
        });
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(canyoning.this, canyoningInfo.class);
                startActivity(intent);
            }
        });
    }

    private class CanyoningCostumAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return canyoning_logos.length;
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

            View view3 = getLayoutInflater().inflate(R.layout.list_of_rafting_adventures, null);
            TextView canyoning_name = view3.findViewById(R.id.rafting_name);
            TextView canyoning_price = view3.findViewById(R.id.price);
            TextView canyoning_rating = view3.findViewById(R.id.rating);
            ImageView canyoning_logo = view3.findViewById(R.id.rafting_logo);

            canyoning_name.setText(canyoning_names[position]);
            canyoning_price.setText(canyoning_prices[position]);
            canyoning_rating.setText(canyoning_ratings[position]);
            canyoning_logo.setImageResource(canyoning_logos[position]);

            return view3;
        }
    }

}

