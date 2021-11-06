package com.example.project_e;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    //Textviews initen
    TextView textView1;
    TextView textView4;

    //database initen
    Database database;

    //EditText initen
    EditText editText1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.color_2_light));
        getWindow().setStatusBarColor(getResources().getColor(R.color.color_1_dark));

        //textview conecteren
        textView1 = findViewById(R.id.text1);
        textView4 = findViewById(R.id.text4);

        //edittext conecten
        editText1 = findViewById(R.id.editText1);

        //database conecten
        database = new Database(this);

        //functies
        clickAdd();
        clickHome();
    }

    public void clickAdd(){
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getEditText().length() != 0){
                    database.addToTabel1(getEditText());
                    Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }

    public String getEditText(){
        String uit = "";
        if (editText1.getText().toString().length() != 0){
            uit = editText1.getText().toString();
        }
        return uit;
    }

    public void clickHome(){
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}