package com.example.stefan.restaurantfiy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;

/**
 * Created by Test on 09.06.2016.
 */
public class LoginHelper extends SQLiteOpenHelper
{
    private final static String DB_NAME = "login.db";
    private final static int DB_VERSION = 2;

    public LoginHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(LoginTBL.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(LoginTBL.SQL_DROP);
        onCreate(db);
    }
}
