package com.example.task2eman_ziad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class hotels_Adapter extends ArrayAdapter<hotel> {
    Context context;
    int resource;
    ArrayList<hotel> list;
    public hotels_Adapter(Context context, int resource, ArrayList<hotel>
            list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(resource, null,
                    false);
        }
        TextView name = v.findViewById(R.id.hotel_names);
        name.setText(list.get(position).getName());
        ImageView image = v.findViewById(R.id.hotel_imgs);

        image.setImageResource(list.get(position).getImage_resource_id());


        TextView rate = v.findViewById(R.id.rating);
        rate.setText(list.get(position).getRate());

        RatingBar ratingBar = v.findViewById(R.id.ratingBar);
        ratingBar.setRating((float)list.get(position).getRate_bar());

        Button location = (Button) v.findViewById(R.id.location);


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a Uri from an intent string. Use the result to create an Intent.
//                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");


// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=loc:"+list.get(position).getName()));
//                mapIntent.setData(gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                Intent chooser= Intent.createChooser(mapIntent,"string");

// Attempt to start an activity that can handle the Intent
                context.startActivity(chooser);


            }
        });


        return v;
    }

}
