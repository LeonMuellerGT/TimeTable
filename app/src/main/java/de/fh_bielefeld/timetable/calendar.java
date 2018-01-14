package de.fh_bielefeld.timetable;

import android.util.Log;

import java.util.Date;

/**
 * Created by Leon on 30.11.2017.
 */

public class calendar {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartT() {
        return startT;
    }

    public void setStartT(String startT) {
        this.startT = startT;
    }

    public String getEndT() {
        return endT;
    }

    public void setEndT(String endT) {
        this.endT = endT;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public String getDoz() {
        return doz;
    }

    public void setDoz(String doz) {
        this.doz = doz;
    }

    public String getKuer() {
        return kuer;
    }

    public void setKuer(String kuer) {
        this.kuer = kuer;
    }

    public calendar(String name, String day, String startT, String endT, String art, String raum, String doz, String kuer) {
        this.name = name;
        this.day = day;
        this.startT = startT;
        this.endT = endT;
        this.art = art;
        this.raum = raum;
        this.doz = doz;
        this.kuer = kuer;
        String[] tmp = art.split(" ");
        this.sem = Integer.getInteger(tmp[1]);

        Log.d("sem", art);
    }

	private String name = null;
	private String day = null;
	private String startT = null;
	private String endT = null;
	private String art = null;
	private String raum = null;
	private String doz = null;
	private String kuer = null;
    private int sem = 0;

}
