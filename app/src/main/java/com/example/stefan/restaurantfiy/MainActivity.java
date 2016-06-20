package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.jar.Manifest;


public class MainActivity extends ListActivity {
    ArrayList<Tisch> items = new ArrayList<Tisch>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TischHelper helper = new TischHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(TischTBL.SQL_CREATE);
        seed(db);
        initListData();
        displayItems();



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String name = String.valueOf(items.get(position));
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    private void displayItems() {
        final ArrayAdapter<Tisch>adapter = new ArrayAdapter<Tisch>(this,android.R.layout.simple_list_item_2,items);
        setListAdapter(adapter);
    }

    private void initListData() {

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
                neuerTisch();
                return true;
            case R.id.neuesProdukt:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void neuerTisch() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
        final LinearLayout vDialog = (LinearLayout) getLayoutInflater().inflate(R.layout.dialogtisch, null);
        alert.setView(vDialog);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.setNegativeButton("Cancel", null);
        alert.show();
    }
}
