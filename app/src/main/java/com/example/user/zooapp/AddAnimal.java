package com.example.user.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/12/2016.
 */
public class AddAnimal extends AppCompatActivity{
    private EditText nameEditText;
    private Spinner spinnerSpecies;
    private Button submitButton;
    private SpeciesType speciesTypeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        final DatabaseHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_animal);

        nameEditText = (EditText)findViewById(R.id.editName);

        addItemsOnSpinnerSpecies();

        spinnerSpecies = (Spinner) findViewById(R.id.spinnerSpecies);
        submitButton = (Button) findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String spinnerSpeciesSelected = String.valueOf(spinnerSpecies.getSelectedItem());

                speciesTypeSelected = SpeciesType.valueOf(spinnerSpeciesSelected);
                String name = nameEditText.getText().toString();

                Animal newAnimal = new Animal(speciesTypeSelected, name);
                db.addAnimal(newAnimal);
                backToMainView();
            }
        });

    }

    public void addItemsOnSpinnerSpecies() {

        spinnerSpecies = (Spinner) findViewById(R.id.spinnerSpecies);
        List<String> list = new ArrayList<>();
        for (SpeciesType species : SpeciesType.values()){
            list.add(species.toString());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpecies.setAdapter(dataAdapter);
    }

    private void backToMainView() {
        Intent intent = new Intent(AddAnimal.this, MainActivity.class);
        startActivity(intent);
    }
}
