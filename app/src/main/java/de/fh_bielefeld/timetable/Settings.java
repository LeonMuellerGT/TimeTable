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
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    Button defButton;

    Button b1,b2,b3,b4,b5,b6;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12;
    LinearLayout t;


    public void ColorChange(View v) {

        b1=(Button)v.findViewById(R.id.button_pink);
        b2=(Button)v.findViewById(R.id.button_blue);
        b3=(Button)v.findViewById(R.id.button_green);
        b4=(Button)v.findViewById(R.id.button_orange);
        b5=(Button)v.findViewById(R.id.button_violet);
        b6=(Button)v.findViewById(R.id.button_gray);
        /*tv1=(TextView)v.findViewById(R.id.textView2);
        tv2=(TextView)v.findViewById(R.id.fach);
        tv3=(TextView)v.findViewById(R.id.textView8);
        tv4=(TextView)v.findViewById(R.id.raum);
        tv5=(TextView)v.findViewById(R.id.textView11);
        tv6=(TextView)v.findViewById(R.id.doz);
        tv7=(TextView)v.findViewById(R.id.textView13);
        tv8=(TextView)v.findViewById(R.id.kuer);
        tv9=(TextView)v.findViewById(R.id.textView4);
        tv10=(TextView)v.findViewById(R.id.startT);
        tv11=(TextView)v.findViewById(R.id.textView6);
        tv12=(TextView)v.findViewById(R.id.endT);*/


        final MainActivity activity = (MainActivity) getActivity();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#c50084");
                Log.d("Farbe: ", "pink");

                //tv1.setTextColor(Color.parseColor("#009bbb"));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#009bbb");
                Log.d("Farbe: ", "blau");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#a2ad00");
                Log.d("Farbe: ", "gruen");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#e98300");
                Log.d("Farbe: ", "orange");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#722ea5");
                Log.d("Farbe: ", "lila");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.color = Color.parseColor("#cfcfcf");
                Log.d("Farbe: ", "grau");
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
