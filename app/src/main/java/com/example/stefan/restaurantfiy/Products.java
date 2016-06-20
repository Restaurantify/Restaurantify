package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by felixdeixler on 16.06.16.
 */
public class Products extends Activity{


    protected void onCreate()
    {
        setContentView(R.layout.products);

        ListView view = (ListView) findViewById(R.id.productsView);
        ArrayList<String> list = new ArrayList<String>();
        list.add(1,"Test1");
        list.add(2,"Test2");
        list.add(3,"Test3");
    }
}
