package com.example.stefan.restaurantfiy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;
import android.widget.Toast;

/**
 * Created by Test on 09.06.2016.
 */
public class LoginHelper extends SQLiteOpenHelper
{
    private final static String DB_NAME = "login.db";
    private final static int DB_VERSION = 2;
    public static final String TABLE_NAME = "Login";

    public final static String PersonId = "PersonId";
    public final static String Vorname = "Vorname";
    public final static String Nachname = "Nachname";
    public final static String Username = "Username";
    public final static String Password = "Password";
    SQLiteDatabase db;

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

    public LoginHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
        this.db = db;
    }

    public void insertContact(Contact c) {
        ContentValues values = new ContentValues();
        values.put(Vorname, c.getVname());
        values.put(Nachname, c.getNname());
        values.put(Username, c.getUname());
        values.put(Password, c.getPass());
        System.out.println(c.getPass());
        db.insert(TABLE_NAME, null ,values);
        db.close();
    }

    public String searchPass(String username)
    {
        //Fehler
        db = this.getReadableDatabase();
        String query = "select Username, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b= "Nicht gefunden";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(username))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
