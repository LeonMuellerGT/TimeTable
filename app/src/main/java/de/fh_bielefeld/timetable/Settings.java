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


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    Button defButton;

    Button b1,b2,b3;
    LinearLayout t;


    public void ColorChange() {
        b1=(Button)b1.findViewById(R.id.button_red);
        b2=(Button)b2.findViewById(R.id.button_blue);
        b3=(Button)b3.findViewById(R.id.button_green);

        t=(LinearLayout)t.findViewById(R.id.bg);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setBackgroundColor(Color.parseColor("#ffcc0000"));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setBackgroundColor(Color.parseColor("#ff669900"));
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

        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        defButton = (Button)view.findViewById(R.id.button_default);
        defButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DEFAULTTEST","Das ist ein TEST");

                activity.killCSV();
                activity.readCSVData();

                //Toast.makeText(getContext(),"Default wurde geladen! ",Toast.LENGTH_SHORT).show();
            }
        });
        return view;//inflater.inflate(R.layout.fragment_settings, container, false);
    }

}
