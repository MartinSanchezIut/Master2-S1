package me.martin.softwaretesting.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graphe {

    private Set<Vertex> listVertex ;
    private Set<Edge> listEdge;

    public Graphe() {
        this.listVertex = new HashSet<>() ;
        this.listEdge =  new HashSet<>() ;
    }

    public void addVertex(Vertex v) {        this.listVertex.add(v) ;    }

    public void addEdge(Edge e) {
        this.listEdge.add(e);
    }

    public Set<Vertex> getListVertex() {
        return listVertex;
    }

    public Set<Edge> getListEdge() {
        return listEdge;
    }

    @Override
    public String toString() {
        return "Graphe{" +
                "listVertex=" + listVertex +
                ", listEdge=" + listEdge +
                '}';
    }
}
