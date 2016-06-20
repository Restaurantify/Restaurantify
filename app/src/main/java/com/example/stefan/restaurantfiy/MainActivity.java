package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;

import java.util.StringTokenizer;
import java.util.jar.Manifest;


public class MainActivity extends Activity{
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db.execSQL(TischTBL.SQL_CREATE);
        seed(db);

        Bestellung bestellung = new Bestellung();
        Gson gson = new Gson();
        String json = gson.toJson(bestellung);


    }

    private void seed(SQLiteDatabase db) {
        final SQLiteStatement stmt = db.compileStatement(TischTBL.STMT_INSERT);
        db.beginTransaction();
        try
        {
            insertTisch(stmt, "Tisch 1", 0);
            insertTisch(stmt, "Tisch 2", 0);
            insertTisch(stmt, "Tisch 3", 0);
            db.setTransactionSuccessful();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        finally {
            db.endTransaction();
        }


    }

    private void insertTisch(SQLiteStatement stmt, String TischNr, int besetzt) {
        stmt.bindString(1, TischNr);
        stmt.bindLong(2, besetzt);
        stmt.executeInsert();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch(id)
        {
            case R.id.neuerTisch:
                return true;
            case R.id.neuesProdukt:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
