package de.fh_bielefeld.timetable;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class Input extends Fragment {

    private EditText fach;
    private EditText raum;
    private EditText tag;
    private EditText start;
    private EditText end;
    private EditText doz;

    public Input() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final MainActivity activity = (MainActivity) getActivity();

        View view = inflater.inflate(R.layout.fragment_input, container, false);

        Log.d("test","test");

        fach = (EditText) view.findViewById(R.id.fachI);
        raum = (EditText) view.findViewById(R.id.raumI);
        doz = (EditText) view.findViewById(R.id.dozI);
        start = (EditText) view.findViewById(R.id.startTI);
        end = (EditText) view.findViewById(R.id.endTI);
        tag = (EditText) view.findViewById(R.id.dayI);


        Button button = (Button)view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar c = new calendar(fach.getText().toString(),
                        Integer.valueOf(tag.getText().toString()),
                        Double.valueOf(start.getText().toString()),
                        Double.valueOf(end.getText().toString()),
                        "vorlesung",
                        raum.getText().toString(),
                        doz.getText().toString(),
                        "kuer");

                activity.dataList.add(c);
            }
        });


        return view;//inflater.inflate(R.layout.fragment_input, container, false);
    }

}
