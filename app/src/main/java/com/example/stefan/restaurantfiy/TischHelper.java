package com.example.stefan.restaurantfiy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stefan on 20.06.2016.
 */

public class TischHelper extends SQLiteOpenHelper {
    public final static String DB_NAME = "tisch.db";
    public final static int DB_VERSION = 3;

    public TischHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TischTBL.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(TischTBL.SQL_DROP);
        onCreate(db);
    }
}
