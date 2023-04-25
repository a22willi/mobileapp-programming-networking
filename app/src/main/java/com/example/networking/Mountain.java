package com.example.networking;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Mountain {
    @SerializedName(value = "ID", alternate = "id")
    private String id;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private JsonObject auxdata;

    @Override
    public String toString() {
        return (name +
                " is a mountain located in " +
                location +
                ", It belongs to the category: " +
                category +
                "\n\nThe mountain is of the type: " +
                type +
                "\n\n\nAdditional data " +
                auxdata.toString());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public JsonObject getAuxdata() {
        return auxdata;
    }
}
