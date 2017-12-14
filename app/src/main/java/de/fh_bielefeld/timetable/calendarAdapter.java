package de.fh_bielefeld.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.fh_bielefeld.timetable.R;
import de.fh_bielefeld.timetable.calendar;

public class calendarAdapter extends ArrayAdapter<calendar> {
    public calendarAdapter(Context context, ArrayList<calendar> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        calendar c = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.calendaritem, parent, false);
        }
        // Lookup view for data population
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
        start.setText(String.valueOf(c.getStartT()));
        end.setText(String.valueOf(c.getEndT()));
        kuer.setText(c.getKuer());

        // Return the completed view to render on screen
        return convertView;
    }
}