package de.fh_bielefeld.timetable;


import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Table extends Fragment {

    ListView l;
    //calendar(String name, int day, double startT, double endT, String art, String raum, String doz, String kuer)

    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> day = new ArrayList<String>();
    ArrayList<String> startT = new ArrayList<String>();
    ArrayList<String> endT = new ArrayList<String>();
    ArrayList<String> art = new ArrayList<String>();
    ArrayList<String> raum = new ArrayList<String>();
    ArrayList<String> doz = new ArrayList<String>();
    ArrayList<String> kuer = new ArrayList<String>();


    public Table() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);

        //myStringArray1.add("something");
        l = (ListView) view.findViewById(R.id.listview);

        final MainActivity activity = (MainActivity) getActivity();

        //calendar(String name, int day, double startT, double endT, String art, String raum, String doz, String kuer)

        for(int i = 0; i < activity.dataList.size(); i++) {
            name.add(activity.dataList.get(i).getName());
            day.add(String.valueOf(activity.dataList.get(i).getDay()));
            startT.add(String.valueOf(activity.dataList.get(i).getStartT()));
            endT.add(String.valueOf(activity.dataList.get(i).getEndT()));
            art.add(String.valueOf(activity.dataList.get(i).getArt()));
            raum.add(activity.dataList.get(i).getRaum());
            doz.add(activity.dataList.get(i).getDoz());
            kuer.add(activity.dataList.get(i).getKuer());
        }

        final ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(getActivity(), R.layout.calendaritem, R.id.fach, name );
        l.setAdapter(nameAdapter);
        //l.addView();

        for( int j = 0; j < l.getCount(); j++){
            View tmp = l.getChildAt(j);

            tmp.getId();

            //TextView f = tmp.findViewById(R.id.fach);
            //f.setText(name.get(j));

            //TextView r = tmp.findViewById(R.id.raum);
            //r.setText(raum.get(j));
        }

        //View test;

        //test.findViewById(R.layout.calendaritem);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //myStringArray1.add("something");
                nameAdapter.add("Clicked");//notifyDataSetChanged();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });

        return view;
    }

}
