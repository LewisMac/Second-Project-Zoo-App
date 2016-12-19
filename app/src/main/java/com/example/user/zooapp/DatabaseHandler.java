package com.example.user.zooapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

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
    private static final String KEY_ENCLOSURE_TYPE_ORDINAL = "enclosureType";

    private static final String KEY_ANIMAL_TYPE_ORDINAL = "animalType";
    private static final String KEY_ANIMAL_NAME = "animalName";
    private static final String KEY_ENCLOSURE_ANIMAL_ID = "animalEnclosureId";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATING TABLES
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_ENCLOSURES_TABLE =
                "CREATE TABLE" + TABLE_ENCLOSURES + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_ENCLOSURE_TYPE_ORDINAL + "TEXT," + ")";
        db.execSQL(CREATE_ENCLOSURES_TABLE);

        String CREATE_ANIMAL_TABLE =
                "CREATE TABLE" + TABLE_ANIMALS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_ANIMAL_NAME + "TEXT," + KEY_ANIMAL_TYPE_ORDINAL + "TEXT" + KEY_ENCLOSURE_ANIMAL_ID + "TEXT" + ")";
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
        db.insert(TABLE_ENCLOSURES, null, values);
        db.close(); //close connection
    }

    public Enclosure getEnclosure(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ENCLOSURES, new String[] {KEY_ID, KEY_ENCLOSURE_TYPE_ORDINAL}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Enclosure enclosure = new Enclosure(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)));
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
        Cursor cursor = db.query(TABLE_ANIMALS, new String[] {KEY_ID, KEY_ANIMAL_NAME, KEY_ANIMAL_TYPE_ORDINAL}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Animal animal = new Animal(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), cursor.getString(2), Integer.parseInt(cursor.getString(1)));
        return animal;
    }

    public int updateAnimal(Animal animal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ENCLOSURE_TYPE_ORDINAL, animal.getSpecies());
        return db.update(TABLE_ENCLOSURES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(animal.getId()) });
    }

}
