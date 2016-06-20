package com.example.stefan.restaurantfiy;

/**
 * Created by Stefan on 20.06.2016.
 */

public class Tisch {
    String TischNr;
    int besetzt;

    public Tisch(String tischNr, int besetzt) {
        TischNr = tischNr;
        this.besetzt = besetzt;
    }

    @Override
    public String toString() {
        return "Tisch{" +
                "TischNr='" + TischNr + '\'' +
                ", besetzt=" + besetzt +
                '}';
    }
}
