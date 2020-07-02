package com.example.dadventures;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class booking extends AppCompatActivity {

    EditText txName, txEmail, txTime, txDate, txPeople, txPhone;
    TextView txAName;
    Button btnSend;
    DatabaseReference reff;
    Costumer costumer;
    Integer counter = 0;
    String nameToSend;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);
        txAName = (TextView) findViewById(R.id.txAName);
        Bundle bn = getIntent().getExtras();

        final String name = bn.getString("name");
        txAName.setText(String.valueOf(name));
        nameToSend = name;

        txName = (EditText)findViewById(R.id.editTextName);
        txEmail = (EditText)findViewById(R.id.editTextEmail);
        txTime = (EditText)findViewById(R.id.editTextTime);
        txDate = (EditText)findViewById(R.id.editTextDate);
        txPeople = (EditText)findViewById(R.id.editTextPeople);
        txPhone = (EditText)findViewById(R.id.editTextPhone);
        btnSend = (Button)findViewById(R.id.btnSend);
        costumer = new Costumer();
        reff = FirebaseDatabase.getInstance().getReference().child("Costumer");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float time = Float.parseFloat(txTime.getText().toString().trim());
                int people = Integer.parseInt(txPeople.getText().toString().trim());

                costumer.setName(txName.getText().toString().trim());
                costumer.setEmail(txEmail.getText().toString().trim());
                costumer.setTime(time);
                costumer.setDate(txDate.getText().toString().trim());
                costumer.setPeople(people);
                costumer.setPhone(txPhone.getText().toString().trim());

                reff.push().child(nameToSend).setValue(costumer);
                counter++;
                Toast.makeText(booking.this,"Message sent successfully",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
