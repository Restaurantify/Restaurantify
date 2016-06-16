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
    public final static String Bestellung = "Bestellung";


    public static final String SQL_DROP = "DROP TABLE IF EXISTS" + TABLE_NAME;
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    BestellId + "INTEGER PRIMARY KEY," +
                    Bestellung + "TEXT NOT NULL" +
                    ")";
    public static final String STMT_DELETE = "DELETE FROM" + TABLE_NAME;
    public static final String STMT_INSERT =
            "INSERT INTO" + TABLE_NAME +
                    "(" + BestellId + "," + Bestellung + ")" +
                    "VALUES (?,?)";

}
