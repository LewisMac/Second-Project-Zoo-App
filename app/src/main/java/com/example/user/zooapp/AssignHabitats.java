package com.example.user.zooapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 17/12/2016.
 */
public class AssignHabitats {

    private Map<SpeciesType, List<EnclosureType>> enclosuresForHIPPOCAMPUS;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForSELKIE;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForSEAHORSE;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForGRIFFIN;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForHIPPOGRIFF;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForYETI;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForDRAGON;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForUNICORN;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForWEREWOLF;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForGNOME;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForLEPRECHAUN;
    private Map<SpeciesType, List<EnclosureType>> enclosuresForCENTAUR;

    private List<EnclosureType> enclosureHIPPOCAMPUS;
    private List<EnclosureType> enclosureSELKIE;
    private List<EnclosureType> enclosureSEAHORSE;
    private List<EnclosureType> enclosureGRIFFIN;
    private List<EnclosureType> enclosureHIPPOGRIFF;
    private List<EnclosureType> enclosureYETI;
    private List<EnclosureType> enclosureDRAGON;
    private List<EnclosureType> enclosureUNICORN;
    private List<EnclosureType> enclosureWEREWOLF;
    private List<EnclosureType> enclosureGNOME;
    private List<EnclosureType> enclosureLEPRECHAUN;
    private List<EnclosureType> enclosureCENTAUR;

    private ArrayList<Map<SpeciesType, List<EnclosureType>>> allHabitatInformation;

    public AssignHabitats(){
        habitatCompatBuilder();
    }

    public boolean animalCanLiveInEnclosureType(SpeciesType species, String enclosure){

        boolean message = false;

        for (Map<SpeciesType, List<EnclosureType>> map : allHabitatInformation){

            if (map.get(species) != null) {
                List<EnclosureType> enclosureTypeList = map.get(species);

                for (EnclosureType enclosureType : enclosureTypeList){
//                    System.out.println(enclosureType);
                    if (enclosureType.toString().equals(enclosure)) {
                    message = true;
                    }
                }
            }
        }
        return message;
    }

        public void habitatCompatBuilder(){

        enclosureHIPPOCAMPUS = new ArrayList<>();
        enclosureSELKIE = new ArrayList<>();
        enclosureSEAHORSE = new ArrayList<>();
        enclosureGRIFFIN = new ArrayList<>();
        enclosureHIPPOGRIFF = new ArrayList<>();
        enclosureYETI = new ArrayList<>();
        enclosureDRAGON = new ArrayList<>();
        enclosureUNICORN = new ArrayList<>();
        enclosureWEREWOLF = new ArrayList<>();
        enclosureGNOME = new ArrayList<>();
        enclosureLEPRECHAUN = new ArrayList<>();
        enclosureCENTAUR = new ArrayList<>();

        enclosureHIPPOCAMPUS.add(EnclosureType.AQUARIUM);
        enclosureSELKIE.add(EnclosureType.AQUARIUM);
        enclosureSEAHORSE.add(EnclosureType.AQUARIUM);
        enclosureGNOME.add(EnclosureType.AQUARIUM);
        enclosureGNOME.add(EnclosureType.GHETTO);
        enclosureGRIFFIN.add(EnclosureType.AVIARY);
        enclosureHIPPOGRIFF.add(EnclosureType.AVIARY);
        enclosureYETI.add(EnclosureType.ARCTIC);
        enclosureYETI.add(EnclosureType.CAVE);
        enclosureDRAGON.add(EnclosureType.CAVE);
        enclosureDRAGON.add(EnclosureType.CAGE);
        enclosureUNICORN.add(EnclosureType.PADDOCK);
        enclosureCENTAUR.add(EnclosureType.PADDOCK);
        enclosureWEREWOLF.add(EnclosureType.CAGE);
        enclosureLEPRECHAUN.add(EnclosureType.CAVE);
        enclosureLEPRECHAUN.add(EnclosureType.GHETTO);

        enclosuresForHIPPOCAMPUS = new HashMap<>();
        enclosuresForSELKIE = new HashMap<>();
        enclosuresForSEAHORSE = new HashMap<>();
        enclosuresForGRIFFIN = new HashMap<>();
        enclosuresForHIPPOGRIFF = new HashMap<>();
        enclosuresForYETI = new HashMap<>();
        enclosuresForDRAGON = new HashMap<>();
        enclosuresForUNICORN = new HashMap<>();
        enclosuresForWEREWOLF = new HashMap<>();
        enclosuresForGNOME = new HashMap<>();
        enclosuresForLEPRECHAUN = new HashMap<>();
        enclosuresForCENTAUR = new HashMap<>();

        enclosuresForHIPPOCAMPUS.put(SpeciesType.HIPPOCAMPUS, enclosureHIPPOCAMPUS);
        enclosuresForSELKIE.put(SpeciesType.SELKIE, enclosureSELKIE);
        enclosuresForSEAHORSE.put(SpeciesType.SEAHORSE, enclosureSEAHORSE);
        enclosuresForGRIFFIN.put(SpeciesType.GRIFFIN, enclosureGRIFFIN);
        enclosuresForHIPPOGRIFF.put(SpeciesType.HIPPOGRIFF, enclosureHIPPOGRIFF);
        enclosuresForYETI.put(SpeciesType.YETI, enclosureYETI);
        enclosuresForDRAGON.put(SpeciesType.DRAGON, enclosureDRAGON);
        enclosuresForUNICORN.put(SpeciesType.UNICORN, enclosureUNICORN);
        enclosuresForWEREWOLF.put(SpeciesType.WEREWOLF, enclosureWEREWOLF);
        enclosuresForGNOME.put(SpeciesType.GNOME, enclosureGNOME);
        enclosuresForLEPRECHAUN.put(SpeciesType.LEPRECHAUN, enclosureLEPRECHAUN);
        enclosuresForCENTAUR.put(SpeciesType.CENTAUR, enclosureCENTAUR);

        allHabitatInformation = new ArrayList<>();
        allHabitatInformation.add(enclosuresForHIPPOCAMPUS);
        allHabitatInformation.add(enclosuresForSELKIE);
        allHabitatInformation.add(enclosuresForSEAHORSE);
        allHabitatInformation.add(enclosuresForGRIFFIN);
        allHabitatInformation.add(enclosuresForHIPPOGRIFF);
        allHabitatInformation.add(enclosuresForYETI);
        allHabitatInformation.add(enclosuresForDRAGON);
        allHabitatInformation.add(enclosuresForUNICORN);
        allHabitatInformation.add(enclosuresForWEREWOLF);
        allHabitatInformation.add(enclosuresForGNOME);
        allHabitatInformation.add(enclosuresForLEPRECHAUN);
        allHabitatInformation.add(enclosuresForCENTAUR);

    }
}
