package me.martin.partie2.Utils;

import java.util.ArrayList;

public class Method {

    private ArrayList<String> parametters;
    private String name;

    public Method(ArrayList<String> parametters, String name) {
        this.parametters = parametters;
        this.name = name;
    }

    public ArrayList<String> getParametters() {
        return parametters;
    }
    public String getName() {
        return name;
    }
}
