package de.fh_bielefeld.timetable;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Button;
import de.fh_bielefeld.timetable.Settings;

import java.util.ArrayList;
import java.util.logging.LoggingMXBean;

import de.fh_bielefeld.timetable.R;
import de.fh_bielefeld.timetable.calendar;

public class calendarAdapter extends ArrayAdapter<calendar> {
    String day;
    int color;
    MainActivity m;


    public calendarAdapter(Context context, ArrayList<calendar> users, String d, int c, MainActivity main) {
        super(context, 0, users);
        day = d;
        color = c;
        m = main;
        Log.d("Test", "Tag Adapter: "+d);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("Test", "Adapter intern");

        // Get the data item for this position
        calendar c = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        // Lookup view for data population

        int sem = c.getSem();

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.calendaritem, parent, false);
        }

        Log.d("Sem", ""+m.sem);
        Log.d("Semester", ""+sem);



        if (m.sem == sem) {
            Log.d("Semester", "true");
            if (c.getDay().equals(day)) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.calendaritem, parent, false);
                LinearLayout t = (LinearLayout) convertView.findViewById(R.id.bg);

                if (c.getColor() != 0) {
                    t.setBackgroundColor(c.getColor());
                } else {
                    t.setBackgroundColor(color);
                }

                TextView fach = (TextView) convertView.findViewById(R.id.fach);
                TextView raum = (TextView) convertView.findViewById(R.id.raum);
                TextView doz = (TextView) convertView.findViewById(R.id.doz);
                TextView start = (TextView) convertView.findViewById(R.id.startT);
                TextView end = (TextView) convertView.findViewById(R.id.endT);
                TextView kuer = (TextView) convertView.findViewById(R.id.kuer);
                // Populate the data into the template view using the data object
                fach.setText(c.getName());
                raum.setText(c.getRaum());
                doz.setText(c.getDoz());
                start.setText(c.getStartT());
                end.setText(c.getEndT());
                kuer.setText(c.getKuer());
            } else{
                //LinearLayout l = (LinearLayout) convertView.findViewById(R.id.bg);
                //ViewGroup.LayoutParams p = l.getLayoutParams();
                //p.height = 0;
                //l.setLayoutParams(p);
                //l.setVisibility(View.GONE);
              //  l.setBackgroundColor( Color.parseColor("#7b7b7b"));
                //convertView = LayoutInflater.from(getContext()).inflate(R.layout.nulllayout, parent, false);
                //l.setVisibility(View.GONE);
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.nulllayout, null);
            }

        } else{
            //LinearLayout l = (LinearLayout) convertView.findViewById(R.id.bg);
            //ViewGroup.LayoutParams p = l.getLayoutParams();
            //p.height = 0;
            //l.setLayoutParams(p);
            //l.setBackgroundColor( Color.parseColor("#7b7b7b"));

            //l.setVisibility(View.GONE);

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nulllayout, null);

            //convertView.setVisibility(View.GONE);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.nulllayout, parent, false);
        }


        // Return the completed view to render on screen
        return convertView;
    }
}