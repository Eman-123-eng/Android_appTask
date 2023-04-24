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

public class tourist_Activity  extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#018786")));

        Intent i = getIntent();
        String name = i.getStringExtra("city");
        getSupportActionBar().setTitle(name);

        ListView list2 = findViewById(R.id.list4);
        ArrayList<tourist> items = new ArrayList<tourist>();


        if (name.equals("Aswan")){
            items.add(new tourist(R.drawable.nub_museum,
                    "Nubian Museum","Wonderful", 4.6));
            items.add(new tourist(R.drawable.abu_elhawa,
                    "Dome of Abu Al-Hawa ","Wonderful", 4.8));
            items.add(new tourist(R.drawable.feryal,"Feryal Garden","Very Good", 4.4));
            items.add(new tourist(R.drawable.abusimple_temple_aswan,"Abu Simple Temple","Very Good", 4.4));
            items.add(new tourist(R.drawable.philae_temple_aswan,"Philae Temple","Wonderful", 4.8));

        }else if (name.equals("Luxor")){
            items.add(new tourist(R.drawable.ramses_temple_luxor,"Ramses Tomb","Wonderful", 4.6));
            items.add(new tourist(R.drawable.karnak_temple_luxor,"Karnak temple","Wonderful", 4.5));
            items.add(new tourist(R.drawable.hatshepsut_temple_luxor,"Hatshepsut Temple","Wonderful", 4.6));
        }else{
            items.add(new tourist(R.drawable.mosque_sultanhassan_cairo,"Sultan Hassan Mosque","Wonderful", 4.6));
            items.add(new tourist(R.drawable.mosque_ibntulun_cairo,"Ibn Tolon Mosque","Wonderful", 4.5));
            items.add(new tourist(R.drawable.babzewala_cairo,"Bab Zewela","Very Good", 4.2));
        }


        tourist_Adapter ada = new tourist_Adapter(this,
                R.layout.tourist_item,items);
        list2.setAdapter(ada);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
