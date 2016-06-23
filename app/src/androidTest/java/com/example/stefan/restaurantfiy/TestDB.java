package com.example.stefan.restaurantfiy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

/**
 * Created by felixdeixler on 22.06.16.
 */
public class TestDB extends AndroidTestCase{

    void deleteTheDB(){
        mContext.deleteDatabase(TischHelper.DB_NAME);
    }
    public void setUp(){
        deleteTheDB();
    }

    public void testCreateDb() throws Throwable{

        SQLiteDatabase db = new TischHelper(this.mContext).getWritableDatabase();
        assertEquals(true,db.isOpen());



    }
}
