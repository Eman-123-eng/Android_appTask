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

public class restaurant_Adapter extends ArrayAdapter<restaurant> {
    Context context;
    int resource;
    ArrayList<restaurant> list;
    public restaurant_Adapter(Context context, int resource, ArrayList<restaurant>
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
        TextView name = v.findViewById(R.id.rest_names);
        name.setText(list.get(position).getName());
        ImageView image = v.findViewById(R.id.rest_imgs);

        image.setImageResource(list.get(position).getImage_resource_id());


        TextView rate = v.findViewById(R.id.restrating);
        rate.setText(list.get(position).getRate());

        RatingBar ratingBar = v.findViewById(R.id.ratingBar);
        ratingBar.setRating((float)list.get(position).getRate_bar());

        Button location = (Button) v.findViewById(R.id.restlocation);


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=loc:"+list.get(position).getName()));
                mapIntent.setPackage("com.google.android.apps.maps");
                Intent chooser= Intent.createChooser(mapIntent,"string");
                context.startActivity(chooser);
            }
        });

        return v;
    }

}
