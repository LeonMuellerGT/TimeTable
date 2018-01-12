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

import java.util.ArrayList;
import java.util.logging.LoggingMXBean;

import de.fh_bielefeld.timetable.R;
import de.fh_bielefeld.timetable.calendar;

public class calendarAdapter extends ArrayAdapter<calendar> {
    String day;

    Button b1,b2,b3;
    LinearLayout ll;

    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.calendaritem);

        b1=(Button)b1.findViewById(R.id.button_red);
        b2=(Button)b2.findViewById(R.id.button_blue);
        b3=(Button)b3.findViewById(R.id.button_green);

        ll=(LinearLayout)ll.findViewById(R.id.bg);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ll.setBackgroundColor(Color.parseColor("#ffcc0000"));

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ll.setBackgroundColor(Color.parseColor("#ff0099cc"));

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ll.setBackgroundColor(Color.parseColor("#ff669900"));

            }
        });
    }

    private void setContentView(int calendaritem) {
    }

    public calendarAdapter(Context context, ArrayList<calendar> users, String d) {
        super(context, 0, users);
        day = d;
        Log.d("Test", "Tag Adapter: "+d);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("Test", "Adapter intern");

        // Get the data item for this position
        calendar c = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        // Lookup view for data population


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.calendaritem, parent, false);
        }

        Log.d("Log: ", "Tag: "+c.getDay());


        if(c.getDay().equals(day)) {
            LinearLayout t = (LinearLayout) convertView.findViewById(R.id.bg);

            t.setBackgroundColor(Color.parseColor("#cfcfcf"));

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
        }
        // Return the completed view to render on screen
        return convertView;
    }
}