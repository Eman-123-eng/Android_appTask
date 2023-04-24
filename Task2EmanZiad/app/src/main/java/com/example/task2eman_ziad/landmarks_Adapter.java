package com.example.task2eman_ziad;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class landmarks_Adapter extends ArrayAdapter<landmarks> {
    Context context;
    int resource;
    ArrayList<landmarks> list;
    public landmarks_Adapter(Context context, int resource, ArrayList<landmarks>
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
        TextView name = v.findViewById(R.id.main_names);
        name.setText(list.get(position).getName());
        ImageView image = v.findViewById(R.id.main_imgs);

        image.setImageResource(list.get(position).getImage_resource_id());

        return v;
    }

}
