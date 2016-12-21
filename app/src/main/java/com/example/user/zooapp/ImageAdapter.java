package com.example.user.zooapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/12/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private ArrayList<Integer> mThumbIds = new ArrayList<Integer>();
    private ArrayList<String> stringArrayList = new ArrayList<>();

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_items, null);
            imageView = (ImageView) grid.findViewById(R.id.gridimage);
            textView = (TextView) grid.findViewById(R.id.gridtext);
            imageView.setImageResource(mThumbIds.get(position));
            textView.setText(stringArrayList.get(position));
        } else {
            grid = (View) convertView;
        }
        return grid;
    }

    public void addAllAnimalsFromList(ArrayList<Animal> animalsToAddToGrid){
        for (Animal animal : animalsToAddToGrid){
            switch (animal.getSpecies()){
                case "CENTAUR":
                    mThumbIds.add(R.drawable.centaur);
                    stringArrayList.add(animal.getName());
                    break;
                case "DRAGON":
                    mThumbIds.add(R.drawable.dragon);
                    stringArrayList.add(animal.getName());
                    break;
                case "GNOME":
                    mThumbIds.add(R.drawable.gnome);
                    stringArrayList.add(animal.getName());
                    break;
                case "GRIFFIN":
                    mThumbIds.add(R.drawable.griffin);
                    stringArrayList.add(animal.getName());
                    break;
                case "HIPPOCAMPUS":
                    mThumbIds.add(R.drawable.hippocampus);
                    stringArrayList.add(animal.getName());
                    break;
                case "HIPPOGRIFF":
                    mThumbIds.add(R.drawable.hippogriff);
                    stringArrayList.add(animal.getName());
                    break;
                case "LEPRECHAUN":
                    mThumbIds.add(R.drawable.leprechaun);
                    stringArrayList.add(animal.getName());
                    break;
                case "SEAHORSE":
                    mThumbIds.add(R.drawable.seahorse);
                    stringArrayList.add(animal.getName());
                    break;
                case "SELKIE":
                    mThumbIds.add(R.drawable.selkie);
                    stringArrayList.add(animal.getName());
                    break;
                case "UNICORN":
                    mThumbIds.add(R.drawable.unicorn);
                    stringArrayList.add(animal.getName());
                    break;
                case "WEREWOLF":
                    mThumbIds.add(R.drawable.werewolf);
                    stringArrayList.add(animal.getName());
                    break;
                case "YETI":
                    mThumbIds.add(R.drawable.yeti);
                    stringArrayList.add(animal.getName());
                    break;

            }
        }
    }

    public void addAllEnclosuresFromList(ArrayList<Enclosure> enclosureArrayList){
        for (Enclosure enclosure : enclosureArrayList){
            switch (enclosure.getEnclosureType()){
                case "PADDOCK":
                    mThumbIds.add(R.drawable.paddock);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
                case "AQUARIUM":
                    mThumbIds.add(R.drawable.aquarium);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
                case "AVIARY":
                    mThumbIds.add(R.drawable.aviary);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
                case "CAGE":
                    mThumbIds.add(R.drawable.cage);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
                case "CAVE":
                    mThumbIds.add(R.drawable.cave);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
                case "GHETTO":
                    mThumbIds.add(R.drawable.ghetto);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
                case "ARCTIC":
                    mThumbIds.add(R.drawable.mountain);
                    stringArrayList.add(enclosure.getEnclosureType());
                    break;
            }
        }
    }
}
