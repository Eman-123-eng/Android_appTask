package com.example.task2eman_ziad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));
        getSupportActionBar().setTitle("Tour Guide");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ListView list1 = findViewById(R.id.list);
        ArrayList<landmarks> items = new ArrayList<landmarks>();

        items.add(new landmarks(R.drawable.aswan,"Aswan"));
        items.add(new landmarks(R.drawable.luxor,"Luxor"));
        items.add(new landmarks(R.drawable.cairo,"Cairo"));

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
                        Intent i = new Intent(MainActivity.this,
                                City.class);
                        String itemname0 = items.get(position).getName();
                        i.putExtra("title",itemname0);
                        startActivity(i);
                        break;
                    case 1:
                        Intent j = new Intent(MainActivity.this,
                                City.class);
                        String itemname1 = items.get(position).getName();
                        j.putExtra("title",itemname1);
                        startActivity(j);
                        break;
                    case 2:
                        Intent y = new Intent(MainActivity.this,
                                City.class);
                        String itemname2 = items.get(position).getName();
                        y.putExtra("title",itemname2);
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
            // Res§pond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}