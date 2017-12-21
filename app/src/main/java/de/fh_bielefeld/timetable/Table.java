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
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Table extends Fragment {

    ListView montag;
    ListView dienstag;
    ListView mittwoch;
    ListView donnerstag;
    ListView freitag;

    public Table() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_table, container, false);

        final MainActivity activity = (MainActivity) getActivity();

        ArrayList<calendar> dataMontag = new ArrayList<calendar>();
        ArrayList<calendar> dataDienstag = new ArrayList<calendar>();
        ArrayList<calendar> dataMittwoch = new ArrayList<calendar>();
        ArrayList<calendar> dataDonnerstag = new ArrayList<calendar>();
        ArrayList<calendar> dataFreitag = new ArrayList<calendar>();

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay() == 1){
                dataMontag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay() == 2){
                dataDienstag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay() == 3){
                dataMittwoch.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay() == 4){
                dataDonnerstag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay() == 5){
                dataFreitag.add(activity.dataList.get(i));
            }
        }

        montag = (ListView) view.findViewById(R.id.Montag);
        dienstag = (ListView) view.findViewById(R.id.Dienstag);
        mittwoch = (ListView) view.findViewById(R.id.Mittwoch);
        donnerstag = (ListView) view.findViewById(R.id.Donnerstag);
        freitag = (ListView) view.findViewById(R.id.Freitag);

        final calendarAdapter AdapterMontag = new calendarAdapter(getActivity(), dataMontag, 1);
        final calendarAdapter AdapterDienstag = new calendarAdapter(getActivity(), dataDienstag, 2);
        final calendarAdapter AdapterMittwoch = new calendarAdapter(getActivity(), dataMittwoch, 3);
        final calendarAdapter AdapterDonnerstag = new calendarAdapter(getActivity(), dataDonnerstag, 4);
        final calendarAdapter AdapterFreitag = new calendarAdapter(getActivity(), dataFreitag, 5);

        montag.setAdapter(AdapterMontag);
        dienstag.setAdapter(AdapterDienstag);
        mittwoch.setAdapter(AdapterMittwoch);
        donnerstag.setAdapter(AdapterDonnerstag);
        freitag.setAdapter(AdapterFreitag);


        TabHost host = (TabHost)view.findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Montag");
        spec.setContent(R.id.Montag);
        spec.setIndicator("Montag");
        host.addTab(spec);

        //Tab 2
        //spec = host.newTabSpec("Tab Two");
        spec = host.newTabSpec("Dienstag");
        spec.setContent(R.id.Dienstag);
        spec.setIndicator("Dienstag");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Mittwoch");
        spec.setContent(R.id.Mittwoch);
        spec.setIndicator("Mittwoch");
        host.addTab(spec);

        spec = host.newTabSpec("Donnerstag");
        spec.setContent(R.id.Donnerstag);
        spec.setIndicator("Donnerstag");
        host.addTab(spec);

        spec = host.newTabSpec("Freitag");
        spec.setContent(R.id.Freitag);
        spec.setIndicator("Freitag");
        host.addTab(spec);



        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //myStringArray1.add("something");
                //Adapter.add("Clicked");//notifyDataSetChanged();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });

        return view;
    }

}
