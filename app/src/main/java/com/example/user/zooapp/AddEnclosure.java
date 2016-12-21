package com.example.user.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 21/12/2016.
 */
public class AddEnclosure extends AppCompatActivity{

    private Spinner spinnerEnclosure;
    private Button submitButton;
    private EnclosureType enclosureTypeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        final DatabaseHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_enclosure);

        addItemsOnSpinnerSpecies();

        spinnerEnclosure = (Spinner) findViewById(R.id.spinnerEnclosure);
        submitButton = (Button) findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String spinnerEnclosureSelected = String.valueOf(spinnerEnclosure.getSelectedItem());

                enclosureTypeSelected = EnclosureType.valueOf(spinnerEnclosureSelected);

                Enclosure newEnclosure = new Enclosure(enclosureTypeSelected);
                db.addEnclosure(newEnclosure);
                backToMainView();
            }
        });

    }

    public void addItemsOnSpinnerSpecies() {

        spinnerEnclosure = (Spinner) findViewById(R.id.spinnerEnclosure);
        List<String> list = new ArrayList<>();
        for (EnclosureType enclosureType : EnclosureType.values()){
            list.add(enclosureType.toString());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEnclosure.setAdapter(dataAdapter);
    }

    private void backToMainView() {
        Intent intent = new Intent(AddEnclosure.this, MainActivity.class);
        startActivity(intent);
    }
}
