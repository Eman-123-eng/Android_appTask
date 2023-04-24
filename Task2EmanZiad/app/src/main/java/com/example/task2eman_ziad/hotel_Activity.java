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
                    "Philae Hotel AswanOpens in new window","Good",3.9));
            items.add(new hotel(R.drawable.kanakato,
                    "Kana Kato ","Wonderful", 4.7));
            items.add(new hotel(R.drawable.basmahotel,"Basma Hotel Aswan","Good", 3.8));
            items.add(new hotel(R.drawable.movenpickhotel,"Movenpick Resort & Spa","Wonderful", 4.8));
            items.add(new hotel(R.drawable.citymax,"Citymax Hotel Aswan","Good", 4.0));

        }else if (name.equals("Luxor")){
            items.add(new hotel(R.drawable.sonestahotel,"Sonesta St. George Hotel","Wonderful", 4.6));
            items.add(new hotel(R.drawable.steigenbeirgluxor,"Steigenberger Resort Achti","Wonderful", 4.5));
            items.add(new hotel(R.drawable.luxorhotel,"Steigenberger Nile Palace","Wonderful", 4.6));
        }else{
            items.add(new hotel(R.drawable.kempinskicairo,"Kempinski Nile Hotel Cairo","Wonderful", 4.6));
            items.add(new hotel(R.drawable.steigenbergcairo,"Steigenberger Hotel El Tahrir","Wonderful", 4.5));
            items.add(new hotel(R.drawable.dusitthanihotelcairo,"Dusit Thani LakeView Cairo","Very Good", 4.2));

        }


        hotels_Adapter ada = new hotels_Adapter(this,
                R.layout.hotel_item,items);
        list2.setAdapter(ada);

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
