package com.example.stefan.restaurantfiy;

/**
 * Created by Test on 09.06.2016.
 */
public class LoginTBL
{
    public static final String TABLE_NAME = "Login";

    public final static String PersonId = "PersonId";
    public final static String Vorname = "Vorname";
    public final static String Nachname = "Nachname";
    public final static String Username = "Username";
    public final static String Password = "Password";


    public static final String SQL_DROP = "DROP TABLE IF EXISTS" + TABLE_NAME;
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    PersonId + "INTEGER PRIMARY KEY," +
                    Vorname + "TEXT NOT NULL," +
                    Nachname + "TEXT NOT NULL,"+
                    Username + "TEXT NOT NULL,"+
                    Password + "TEXT NOT NULL" +
                    ")";

    public static final String STMT_DELETE = "DELETE_FROM" + TABLE_NAME;
    public static final String STMT_INSERT =
            "INSERT INTO " + TABLE_NAME +
                    "(" + Vorname + "," + Nachname + "," + Username + "," + Password + ")" +
                    "VALUES (?,?,?,?)";
}
