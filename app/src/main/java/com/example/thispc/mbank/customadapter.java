package com.example.thispc.mbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter extends BaseAdapter {
    Context context;
    String[] names;
    int[] images;

    public customadapter(Context context, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.customlayout, parent, false);
        TextView nameView = convertView.findViewById(R.id.nameView);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        nameView.setText(names[position]);
        imageView.setImageResource(images[position]);
        return convertView;
    }
}