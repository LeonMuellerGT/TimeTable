package de.fh_bielefeld.timetable;

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getStartT() {
        return startT;
    }

    public void setStartT(double startT) {
        this.startT = startT;
    }

    public double getEndT() {
        return endT;
    }

    public void setEndT(double endT) {
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

    public calendar(String name, int day, double startT, double endT, String art, String raum, String doz, String kuer) {
        this.name = name;
        this.day = day;
        this.startT = startT;
        this.endT = endT;
        this.art = art;
        this.raum = raum;
        this.doz = doz;
        this.kuer = kuer;
    }

	private String name = null;
	private int day = 0;
	private double startT = 0.0;
	private double endT = 0.0;
	private String art = null;
	private String raum = null;
	private String doz = null;
	private String kuer = null;
}
