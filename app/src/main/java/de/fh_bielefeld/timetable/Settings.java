package de.fh_bielefeld.timetable;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    Button defButton;

    Button b1,b2,b3;
    LinearLayout t;


    public void ColorChange(View v) {

        b1=(Button)v.findViewById(R.id.button_red);
        b2=(Button)v.findViewById(R.id.button_blue);
        b3=(Button)v.findViewById(R.id.button_green);

        final MainActivity activity = (MainActivity) getActivity();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#ffcc0000");
                Log.d("Farbe: ", "rot");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#ff0099cc");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#ff669900");
            }
        });
    }

    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final MainActivity activity = (MainActivity) getActivity();

        final View view = inflater.inflate(R.layout.fragment_settings, container, false);

        ColorChange(view);

        defButton = (Button)view.findViewById(R.id.button_default);
        defButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DEFAULTTEST","Das ist ein TEST");

                activity.color = Color.parseColor("#cfcfcf");

                activity.killCSV();    //MainActivity Methode aufgerufen
                activity.readCSVData();

                //Toast.makeText(getContext(),"Default wurde geladen! ",Toast.LENGTH_SHORT).show();
            }
        });
        return view;//inflater.inflate(R.layout.fragment_settings, container, false);
    }

}
