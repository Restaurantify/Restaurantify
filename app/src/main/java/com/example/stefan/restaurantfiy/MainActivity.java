package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;

import java.util.StringTokenizer;
import java.util.jar.Manifest;


public class MainActivity extends Activity{

    public static final String TAG = MainActivity.TAG;
    LoginHelper helper = new LoginHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bestellung bestellung = new Bestellung();
        Gson gson = new Gson();
        String json = gson.toJson(bestellung);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void neuRegistrieren(View view)
    {
        Intent intent = new Intent(this, RegistrierungActivity.class);
        startActivity(intent);
    }

    public void okBtn(View view)
    {
        EditText uname = (EditText)findViewById(R.id.nameET);
        EditText pass = (EditText)findViewById(R.id.passwortET);
        String username = uname.getText().toString();
        String passwort = pass.getText().toString();
        String searchPW = helper.searchPass(username);
        if(passwort.equals(searchPW))
        {
            Intent i = new Intent(this,Details.class);
            i.putExtra("Username",username);
        }
        else
        {
            Toast.makeText(this, "Username und Passwort nicht gefunden", Toast.LENGTH_SHORT).show();

        }
    }
}
