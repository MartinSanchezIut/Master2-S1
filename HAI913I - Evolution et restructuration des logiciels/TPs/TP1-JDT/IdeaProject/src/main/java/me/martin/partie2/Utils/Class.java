package me.martin.partie2.Utils;

import java.util.ArrayList;

public class Class {

    private String name;
    private ArrayList<Method> methods;
    private ArrayList<String> attributes;

    public Class(String name, ArrayList<Method> methods, ArrayList<String> attributes) {
        this.name = name;
        this.methods = methods;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Method> getMethods() {
        return methods;
    }
    public ArrayList<String> getAttributes() {
        return attributes;
    }
}
