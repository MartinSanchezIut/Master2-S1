package me.martin.softwaretesting.Utils.Tree;


public class Leaf extends Node{

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
