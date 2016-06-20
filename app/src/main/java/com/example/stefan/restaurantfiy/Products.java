package com.example.stefan.restaurantfiy;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by felixdeixler on 16.06.16.
 */
public class Products extends Activity
{
    String Name;
    String Preis;
    String normal;
    String Vegetarisch;
    String Vegan;



    public Products(String name, String preis, String normal, String vegetarisch, String vegan) {
        Name = name;
        Preis = preis;
        this.normal = normal;
        Vegetarisch = vegetarisch;
        Vegan = vegan;
    }

    public Products() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPreis() {
        return Preis;
    }

    public void setPreis(String preis) {
        Preis = preis;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getVegetarisch() {
        return Vegetarisch;
    }

    public void setVegetarisch(String vegetarisch) {
        Vegetarisch = vegetarisch;
    }

    public String getVegan() {
        return Vegan;
    }

    public void setVegan(String vegan) {
        Vegan = vegan;
    }

    @Override
    public String toString() {
        return Name + "," + Preis + "," + normal +   "," +  Vegetarisch + ","  + Vegan;
    }
}
