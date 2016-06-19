package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Stefan on 09.06.2016.
 */
public class RegistrierungActivity extends Activity {

    LoginHelper lHelper = new LoginHelper(this);
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neuregistrieren);
    }

    public void Registrieren(View view)
    {
        EditText vname = (EditText)findViewById(R.id.editTextVName);
        EditText nname = (EditText)findViewById(R.id.editTextName);
        EditText uname = (EditText)findViewById(R.id.editTextUsername);
        EditText pw = (EditText)findViewById(R.id.editTextPasswort);
        EditText cPw = (EditText)findViewById(R.id.editTextPasswortConfirm);

        String vorname = vname.getText().toString();
        String nachname = nname.getText().toString();
        String username = uname.getText().toString();
        String passwort = pw.getText().toString();
        String confirmPw = cPw.getText().toString();

        if(!confirmPw.equals(passwort))
        {
            Toast.makeText(this, "Passwörter stimmen nicht überein", Toast.LENGTH_SHORT).show();
        }
        else
        {
            db = lHelper.getWritableDatabase();
            Contact c = new Contact();
            c.setVname(vorname);
            c.setNname(nachname);
            c.setUname(username);
            c.setPass(passwort);

            lHelper.insertContact(c);
        }
    }
}
