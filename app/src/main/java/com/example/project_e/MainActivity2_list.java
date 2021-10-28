package com.example.project_e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2_list extends ArrayAdapter {
    Context context;
    String string[];

    public MainActivity2_list(@NonNull Context c,String s[]) {
        super(c, R.layout.activity_main_activity2_list , R.id.listview , s);
        this.context = c;
        this.string = s;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main_activity2_list,parent,false);
        TextView names = row.findViewById(R.id.text_listview);
        names.setText(string[position]);

        return row;
    }
}