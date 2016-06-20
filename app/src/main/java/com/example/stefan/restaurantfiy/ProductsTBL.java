package com.example.stefan.restaurantfiy;

/**
 * Created by felixdeixler on 16.06.16.
 */
public class ProductsTBL
{
    public static final String TABLE_NAME = "products";
    public final static String productNr = "productNr";


    public static final String SQL_DROP = "DROP TABLE IF EXISTS" + TABLE_NAME;

    public static final String SQL_CREATE =
            "CREATE TABLE" + TABLE_NAME +
                    "(" +
                    ")";
    public static final String STMT_DELETE = "DELETE FROM" + TABLE_NAME;
    public static final String STMT_INSERT =
            "INSERT INTO" + TABLE_NAME;

    //noch nicht fertig nur das keine Fehler mehr sind in der ProductsHelper Klasse!!!!
}
