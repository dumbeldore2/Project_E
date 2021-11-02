package com.example.project_e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database  extends SQLiteOpenHelper {

    //db naam
    public static String DATABASE_NAME = "database_project_MMJ.db";
    //tabel 1
    public static final String DATABASE_table_1 = "object";
    public static final String Table_1_col_0 = "object_id";
    public static final String Table_1_col_1 = "object_naam";
    public static final String Table_1_col_2 = "object_nummer";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_table_1 + "(" + Table_1_col_0 + " INTEGER DEFAULT 0 primary key ,"
                + Table_1_col_1 + " TEXT ," + Table_1_col_2 + " INTEGER default 0 )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_1);
    }

}
