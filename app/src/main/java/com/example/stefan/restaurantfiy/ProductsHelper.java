package com.example.stefan.restaurantfiy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by felixdeixler on 16.06.16.
 */
public class ProductsHelper extends SQLiteOpenHelper
{
    public final static String TAG = MainActivity.TAG;
    public final static String DB_NAME = "product.db";
    public final static int DB_VERSION = 2;

    public ProductsHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(ProductsTBL.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(ProductsTBL.SQL_DROP);
        onCreate(db);
    }
}
