package com.example.user.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/12/2016.
 */
public class MainActivity extends AppCompatActivity {

    Button enclosureButton;
    Button animalButton;
    Button addToEnclosureButton;
    ArrayList<Animal> creaturesToAddToGrid;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final DatabaseHandler db = ((MainApplication) getApplication()).db;

        setContentView(R.layout.main);

        animalButton = (Button) findViewById(R.id.add_animal);
        enclosureButton = (Button) findViewById(R.id.add_enclosure_to_database);
        addToEnclosureButton = (Button) findViewById(R.id.add_animal_to_enclosure);

        animalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAnimal.class);
                startActivity(intent);
            }
        });

        enclosureButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEnclosure.class);
                startActivity(intent);
            }
        });

        addToEnclosureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddAnimalToEnclosure.class);
                startActivity(intent);
            }
        });

        ImageAdapter imageAdapter = new ImageAdapter(this);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(imageAdapter);
        addCreaturesToGridView();
        imageAdapter.addAllAnimalsFromList(creaturesToAddToGrid);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

            }
        });
    }

    public void addCreaturesToGridView(){

        final DatabaseHandler db = ((MainApplication) getApplication()).db;
        creaturesToAddToGrid = new ArrayList<>();
        for (Animal animal : db.getAllAnimals()){
            if (animal != null)
            creaturesToAddToGrid.add(animal);
        }
    }


//        enclosureButton = (Button)findViewById(R.id.add_enclosure_to_database);

//        addToEnclosureButton = (Button)findViewById(R.id.add_animal_to_enclosure);
//
//        enclosureButton.setOnClickListener(new View.OnClickListener() {
//            Enclosure enclosure = new Enclosure(EnclosureType.CAVE);
//
//            public void onClick(View view) {
//                db.addEnclosure(enclosure);
//                Log.d("Button pressed", " add enclosure Pressed");
//            }
//        });
//
//        animalButton.setOnClickListener(new View.OnClickListener() {
//            Animal animal = new Animal(SpeciesType.DRAGON, "Puff");
//            Enclosure enclosure = db.getEnclosure(1);
//
//            public void onClick(View view){
//                db.addAnimal(animal);
//                Log.d("Button pressed", "add animal Pressed");
//                enclosure.addAnimalToEnclosure(animal);
//                db.updateAnimal(animal);
//                System.out.println(animal.getEnclosureId());
//            }
//        });




}
