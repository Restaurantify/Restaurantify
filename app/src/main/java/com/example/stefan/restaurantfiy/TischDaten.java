package com.example.stefan.restaurantfiy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by felixdeixler on 20.06.16.
 */
public class TischDaten extends ListActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tisch_daten);
        ArrayList <Bestellung> best = new ArrayList<>();
        best = getOrders();
        showinList(best);
    }

    private void showinList(ArrayList<Bestellung> best)
    {
        final ArrayAdapter<Bestellung> adapter = new ArrayAdapter<Bestellung>(this, android.R.layout.simple_list_item_1,best);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.products_hinzufuegen, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.neuesProdukt:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ArrayList getOrders()
    {
        ArrayList<Bestellung> orders = new ArrayList<>();
        String tischnr = null; //wird von main übergeben
        Gson gson = new Gson();

        Bestellung best = new Bestellung();
        BestellungHelper helper = new BestellungHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor res = db.query(BestellungTBL.TABLE_NAME,
                BestellungTBL.ALL_COLUMNS,
                BestellungTBL.TischNr + "=?",
                new String[]{tischnr},
                null,
                null,
                BestellungTBL.BestellId,
                null);
        int indxName = res.getColumnIndex(BestellungTBL.Produkt);
        int indxPrice = res.getColumnIndex(BestellungTBL.Preis);

        while (res.moveToNext())
        {

            String jsonName = res.getString(indxName);
            Products product = gson.fromJson(jsonName,Products.class);
            String productname = product.getName();
            best.setPreis(res.getString(indxPrice));
            best.setName(productname);
            orders.add(best);

        }

        return orders;

    }

}
