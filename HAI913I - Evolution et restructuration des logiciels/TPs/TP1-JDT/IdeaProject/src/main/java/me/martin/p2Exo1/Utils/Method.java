package me.martin.p2Exo1.Utils;

import java.util.ArrayList;

public class Method {

    private ArrayList<String> parametters;
    private String name;
    private String classe;

    public Method(ArrayList<String> parametters, String name) {
        this.parametters = parametters;
        this.name = name;
    }

    public Method(String name, String classe) {
        this.name = name;
        this.classe = classe;
        this.parametters = new ArrayList<>();
    }

    public ArrayList<String> getParametters() {
        return parametters;
    }
    public String getName() {
        return name;
    }

    public String getClasse() {
        return classe;
    }
}
