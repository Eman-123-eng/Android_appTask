package com.example.task2eman_ziad;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
        String name = i.getStringExtra("title");
        getSupportActionBar().setTitle(name);

        ListView list2 = findViewById(R.id.list2);
        ArrayList<hotel> items = new ArrayList<hotel>();

        items.add(new hotel(R.drawable.fairmonthotel,"Fairmont Nile City","Cairo","rate: 9.1 Wonderful"));
        items.add(new hotel(R.drawable.fourseasonshotel,"Four Seasons Hotel ","Alexandria At San Stefano","rate: 9.0 Wonderful"));
        items.add(new hotel(R.drawable.amphorashotel,"Amphoras Blu","Sharm El Sheikh","rate: 8.4 Very Good"));
        items.add(new hotel(R.drawable.movenpickhotel,"Movenpick Taba Resort & Spa","Taba","rate: 8.3 Very Good"));
        items.add(new hotel(R.drawable.luxorhotel,"Steigenberger Nile Palace","Luxor","rate: 9.1 Wonderful"));
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
