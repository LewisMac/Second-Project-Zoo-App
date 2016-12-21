package com.example.user.zooapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 21/12/2016.
 */
public class AddAnimalToEnclosure extends AppCompatActivity{


    private Spinner spinnerEnclosure;
    private Spinner spinnerAnimal;
    private Button submitButton;
    private EnclosureType enclosureTypeSelected;
    private String[] arrayOfAnimalInfo;
    private Animal enclosureAnimalSelected;
    private Enclosure enclosureSelected;
    private boolean result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        final DatabaseHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_animal_to_enclosure);

        addItemsOnSpinnerSpecies();
        addItemsOnSpinnerAnimal();

        spinnerEnclosure = (Spinner) findViewById(R.id.spinnerEnclosure);
        spinnerAnimal = (Spinner) findViewById(R.id.spinnerAnimal);
        submitButton = (Button) findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final DatabaseHandler db = ((MainApplication)getApplication()).db;

                String spinnerEnclosureSelected = String.valueOf(spinnerEnclosure.getSelectedItem());
                String spinnerAnimalSelected = String.valueOf(spinnerAnimal.getSelectedItem());

                enclosureTypeSelected = EnclosureType.valueOf(spinnerEnclosureSelected);
                arrayOfAnimalInfo = spinnerAnimalSelected.split(" ");
                String animalName = arrayOfAnimalInfo[0];

                int enclosureOrdinal = enclosureTypeSelected.ordinal();
                enclosureAnimalSelected = db.getAnimalByName(animalName);

                List<Enclosure> enclosures = db.getAllEnclosures();


                for (Enclosure enclosure : enclosures){
                    if (enclosure.getEnclosureType().equals(spinnerEnclosureSelected)){
                        result = true;
                    }
                }

                if (result) {
                    enclosureSelected = db.getEnclosureByType(enclosureOrdinal);
                }
                else{
                    enclosureSelected = new Enclosure(enclosureTypeSelected);
                }

                Context context = getApplicationContext();

                switch (enclosureSelected.addAnimalToEnclosure(enclosureAnimalSelected)){
                    case "That is not possible":
                        Toast toastno = Toast.makeText(context, enclosureSelected.addAnimalToEnclosure(enclosureAnimalSelected), Toast.LENGTH_SHORT);
                        toastno.show();
                        break;
                    case "Animal added":
                        Toast toastyes = Toast.makeText(context, enclosureSelected.addAnimalToEnclosure(enclosureAnimalSelected), Toast.LENGTH_SHORT);
                        toastyes.show();
                        backToMainView();
                        break;
                }
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

    public void addItemsOnSpinnerAnimal() {

        final DatabaseHandler db = ((MainApplication)getApplication()).db;

        spinnerAnimal = (Spinner) findViewById(R.id.spinnerAnimal);
        List<String> list = new ArrayList<>();

        for (Animal animal : db.getAllAnimals()){
            String animalName = animal.getName() + " the " + animal.getSpecies();
            list.add(animalName);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnimal.setAdapter(dataAdapter);
    }


    private void backToMainView() {
        Intent intent = new Intent(AddAnimalToEnclosure.this, MainActivity.class);
        startActivity(intent);
    }
}
