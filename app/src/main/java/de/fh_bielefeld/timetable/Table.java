package de.fh_bielefeld.timetable;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

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

    ArrayList<calendar> dataMontag = new ArrayList<calendar>();
    ArrayList<calendar> dataDienstag = new ArrayList<calendar>();
    ArrayList<calendar> dataMittwoch = new ArrayList<calendar>();
    ArrayList<calendar> dataDonnerstag = new ArrayList<calendar>();
    ArrayList<calendar> dataFreitag = new ArrayList<calendar>();

    public Table() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_table, container, false);

        final MainActivity activity = (MainActivity) getActivity();



        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Montag")){
                dataMontag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Dienstag")){
                dataDienstag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Mittwoch")){
                dataMittwoch.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Donnerstag")){
                dataDonnerstag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Freitag")){
                dataFreitag.add(activity.dataList.get(i));
            }
        }

        montag = (ListView) view.findViewById(R.id.Montag);

        final calendarAdapter AdapterMontag = new calendarAdapter(getActivity(), dataMontag, "Montag");

        montag.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //String item = (String) montag.getItemAtPosition(position);
                final calendar t = (calendar) montag.getItemAtPosition(position);
                //Toast.makeText(getContext(),"You selected : " + t.getDay() + t.getName(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setMessage("Veranstaltung löschen?");
                alertDialogBuilder.setPositiveButton("Ja",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(t.getDay().equals("Montag")){
                                    dataMontag.remove(position);
                                    AdapterMontag.notifyDataSetChanged();
                                }
                                Toast.makeText(getContext(),"You clicked yes button |"+position+t.getDay(),Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton("Nein",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

        });

        dienstag = (ListView) view.findViewById(R.id.Dienstag);
        mittwoch = (ListView) view.findViewById(R.id.Mittwoch);
        donnerstag = (ListView) view.findViewById(R.id.Donnerstag);
        freitag = (ListView) view.findViewById(R.id.Freitag);

        Log.d("Test", "Size: "+activity.dataList.size());


        final calendarAdapter AdapterDienstag = new calendarAdapter(getActivity(), dataDienstag, "Dienstag");
        final calendarAdapter AdapterMittwoch = new calendarAdapter(getActivity(), dataMittwoch, "Mittwoch");
        final calendarAdapter AdapterDonnerstag = new calendarAdapter(getActivity(), dataDonnerstag, "Donnerstag");
        final calendarAdapter AdapterFreitag = new calendarAdapter(getActivity(), dataFreitag, "Freitag");

        Log.d("Test", "Test2");

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

        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageSelected(int position) {
                        getActionBar().setSelectedNavigationItem(position);
                    }

                });
        actionBar.newTab()
                .setTabListener(new ActionBar.TabListener(){
                    public void onTabSelected(ActionBar.Tab tab,
                                              FragmentTransaction ft){
                        mViewPager.setCurrentItem(tab.getPosition());
                    }
                });

    }


}
