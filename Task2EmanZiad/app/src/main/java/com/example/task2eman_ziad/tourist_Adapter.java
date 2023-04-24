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
import android.widget.TextView;

import java.util.ArrayList;

public class tourist_Adapter extends ArrayAdapter<tourist> {
    Context context;
    int resource;
    ArrayList<tourist> list;
    public tourist_Adapter(Context context, int resource, ArrayList<tourist>
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
        TextView name = v.findViewById(R.id.tour_names);
        name.setText(list.get(position).getName());
        ImageView image = v.findViewById(R.id.tour_imgs);

        image.setImageResource(list.get(position).getImage_resource_id());


        TextView rate = v.findViewById(R.id.tourrating);
        rate.setText(list.get(position).getRate());

        Button location = (Button) v.findViewById(R.id.tourlocation);


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

//        System.out.println(position);

        return v;
    }

}