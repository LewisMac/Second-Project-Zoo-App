package com.example.user.zooapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/12/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    //DATABASE VERSION
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    private static final String DATABASE_NAME = "zooManager";

    //TABLE NAMES
    private static final String TABLE_ENCLOSURES = "enclosures";
    private static final String TABLE_ANIMALS = "animals";

    //TABLE COLUMN NAMES
    private static final String KEY_ID = "id";
    private static final String KEY_ENCLOSURE_TYPE_ORDINAL = "enclosure_type";

    private static final String KEY_ANIMAL_TYPE_ORDINAL = "animal_type";
    private static final String KEY_ANIMAL_NAME = "animal_name";
    private static final String KEY_ENCLOSURE_ANIMAL_ID = "animal_enclosure_id";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATING TABLES
    @Override
    public void onCreate(SQLiteDatabase db){

//        db.execSQL("DROP TABLE " + TABLE_ENCLOSURES);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);

        String CREATE_ENCLOSURES_TABLE =
                "CREATE TABLE " + TABLE_ENCLOSURES + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_ENCLOSURE_TYPE_ORDINAL + " TEXT )";
        db.execSQL(CREATE_ENCLOSURES_TABLE);

        String CREATE_ANIMAL_TABLE =
                "CREATE TABLE " + TABLE_ANIMALS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_ANIMAL_NAME + " TEXT," + KEY_ANIMAL_TYPE_ORDINAL + " TEXT," + KEY_ENCLOSURE_ANIMAL_ID + " TEXT )";
        db.execSQL(CREATE_ANIMAL_TABLE);
    }

    //UPGRADING TABLES
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //DROPPING OLDER TABLE
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENCLOSURES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);

        onCreate(db);
    }

    public void addEnclosure(Enclosure enclosure){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ENCLOSURE_TYPE_ORDINAL, enclosure.getEnclosureTypeOrdinal());

        //insert row
        db.insert(TABLE_ENCLOSURES, null, values);
        db.close(); //close connection
    }

    public void addAnimal(Animal animal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ANIMAL_TYPE_ORDINAL, animal.getSpeciesTypeOrdinal());
        values.put(KEY_ANIMAL_NAME, animal.getName());
        values.put(KEY_ENCLOSURE_ANIMAL_ID, animal.getEnclosureId());

        //insert row
        db.insert(TABLE_ANIMALS, null, values);
        db.close(); //close connection
    }

    public Enclosure getEnclosure(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ENCLOSURES, new String[] {KEY_ID, KEY_ENCLOSURE_TYPE_ORDINAL}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Enclosure enclosure = getEnclosureFromDBCursor(cursor);
        return enclosure;
    }

    public int updateEnclosure(Enclosure enclosure) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ENCLOSURE_TYPE_ORDINAL, enclosure.getEnclosureType());
        return db.update(TABLE_ENCLOSURES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(enclosure.getID()) });
    }

    public Animal getAnimal(int id){
        SQLiteDatabase db = this.getReadableDatabase();



        Cursor cursor = db.query(TABLE_ANIMALS, new String[] {KEY_ID, KEY_ANIMAL_NAME, KEY_ANIMAL_TYPE_ORDINAL, KEY_ENCLOSURE_ANIMAL_ID}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Animal animal = getAnimalFromDBCursor(cursor);
        return animal;
    }

    public int updateAnimal(Animal animal){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ANIMAL_TYPE_ORDINAL, animal.getSpecies());
        values.put(KEY_ANIMAL_NAME, animal.getName());
        values.put(KEY_ENCLOSURE_ANIMAL_ID, Integer.toString(animal.getEnclosureId()));

        return db.update(TABLE_ANIMALS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(animal.getId()) });
    }

    public List<Enclosure> getAllEnclosures(){

        List<Enclosure> enclosureList = new ArrayList<Enclosure>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ENCLOSURES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Enclosure enclosure = new Enclosure(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)));

                // Adding enclosure to list
                enclosureList.add(enclosure);
            } while (cursor.moveToNext());
        }

        // return enclosure list
        return enclosureList;
    }

    private Enclosure getEnclosureFromDBCursor(Cursor cursor) {

        int idColumnNum = cursor.getColumnIndex(KEY_ID);
        int nameColumnNum = cursor.getColumnIndex(KEY_ENCLOSURE_TYPE_ORDINAL);

        int id = Integer.parseInt(cursor.getString(idColumnNum));
        String enclosureTypeValue = cursor.getString(nameColumnNum);

        Enclosure enclosureType = new Enclosure(id, Integer.valueOf(enclosureTypeValue));

        return enclosureType;
    }

    private Animal getAnimalFromDBCursor(Cursor cursor){
        int idColumnNum = cursor.getColumnIndex(KEY_ID);
        int nameColumnNum = cursor.getColumnIndex(KEY_ANIMAL_NAME);
        int enclosureColumnNum = cursor.getColumnIndex(KEY_ENCLOSURE_ANIMAL_ID);
        int typeColumnName = cursor.getColumnIndex(KEY_ANIMAL_TYPE_ORDINAL);

        int id = Integer.parseInt(cursor.getString(idColumnNum));
        String name = cursor.getString(nameColumnNum);
        int enclosureInt = Integer.parseInt(cursor.getString(enclosureColumnNum));
        int animalType = Integer.parseInt(cursor.getString(typeColumnName));

        Animal animal = new Animal(id, animalType, name, enclosureInt);
        return animal;
    }
}
