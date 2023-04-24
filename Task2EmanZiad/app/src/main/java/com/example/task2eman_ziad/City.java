package com.example.task2eman_ziad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import java.util.ArrayList;

public class City extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));
        getSupportActionBar().setTitle("Welcome !");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Intent i = getIntent();
        String name = i.getStringExtra("title");
        getSupportActionBar().setTitle(name);

        ListView list1 = findViewById(R.id.list);
        ArrayList<landmarks> items = new ArrayList<landmarks>();

        items.add(new landmarks(R.drawable.hotels,"Hotels"));
        items.add(new landmarks(R.drawable.restuarants,"Restuarants"));
        items.add(new landmarks(R.drawable.tourism,"Tourist Attractions"));

        landmarks_Adapter ada = new landmarks_Adapter(this,
                R.layout.main_list_item,items);
        list1.setAdapter(ada);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                switch(itemPosition){
                    case 0:
                        Intent i = new Intent(City.this,
                                hotel_Activity.class);
                        String itemname0 = items.get(position).getName();
                        i.putExtra("title",itemname0);
                        i.putExtra("city",name);
                        startActivity(i);
                        break;
                    case 1:
                        Intent j = new Intent(City.this,
                                restuarant_Activity.class);
                        String itemname1 = items.get(position).getName();
                        j.putExtra("title",itemname1);
                        j.putExtra("city",name);
                        startActivity(j);
                        break;
                    case 2:
                        Intent y = new Intent(City.this,
                                tourist_Activity.class);
                        String itemname2 = items.get(position).getName();
                        y.putExtra("title",itemname2);
                        y.putExtra("city",name);
                        startActivity(y);
                        break;

                    default:
                        break;
                }
            }
        });

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
