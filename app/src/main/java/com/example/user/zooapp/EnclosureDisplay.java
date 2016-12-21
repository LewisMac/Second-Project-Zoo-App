package com.example.user.zooapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by user on 21/12/2016.
 */
public class EnclosureDisplay extends AppCompatActivity {

    ArrayList enclosuresToAddToGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        final DatabaseHandler db = ((MainApplication) getApplication()).db;

        setContentView(R.layout.all_enclosures);

        ImageAdapter imageAdapter = new ImageAdapter(this);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(imageAdapter);
        addEnclosuresToGridView();
        imageAdapter.addAllEnclosuresFromList(enclosuresToAddToGrid);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

            }
        });
    }

    public void addEnclosuresToGridView(){

        final DatabaseHandler db = ((MainApplication) getApplication()).db;

        enclosuresToAddToGrid = new ArrayList<>();
        for (Enclosure enclosure : db.getAllEnclosures()){
            if (enclosure != null)
                enclosuresToAddToGrid.add(enclosure);
        }
    }

}
