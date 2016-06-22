package com.example.stefan.restaurantfiy;

import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.StringReader;

/**
 * Created by sgschaider on 16.06.2016.
 */
public class BestellungTBL
{
    public static final String TABLE_NAME = "Bestellung";

    public final static String BestellId = "BestellID";
    public final static String TischNr = "TischNr";
    public final static String Produkt = "Produkt";
    public final static String Anzahl = "Anzahl";
    public final static String Preis = "Preis";
    public static final String[] ALL_COLUMNS = new String[] {BestellId + " AS_id", TischNr, Produkt, Anzahl, Preis};

    public static final String SQL_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    BestellId + " INTEGER PRIMARY KEY," +
                    TischNr + " TEXT NOT NULL," +
                    Produkt + " TEXT NOT NULL," +
                    Anzahl + " TEXT NOT NULL," +
                    Preis + " TEXT NOT NULL" +
                    ")";
    public static final String STMT_DELETE = "DELETE FROM" + TABLE_NAME;
    public static final String STMT_INSERT =
            " INSERT INTO " + TABLE_NAME +
                    "(" + BestellId + "," + TischNr + "," + Produkt + "," + Anzahl + "," + Preis + ") " +
                    "VALUES (?,?,?,?,?)";

}
