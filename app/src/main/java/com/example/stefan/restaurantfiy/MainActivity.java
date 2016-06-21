package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
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
        ArrayList<Tisch> tische = readDatabase();
        Tisch t1 = new Tisch("Tisch 1", 0);
        tische.add(t1);
        displayItems(tische);




    }

    private ArrayList readDatabase() {
        TischHelper helper = new TischHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Tisch> tischListe = new ArrayList<>();
        Cursor res = db.query(TischTBL.TABLE_NAME,
                TischTBL.ALL_COLUMNS,
                null,
                null,
                null,
                null,
                TischTBL.TischNr,
                null);

        int indxTischNr = res.getColumnIndex(TischTBL.TischNr);
        int indxBesetzt = res.getColumnIndex(TischTBL.Besetzt);

        while(res.moveToNext())
        {
            Tisch t = new Tisch(res.getString(indxTischNr),res.getInt(indxBesetzt));
            tischListe.add(t);
        }
        return tischListe;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String name = String.valueOf(items.get(position));
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    private void displayItems(ArrayList<Tisch> tische) {
        final ArrayAdapter<Tisch>adapter = new ArrayAdapter<Tisch>(this,android.R.layout.simple_list_item_1,tische);
        setListAdapter(adapter);
    }

    private void initListData() {

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
        final EditText txtNewName = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tisch eingeben")
                .setCancelable(false)
                .setView(txtNewName);
                //.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface().


        //muss man noch fertig machen

    }
}
