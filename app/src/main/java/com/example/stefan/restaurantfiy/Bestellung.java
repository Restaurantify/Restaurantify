package com.example.stefan.restaurantfiy;

/**
 * Created by Test on 09.06.2016.
 */
public class Bestellung
{
    String TischNr;
    String produkt;
    String anzahl;
    double preis;

    public Bestellung( String tischNr, String produkt, String anzahl, double preis) {
        TischNr = tischNr;
        this.produkt = produkt;
        this.anzahl = anzahl;
        this.preis = preis;
    }

    public Bestellung() {
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                ", TischNr='" + TischNr + '\'' +
                ", produkt='" + produkt + '\'' +
                ", anzahl='" + anzahl + '\'' +
                ", preis=" + preis +
                '}';
    }



    public String getTischNr() {
        return TischNr;
    }

    public void setTischNr(String tischNr) {
        TischNr = tischNr;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public String getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(String anzahl) {
        this.anzahl = anzahl;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
