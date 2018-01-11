package de.fh_bielefeld.timetable;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;

import de.fh_bielefeld.timetable.calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<calendar> dataList = new ArrayList<calendar>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        readCSVData();

        Log.d("Test", dataList.get(0).getDay());



        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //listItems.add("Clicked : ");
                //adapter.add("Clicked");//notifyDataSetChanged();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment = new Table();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }




    private void readCSVData() {
        File tempF = new File(getFilesDir().toString(),"csvTable.csv");
        BufferedReader reader = null;
        if(tempF.exists())
        {
            FileInputStream fis = null;
            try {
                fis = openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                reader = br;
                Toast.makeText(this,"Lade Intern! ",Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
        else{

            InputStream is = getResources().openRawResource(R.raw.ini_ws17);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8"))
            );
            reader = br;
            Toast.makeText(this,"Lade Default!",Toast.LENGTH_LONG).show();
        }


        String line = "";
        try { //Step over headers
            reader.readLine();


            while((line = reader.readLine()) != null){
                // Split by ';'
                String[] tokens = line.split(";");

                //Read data
                //calendar(String name, int day, double startT, double endT, String art, String raum, String doz, String kuer) {
                calendar sample = new calendar(tokens[1], tokens[2], tokens[3], tokens[4], tokens[0], tokens[5], tokens[6], tokens[7]);

                dataList.add(sample);

                Log.d("MyActivity", "Just created: "+sample);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity","Error fehler beim einlesen"+line,e);
            e.printStackTrace();
        }
        saveCSV();
    }

    private static final String FILE_NAME = "csvTable.csv";

    private void saveCSV() {
        String FILE_HEADER = "Semester;Name;Tag;Beginn;Ende;Raum;Dozent;Kürzel";
        String fertig = "";
        fertig = fertig+FILE_HEADER;

        for(int i = 0; i < dataList.size();i++) {
            fertig = fertig+"\n";
            fertig = fertig+dataList.get(i).getArt();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getName();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getDay();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getStartT();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getEndT();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getRaum();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getDoz();
            fertig = fertig+";";
            fertig = fertig+dataList.get(i).getKuer();

            Log.d("Gibmir", dataList.get(0).getDoz());
        }
        System.out.println("Habejetzt: \n" + fertig);

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(fertig.getBytes());
            //Toast.makeText(this,"Saved to "+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Fragment fragment;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            fragment = new Settings();

            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment = new ListFragment();

        int id = item.getItemId();

        if (id == R.id.nav_table) {
            fragment = new Table();
        } else if (id == R.id.nav_input) {
            fragment = new Input();
        }

        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //calendar(String name, int day, double startT, double endT, String art, String raum, String doz, String kuer)
    public void createElement(String Name, String day, String startT, String endT, String art, String raum, String doz, String kuer){
        calendar c = new calendar(Name, day, startT, endT, art, raum, doz, kuer);
        dataList.add(c);
    }

}
