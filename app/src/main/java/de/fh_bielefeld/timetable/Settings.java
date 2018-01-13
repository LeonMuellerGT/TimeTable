package de.fh_bielefeld.timetable;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

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

        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

}
