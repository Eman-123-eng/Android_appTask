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

public class restuarant_Activity extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restuarant_activity);
//        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));

        Intent i = getIntent();
        String name = i.getStringExtra("city");
        getSupportActionBar().setTitle(name);

       ListView list2 = findViewById(R.id.list3);
        ArrayList<restuarant> items1 = new ArrayList<restuarant>();


        if (name.equals("Aswan")){
            items1.add(new restuarant(R.drawable.eldokka_rest_aswan,
                    "El Dokka Restaurant","rate: 4.0 Very Good"));
            items1.add(new restuarant(R.drawable.panorama_rest_aswan,
                    "Panorama Restaurant & Bar ","rate: 4.4 Wonderful"));
            items1.add(new restuarant(R.drawable.makka_rest_aswan,"Makka Restaurant","rate: 4.0 Very Good"));
            items1.add(new restuarant(R.drawable.dejas_rest_aswan,"Dega's restaurant | مطعم ديجاز اسوان","rate: 3.9 Very Good"));
            items1.add(new restuarant(R.drawable.citymax,"Abeer Resturant","rate: 4.2 Wonderful"));

        }else if (name.equals("Luxor")){
            items1.add(new restuarant(R.drawable.sonestahotel,"Sonesta St. George Hotel","rate: 9.1 Wonderful"));
            items1.add(new restuarant(R.drawable.steigenbeirgluxor,"Steigenberger Resort Achti","rate: 9.0 Wonderful"));
            items1.add(new restuarant(R.drawable.luxorhotel,"Steigenberger Nile Palace","rate: 9.1 Wonderful"));
        }else{
            items1.add(new restuarant(R.drawable.fairmonthotel,"Fairmont Nile City","rate: 9.1 Wonderful"));
            items1.add(new restuarant(R.drawable.fourseasonshotel,"Four Seasons Hotel ","rate: 9.0 Wonderful"));
            items1.add(new restuarant(R.drawable.amphorashotel,"Amphoras Blu","rate: 8.4 Very Good"));
            items1.add(new restuarant(R.drawable.movenpickhotel,"Movenpick Taba Resort & Spa","rate: 8.3 Very Good"));
            items1.add(new restuarant(R.drawable.luxorhotel,"Steigenberger Nile Palace","rate: 9.1 Wonderful"));
        }


        restuarant_Adapter ada = new restuarant_Adapter(this,
                R.layout.rest_item,items1);
        list2.setAdapter(ada);
        LayoutInflater inflater = this.getLayoutInflater();
        LinearLayout v = (LinearLayout)inflater.inflate(R.layout.rest_item,null);

        Button location = (Button) v.findViewById(R.id.restlocation);


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
