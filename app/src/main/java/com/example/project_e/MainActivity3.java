package com.example.project_e;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    //Textview ininten
    TextView textView3;
    TextView textView4;
    TextView textView5;

    //database initen
    Database database;

    //intent initen
    Intent intent;

    //int ininten
    int pos = 0;
    int a = 0;
    int b = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.color_2_light));
        getWindow().setStatusBarColor(getResources().getColor(R.color.color_1_dark));

        //textview conecten
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);
        textView5 = findViewById(R.id.text5);

        //database conecten
        database = new Database(this);

        //intent conecten
        intent = getIntent();

        //int conecten
        pos = intent.getIntExtra("pos",-1);

        //fun
        setText();
        clickFunMin();
        clickFunPlus();
    }

    public void setText(){
        textView3.setText("" + database.getTable_col_2(pos));
    }

    public void clickFunMin(){
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (database.getTable_col_2(pos) != 0){
                    database.minFun(pos);
                    setText();
                }
            }
        });
    }
    public void clickFunPlus(){
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.plusFun(pos);
                setText();
            }
        });
    }

    public void changeAbackgroundToLight(){
        textView4.setBackgroundResource(R.drawable.backgroundma3part4);
        textView4.setTextColor(getResources().getColor(R.color.color_1_dark));
    }
    public void changeAbackgroundToDark(){
        textView4.setBackgroundResource(R.drawable.backgroundma3part3);
        textView4.setTextColor(getResources().getColor(R.color.color_2_light));
    }
    public void changeBbackgroundToLight(){
        textView5.setBackgroundResource(R.drawable.backgroundma3part4);
        textView5.setTextColor(getResources().getColor(R.color.color_1_dark));
    }
    public void changeBbackgroundToDark(){
        textView5.setBackgroundResource(R.drawable.backgroundma3part3);
        textView5.setTextColor(getResources().getColor(R.color.color_2_light));
    }
}