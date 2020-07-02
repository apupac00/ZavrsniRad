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

public class rafting extends AppCompatActivity {

    ListView listView;
    String[] rafting_names = {"Slap", "Pirate", "Buk", "Vir", "Lestrigon"};
    String[] rafting_prices = {"28€","20€","28€", "30€", "10€"};
    String[] rafting_ratings = {"4.8","4.7","4.5","4.8","3.8"};
    int [] rafting_logos = {R.drawable.slap1,R.drawable.pirate,R.drawable.buk,R.drawable.vir,R.drawable.lestrigon};

    private static String TAG = "rafting";
    private Button btnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rafting);

        Log.d(TAG, "onCreate: error");
        listView = (ListView) findViewById(R.id.listViewRafting);
        btnMoreInfo = (Button) findViewById(R.id.btnSend);

        RaftingCustomAdapter raftingCustomAdapter = new RaftingCustomAdapter();
        listView.setAdapter(raftingCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(rafting.this, booking.class);
                intent.putExtra("name",rafting_names[position]);
                startActivity(intent);
            }
        });
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rafting.this, raftingInfo.class);
                startActivity(intent);
            }
        });


    }

    private class RaftingCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return rafting_logos.length;
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
            View view2 = getLayoutInflater().inflate(R.layout.list_of_rafting_adventures, null);

            TextView rafting_name = view2.findViewById(R.id.rafting_name);
            TextView rafting_price = view2.findViewById(R.id.price);
            TextView rafting_rating = view2.findViewById(R.id.rating);
            ImageView rafting_logo = view2.findViewById(R.id.rafting_logo);

            rafting_name.setText(rafting_names[position]);
            rafting_price.setText(rafting_prices[position]);
            rafting_rating.setText(rafting_ratings[position]);
            rafting_logo.setImageResource(rafting_logos[position]);

            return view2;
        }

    }
}



