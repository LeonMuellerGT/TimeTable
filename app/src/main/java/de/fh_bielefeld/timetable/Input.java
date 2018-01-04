package de.fh_bielefeld.timetable;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class Input extends Fragment {

    private EditText fach;
    private EditText raum;
    private Spinner tag;
    private EditText start1;
    private EditText start2;
    private EditText end1;
    private EditText end2;
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

        Spinner spinner = (Spinner) view.findViewById(R.id.days);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.days, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        fach = (EditText) view.findViewById(R.id.fachI);
        raum = (EditText) view.findViewById(R.id.raumI);
        doz = (EditText) view.findViewById(R.id.dozI);
        start1 = (EditText) view.findViewById(R.id.startTI1);
        start2 = (EditText) view.findViewById(R.id.startTI2);
        end1 = (EditText) view.findViewById(R.id.endTI1);
        end2 = (EditText) view.findViewById(R.id.endTI2);
        tag = (Spinner) view.findViewById(R.id.days);

        Button button = (Button)view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String start = start1.getText().toString() + ":" + start2.getText().toString();
                String end = end1.getText().toString() + ":" + end2.getText().toString();

                Log.d("test button", tag.getSelectedItem().toString());
                calendar c = new calendar(fach.getText().toString(),
                        /**tag.getText().toString()*/ tag.getSelectedItem().toString() ,
                        start,
                        end,
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
