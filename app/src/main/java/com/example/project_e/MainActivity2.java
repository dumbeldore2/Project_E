package com.example.project_e;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    //listview initen
    ListView listView;

    //random arraylist, dit zijn allelmaal defaults
    String[] strings = new String[8];

    //adapter initen
    MainActivity2_list mainActivity2_list;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.color_2_light));
        getWindow().setStatusBarColor(getResources().getColor(R.color.color_1_dark));

        //strings conecte
        strings[0] = "default 1";
        strings[1] = "default 1";
        strings[2] = "default 1";
        strings[3] = "default 1";
        strings[4] = "default 1";
        strings[5] = "default 1";
        strings[6] = "default 1";
        strings[7] = "add";


        //contecten
        mainActivity2_list = new MainActivity2_list(this,strings);
        listView = findViewById(R.id.listview);



        //arraylist adapteren
        listView.setAdapter(mainActivity2_list);

        //funties callen
        click_fun();
    }

    public void click_fun(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == strings.length - 1){
                    Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                    startActivity(intent);
                }
            }
        });
    }
}