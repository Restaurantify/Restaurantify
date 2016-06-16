package com.example.stefan.restaurantfiy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sgschaider on 16.06.2016.
 */
public class BestellungHelper extends SQLiteOpenHelper
{
    private final static String TAG = MainActivity.TAG;
    private final static String DB_NAME = "bestellung.db";
    private final static int DB_VERSION = 2;

    public BestellungHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(BestellungTBL.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion)
    {
        db.execSQL(BestellungTBL.SQL_DROP);
        onCreate(db);
    }
}

