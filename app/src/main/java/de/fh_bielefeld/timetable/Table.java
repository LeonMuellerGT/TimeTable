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
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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

        final Spinner spinner = (Spinner) view.findViewById(R.id.SemAuswahl);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semsester, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        fillList(1);

        montag = (ListView) view.findViewById(R.id.Montag);
        dienstag = (ListView) view.findViewById(R.id.Dienstag);
        mittwoch = (ListView) view.findViewById(R.id.Mittwoch);
        donnerstag = (ListView) view.findViewById(R.id.Donnerstag);
        freitag = (ListView) view.findViewById(R.id.Freitag);

        final calendarAdapter AdapterMontag = new calendarAdapter(getActivity(), dataMontag, "Montag", activity.color);
        final calendarAdapter AdapterDienstag = new calendarAdapter(getActivity(), dataDienstag, "Dienstag",  activity.color);
        final calendarAdapter AdapterMittwoch = new calendarAdapter(getActivity(), dataMittwoch, "Mittwoch",  activity.color);
        final calendarAdapter AdapterDonnerstag = new calendarAdapter(getActivity(), dataDonnerstag, "Donnerstag",  activity.color);
        final calendarAdapter AdapterFreitag = new calendarAdapter(getActivity(), dataFreitag, "Freitag",  activity.color);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                fillList(Integer.parseInt(spinner.getSelectedItem().toString()));

                AdapterMontag.notifyDataSetChanged();
                AdapterDienstag.notifyDataSetChanged();
                AdapterMittwoch.notifyDataSetChanged();
                AdapterDonnerstag.notifyDataSetChanged();
                AdapterFreitag.notifyDataSetChanged();

                Log.d("Changed", "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                fillList(Integer.parseInt(spinner.getSelectedItem().toString()));

                Log.d("Changed", "2");
                AdapterMontag.notifyDataSetChanged();
                AdapterDienstag.notifyDataSetChanged();
                AdapterMittwoch.notifyDataSetChanged();
                AdapterDonnerstag.notifyDataSetChanged();
                AdapterFreitag.notifyDataSetChanged();
            }

        });


        montag.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final calendar t = (calendar) montag.getItemAtPosition(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setMessage(R.string.askDelete);
                alertDialogBuilder.setPositiveButton(R.string.ja,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(t.getDay().equals("Montag")){
                                    dataMontag.remove(position);
                                    AdapterMontag.notifyDataSetChanged();
                                    activity.dataList = mergeLists(dataMontag, dataDienstag, dataMittwoch, dataDonnerstag, dataFreitag);
                                    ((MainActivity)getActivity()).saveCSV();
                                }
                                Toast.makeText(getContext(),R.string.eventDeleted,Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton(R.string.nein,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        dienstag.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final calendar t = (calendar) dienstag.getItemAtPosition(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setMessage(R.string.askDelete);
                alertDialogBuilder.setPositiveButton(R.string.ja,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(t.getDay().equals("Dienstag")){
                                    dataDienstag.remove(position);
                                    AdapterDienstag.notifyDataSetChanged();
                                    activity.dataList = mergeLists(dataMontag, dataDienstag, dataMittwoch, dataDonnerstag, dataFreitag);
                                    ((MainActivity)getActivity()).saveCSV();
                                }
                                Toast.makeText(getContext(),R.string.eventDeleted,Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton(R.string.nein,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        mittwoch.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final calendar t = (calendar) mittwoch.getItemAtPosition(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setMessage(R.string.askDelete);
                alertDialogBuilder.setPositiveButton(R.string.ja,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(t.getDay().equals("Mittwoch")){
                                    dataMittwoch.remove(position);
                                    AdapterMittwoch.notifyDataSetChanged();
                                    activity.dataList = mergeLists(dataMontag, dataDienstag, dataMittwoch, dataDonnerstag, dataFreitag);
                                    ((MainActivity)getActivity()).saveCSV();
                                }
                                Toast.makeText(getContext(),R.string.eventDeleted,Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton(R.string.nein,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        donnerstag.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final calendar t = (calendar) donnerstag.getItemAtPosition(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setMessage(R.string.askDelete);
                alertDialogBuilder.setPositiveButton(R.string.ja,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(t.getDay().equals("Donnerstag")){
                                    dataDonnerstag.remove(position);
                                    AdapterDonnerstag.notifyDataSetChanged();
                                    activity.dataList = mergeLists(dataMontag, dataDienstag, dataMittwoch, dataDonnerstag, dataFreitag);
                                    ((MainActivity)getActivity()).saveCSV();
                                }
                                Toast.makeText(getContext(),R.string.eventDeleted,Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton(R.string.nein,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        freitag.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final calendar t = (calendar) freitag.getItemAtPosition(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setMessage(R.string.askDelete);
                alertDialogBuilder.setPositiveButton(R.string.ja,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(t.getDay().equals("Freitag")){
                                    dataFreitag.remove(position);
                                    AdapterFreitag.notifyDataSetChanged();
                                    activity.dataList = mergeLists(dataMontag, dataDienstag, dataMittwoch, dataDonnerstag, dataFreitag);
                                    ((MainActivity)getActivity()).saveCSV();
                                }
                                Toast.makeText(getContext(),R.string.eventDeleted,Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton(R.string.nein,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        Collections.sort(dataMontag, new Comparator<calendar>() {
            @Override
            public int compare(calendar t1, calendar t2) {
                return t1.getStartT().compareToIgnoreCase(t2.getStartT());
            }
        });

        Collections.sort(dataDienstag, new Comparator<calendar>() {
            @Override
            public int compare(calendar t1, calendar t2) {
                return t1.getStartT().compareToIgnoreCase(t2.getStartT());
            }
        });

        Collections.sort(dataMittwoch, new Comparator<calendar>() {
            @Override
            public int compare(calendar t1, calendar t2) {
                return t1.getStartT().compareToIgnoreCase(t2.getStartT());
            }
        });

        Collections.sort(dataDonnerstag, new Comparator<calendar>() {
            @Override
            public int compare(calendar t1, calendar t2) {
                return t1.getStartT().compareToIgnoreCase(t2.getStartT());
            }
        });

        Collections.sort(dataFreitag, new Comparator<calendar>() {
            @Override
            public int compare(calendar t1, calendar t2) {
                return t1.getStartT().compareToIgnoreCase(t2.getStartT());
            }
        });

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

    public ArrayList<calendar> mergeLists(ArrayList<calendar> mon, ArrayList<calendar> die, ArrayList<calendar> mit, ArrayList<calendar> don, ArrayList<calendar> fre){
        ArrayList<calendar> tmp = new ArrayList<calendar>();

        for(int i = 0; i < mon.size(); i++){
            tmp.add(mon.get(i));
        }

        for(int i = 0; i < die.size(); i++){
            tmp.add(die.get(i));
        }

        for(int i = 0; i < mit.size(); i++){
            tmp.add(mit.get(i));
        }

        for(int i = 0; i < don.size(); i++){
            tmp.add(don.get(i));
        }

        for(int i = 0; i < fre.size(); i++){
            tmp.add(fre.get(i));
        }

        return tmp;
    }

    private void fillList(int sem){
        MainActivity activity = (MainActivity) getActivity();

        dataMontag.clear();
        dataDienstag.clear();
        dataMittwoch.clear();
        dataDonnerstag.clear();
        dataFreitag.clear();

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Montag")){
                if(sem == activity.dataList.get(i).getSem())
                    dataMontag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Dienstag")){
                if(sem == activity.dataList.get(i).getSem())
                    dataDienstag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Mittwoch")){
                if(sem == activity.dataList.get(i).getSem())
                    dataMittwoch.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Donnerstag")){
                if(sem == activity.dataList.get(i).getSem())
                    dataDonnerstag.add(activity.dataList.get(i));
            }
        }

        for(int i = 0; i < activity.dataList.size(); i++){
            if(activity.dataList.get(i).getDay().equals("Freitag")){
                if(sem == activity.dataList.get(i).getSem())
                    dataFreitag.add(activity.dataList.get(i));
            }
        }
    }

}
