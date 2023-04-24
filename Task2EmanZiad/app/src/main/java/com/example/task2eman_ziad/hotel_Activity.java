package com.example.task2eman_ziad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import java.util.ArrayList;

public class hotel_Activity extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity);
//        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));

        Intent i = getIntent();
        String name = i.getStringExtra("city");
        getSupportActionBar().setTitle(name);
        System.out.println(name);

        ListView list2 = findViewById(R.id.list2);
        ArrayList<hotel> items = new ArrayList<hotel>();


        if (name.equals("Aswan")){
            items.add(new hotel(R.drawable.philaehotel,
                    "Philae Hotel AswanOpens in new window","rate: 7.7 Good"));
            items.add(new hotel(R.drawable.kanakato,
                    "Kana Kato ","rate: 9.4 Wonderful"));
            items.add(new hotel(R.drawable.basmahotel,"Basma Hotel Aswan","rate: 7.7 Good"));
            items.add(new hotel(R.drawable.movenpickhotel,"Movenpick Resort & Spa","rate: 9.5 Wonderful"));
            items.add(new hotel(R.drawable.citymax,"Citymax Hotel Aswan","rate: 7.9 Good"));

        }else if (name.equals("Luxor")){
            items.add(new hotel(R.drawable.sonestahotel,"Sonesta St. George Hotel","rate: 9.1 Wonderful"));
            items.add(new hotel(R.drawable.steigenbeirgluxor,"Steigenberger Resort Achti","rate: 9.0 Wonderful"));
            items.add(new hotel(R.drawable.luxorhotel,"Steigenberger Nile Palace","rate: 9.1 Wonderful"));
        }else{
            items.add(new hotel(R.drawable.kempinskicairo,"Kempinski Nile Hotel Cairo","rate: 9.1 Wonderful"));
            items.add(new hotel(R.drawable.steigenbergcairo,"Steigenberger Hotel El Tahrir","rate: 9.0 Wonderful"));
            items.add(new hotel(R.drawable.dusitthanihotelcairo,"Dusit Thani LakeView Cairo","rate: 8.4 Very Good"));

        }


        hotels_Adapter ada = new hotels_Adapter(this,
                R.layout.hotel_item,items);
        list2.setAdapter(ada);
        LayoutInflater inflater = this.getLayoutInflater();
        LinearLayout v = (LinearLayout)inflater.inflate(R.layout.hotel_item,null);

        Button location = (Button) v.findViewById(R.id.location);


//        location.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Click(getApplicationContext());
//            }
//        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



        }
