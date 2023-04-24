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

public class tourist_Activity  extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_activity);
//        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));

        Intent i = getIntent();
        String name = i.getStringExtra("city");
        getSupportActionBar().setTitle(name);

        ListView list2 = findViewById(R.id.list4);
        ArrayList<tourist> items = new ArrayList<tourist>();


        if (name.equals("Aswan")){
            items.add(new tourist(R.drawable.nub_museum,
                    "Nubian Museum","rate: 4.6 Wonderful"));
            items.add(new tourist(R.drawable.abu_elhawa,
                    "Dome of Abu Al-Hawa ","rate: 4.8 Wonderful"));
            items.add(new tourist(R.drawable.feryal,"Feryal Garden","rate: 4.4 Very Good"));
            items.add(new tourist(R.drawable.abusimple_temple_aswan,"Abu Simple Temple","rate: 4.4 Very Good"));
            items.add(new tourist(R.drawable.philae_temple_aswan,"Philae Temple","rate: 4.8 Wonderful"));

        }else if (name.equals("Luxor")){
            items.add(new tourist(R.drawable.sonestahotel,"Sonesta St. George Hotel","rate: 9.1 Wonderful"));
            items.add(new tourist(R.drawable.steigenbeirgluxor,"Steigenberger Resort Achti","rate: 9.0 Wonderful"));
            items.add(new tourist(R.drawable.luxorhotel,"Steigenberger Nile Palace","rate: 9.1 Wonderful"));
        }else{
            items.add(new tourist(R.drawable.fairmonthotel,"Fairmont Nile City","rate: 9.1 Wonderful"));
            items.add(new tourist(R.drawable.fourseasonshotel,"Four Seasons Hotel ","rate: 9.0 Wonderful"));
            items.add(new tourist(R.drawable.amphorashotel,"Amphoras Blu","rate: 8.4 Very Good"));
            items.add(new tourist(R.drawable.movenpickhotel,"Movenpick Taba Resort & Spa","rate: 8.3 Very Good"));
            items.add(new tourist(R.drawable.luxorhotel,"Steigenberger Nile Palace","rate: 9.1 Wonderful"));
        }


        tourist_Adapter ada = new tourist_Adapter(this,
                R.layout.tourist_item,items);
        list2.setAdapter(ada);
        LayoutInflater inflater = this.getLayoutInflater();
        LinearLayout v = (LinearLayout)inflater.inflate(R.layout.tourist_item,null);

        Button location = (Button) v.findViewById(R.id.tourlocation);


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
