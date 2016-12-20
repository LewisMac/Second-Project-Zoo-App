package com.example.user.zooapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 16/12/2016.
 */
public class MainActivity extends AppCompatActivity {

    Button enclosureButton;
    Button animalButton;
    Button addToEnclosureButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final DatabaseHandler db = ((MainApplication) getApplication()).db;

        setContentView(R.layout.main);



        enclosureButton = (Button)findViewById(R.id.add_enclosure_to_database);
        animalButton = (Button)findViewById(R.id.add_animal);
        addToEnclosureButton = (Button)findViewById(R.id.add_animal_to_enclosure);

        enclosureButton.setOnClickListener(new View.OnClickListener() {
            Enclosure enclosure = new Enclosure(EnclosureType.CAVE);

            public void onClick(View view) {
                db.addEnclosure(enclosure);
                Log.d("Button pressed", " add enclosure Pressed");
            }
        });

        animalButton.setOnClickListener(new View.OnClickListener() {
            Animal animal = new Animal(SpeciesType.DRAGON, "Puff");
            Enclosure enclosure = db.getEnclosure(1);

            public void onClick(View view){
                db.addAnimal(animal);
                Log.d("Button pressed", "add animal Pressed");
                enclosure.addAnimalToEnclosure(animal);
                db.updateAnimal(animal);
                System.out.println(animal.getEnclosureId());
            }
        });



    }
}
