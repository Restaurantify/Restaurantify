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
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Manifest;


public class MainActivity extends ListActivity {

    final List<String[]> tische = new LinkedList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readDatabase();
        displayItems(tische);




    }

    private void displayItems(final List<String[]> tische) {

        final ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2,android.R.id.text1, tische) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                String[] entry = tische.get(position);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(entry[0]);
                text2.setText(entry[1]);

                return view;
            }

        };
        setListAdapter(adapter);
    }
    private void readDatabase() {
        TischHelper helper = new TischHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

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

        while (res.moveToNext()) {
            String isfree;
            if (res.getString(indxBesetzt) == "0") {
                isfree="Frei";
            } else {
               isfree="Besetzt";
            }
            String[] string = {res.getString(indxTischNr), isfree};
            tische.add(string);

        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String name = String.valueOf(tische.get(position));
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
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
        builder.setMessage("Tischnummer eingeben")
                .setCancelable(false)
                .setView(txtNewName)
                .setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newName = "Tisch " + txtNewName.getText().toString();

                    }
                })
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog aler = builder.create();
        aler.show();

        }





    }
