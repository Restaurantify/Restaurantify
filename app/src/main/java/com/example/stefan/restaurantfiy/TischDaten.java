package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by felixdeixler on 20.06.16.
 */
public class TischDaten extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tisch_daten);
    }

    public ArrayList getOrders()
    {
        ArrayList<Bestellung> orders = new ArrayList<>();
        String tischnr = null;
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
