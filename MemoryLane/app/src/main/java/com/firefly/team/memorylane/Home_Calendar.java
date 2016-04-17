package com.firefly.team.memorylane;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//import android.widget.CalendarView;

public class Home_Calendar extends AppCompatActivity implements  CalendarView.OnDateChangeListener {

    // Array of options


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CalendarView cw = (CalendarView)findViewById(R.id.calendarView);
        cw.setOnDateChangeListener(Home_Calendar.this);

        populateListView();
        registerClickCallBack();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void populateListView()
    {
        // Create list
        String [] myItems = {"Blue","Green","Purple","Red"};

        // Adapter Build
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.da_item,myItems);

        //Configure

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }
    private void registerClickCallBack()
    {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent , View viewClicked, int position, long id){
                TextView textView = (TextView) viewClicked;
                String message = "You Clicked #" + (position+1) + ", which is string " + textView.getText().toString();
                Toast.makeText(Home_Calendar.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

        Toast.makeText(Home_Calendar.this,year + " " + month + " " + dayOfMonth,Toast.LENGTH_SHORT).show();
    }
}
