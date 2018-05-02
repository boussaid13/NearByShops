package com.nearByShops.NearByShops.models;

import java.util.ArrayList;




public class Location {
    private String type;
    private ArrayList<Double> coordinates;



    public Location(String type, ArrayList<Double> coordinates) {
        super();
        this.type = type;
        this.coordinates = coordinates;
    }

    public Location() {
        super();
    }

    public String getType() {
        return type;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }




}