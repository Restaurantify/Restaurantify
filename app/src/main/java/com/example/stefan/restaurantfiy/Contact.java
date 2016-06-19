package com.example.stefan.restaurantfiy;

/**
 * Created by Stefan on 19.06.2016.
 */

public class Contact {

    String vname,nname,uname,pass;

    public Contact( String vname, String nname, String uname, String pass) {
        this.vname = vname;
        this.nname = nname;
        this.uname = uname;
        this.pass = pass;
    }

    public Contact() {
    }

    public String getVname() {
        return vname;
    }

    public String getNname() {
        return nname;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
