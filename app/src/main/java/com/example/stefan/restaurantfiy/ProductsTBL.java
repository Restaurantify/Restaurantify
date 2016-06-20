package com.example.stefan.restaurantfiy;

/**
 * Created by felixdeixler on 16.06.16.
 */
public class ProductsTBL
{
    public static final String TABLE_NAME = "products";
    public final static String productNr = "productNr";
    public final static String productName = "productName";
    public final static String price = "price";
    public final static String vegan = "vegan";
    public final static String vegetarisch = "vegetarisch";


    public static final String SQL_DROP = "DROP TABLE IF EXISTS" + TABLE_NAME;

    public static final String SQL_CREATE =
            "CREATE TABLE" + TABLE_NAME +
                    "(" +
                    productNr + " INTEGER PRIMARY KEY," +
                    productName + " TEXT NOT NULL,"+
                    price + " TEXT NOT NULL," +
                    vegan + " TEXT,"+
                    vegetarisch + " TEXT" +
                    ")";
    public static final String STMT_DELETE = "DELETE FROM" + TABLE_NAME;
    public static final String STMT_INSERT =
            "INSERT INTO" + TABLE_NAME+
                    "(" + productName + "," + productName + "," + price + "," + vegan + "," + vegetarisch + ") " +
                    "VALUES (?,?,?,?,?)";



}
