package com.example.task2eman_ziad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import java.util.ArrayList;

public class restaurant_Activity extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restuarant_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));

        Intent i = getIntent();
        String name = i.getStringExtra("city");
        getSupportActionBar().setTitle(name);

       ListView list2 = findViewById(R.id.list3);
        ArrayList<restaurant> items1 = new ArrayList<restaurant>();


        if (name.equals("Aswan")){
            items1.add(new restaurant(R.drawable.eldokka_rest_aswan,
                    "El Dokka Restaurant","Very Good", 4.0));
            items1.add(new restaurant(R.drawable.panorama_rest_aswan,
                    "Panorama Restaurant & Bar ","Wonderful", 4.4));
            items1.add(new restaurant(R.drawable.makka_rest_aswan,"Makka Restaurant","Very Good", 3.0));
            items1.add(new restaurant(R.drawable.dejas_rest_aswan,"Dega's Restaurant | مطعم ديجاز أسوان","Very Good", 2.9));
            items1.add(new restaurant(R.drawable.citymax,"Abeer Resturant","Wonderful", 4.2));

        }else if (name.equals("Luxor")){
            items1.add(new restaurant(R.drawable.elkabagy_rest_luxor,"El-kababgy Luxor","Wonderful", 4.6));
            items1.add(new restaurant(R.drawable.lantern_rest_luxor,"The Lantern Room Restaurant","Wonderful", 4.1));
            items1.add(new restaurant(R.drawable.miyako_jpanese_restaurant_luxor,"Miyako Japanese Restaurant","Wonderful", 4.6));
        }else{
            items1.add(new restaurant(R.drawable.elkhal_rest_cairo,"Al Khal Egyptian Restaurant","Wonderful", 4.6));
            items1.add(new restaurant(R.drawable.fayrouz_rest_cairo,"Fayrouz Restaurant","Wonderful", 4.5));
            items1.add(new restaurant(R.drawable.nobelhouse_rest_cairo,"Nobel House","Very Good", 4.2));
        }


        restaurant_Adapter ada = new restaurant_Adapter(this,
                R.layout.rest_item,items1);
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
