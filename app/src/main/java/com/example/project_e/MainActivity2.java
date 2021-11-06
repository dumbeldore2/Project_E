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
    String[] strings = {};
    String[] strings2 = {};

    //adapter initen
    MainActivity2_list mainActivity2_list;

    //Database initen
    Database database;

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

        //contecten
        listView = findViewById(R.id.listview);

        //conecten van de database
        database = new Database(this);


        //funties callen
        click_fun();
        addToListview();
    }

    public void click_fun(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == strings2.length - 1){
                    Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                    System.out.println(position);
                    intent.putExtra("pos",position);
                    startActivity(intent);
                }
            }
        });
    }

    public void addToListview(){
        if (database.namen().length != 0){
            strings = database.namen().clone();

            strings2 = new String[strings.length + 1];

            for (int i = 0 ; i <= strings.length -1 ; i++){
                strings2[i] = strings[i];
            }

            strings2[strings2.length -1] = "add";

            //arraylist adapteren
            mainActivity2_list = new MainActivity2_list(this,strings2);
            listView.setAdapter(mainActivity2_list);
        } else {
            strings2 = new String[1];
            strings2[0] = "add";
            //arraylist adapteren
            mainActivity2_list = new MainActivity2_list(this,strings2);
            listView.setAdapter(mainActivity2_list);
        }
    }
}