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
import android.widget.TextView;

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
    private EditText kuer;

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


        final Spinner semSpinner = (Spinner) view.findViewById(R.id.semSpinner);
        ArrayAdapter<CharSequence> semAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semsester, android.R.layout.simple_spinner_item);
        semAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semSpinner.setAdapter(semAdapter);

        final Spinner studSpinner = (Spinner) view.findViewById(R.id.studSpinner);
        ArrayAdapter<CharSequence> studAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.studien, android.R.layout.simple_spinner_item);
        studAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studSpinner.setAdapter(studAdapter);

        fach = (EditText) view.findViewById(R.id.fachI);
        raum = (EditText) view.findViewById(R.id.raumI);
        doz = (EditText) view.findViewById(R.id.dozI);
        start1 = (EditText) view.findViewById(R.id.startTI1);
        start2 = (EditText) view.findViewById(R.id.startTI2);
        end1 = (EditText) view.findViewById(R.id.endTI1);
        end2 = (EditText) view.findViewById(R.id.endTI2);
        tag = (Spinner) view.findViewById(R.id.days);
        kuer = (EditText) view.findViewById(R.id.kuer);

        Button button = (Button)view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String start = start1.getText().toString() + ":" + start2.getText().toString();
                String end = end1.getText().toString() + ":" + end2.getText().toString();

                Log.d("test button", tag.getSelectedItem().toString());
                calendar c = new calendar(fach.getText().toString(),
                        tag.getSelectedItem().toString() ,
                        start,
                        end,
                        (studSpinner.getSelectedItem().toString()+ " "+semSpinner.getSelectedItem().toString()),
                        raum.getText().toString(),
                        doz.getText().toString(),
                        kuer.getText().toString());

                activity.dataList.add(c);

                fach.setText("Fach", TextView.BufferType.EDITABLE);
                start1.setText("", TextView.BufferType.EDITABLE);
                end1.setText("", TextView.BufferType.EDITABLE);
                start2.setText("", TextView.BufferType.EDITABLE);
                end2.setText("", TextView.BufferType.EDITABLE);
                raum.setText("Raum", TextView.BufferType.EDITABLE);
                doz.setText("Dozent", TextView.BufferType.EDITABLE);
                kuer.setText("Kürzel", TextView.BufferType.EDITABLE);
                tag.setSelection(0);
                studSpinner.setSelection(0);
                semSpinner.setSelection(0);
            }
        });


        return view;//inflater.inflate(R.layout.fragment_input, container, false);
    }

}
