package me.martin.partie2.Utils;

import java.util.ArrayList;

public class Package {

    private String name;
    private ArrayList<Class> classes;

    public Package(String name, ArrayList<Class> classes) {
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Class> getClasses() {
        return classes;
    }
}
