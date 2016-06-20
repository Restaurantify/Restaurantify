package com.example.stefan.restaurantfiy;

/**
 * Created by Stefan on 20.06.2016.
 */

public class TischTBL {

    public static final String TABLE_NAME = "Tische";

    public final static String TischId = "TischID";
    public final static String TischNr = "TischNr";
    public final static String Besetzt = "Besetzt";
    public static final String [] ALL_COLUMNS = new String[] {TischId + "AS_id", TischNr, Besetzt};

    public static final String SQL_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    TischId + " INTEGER PRIMARY KEY," +
                    TischNr + " TEXT NOT NULL," +
                    Besetzt + " INT NOT NULL" +
                    ")";
    public static final String STMT_DELETE = "DELETE FROM " + TABLE_NAME;
    public static final String STMT_INSERT =
            "INSERT INTO " + TABLE_NAME +
                    "(" + TischNr + "," + Besetzt + ") " +
                    "VALUES (?,?)";
}
