package me.martin.softwaretesting;

import me.martin.softwaretesting.Utils.Edge;
import me.martin.softwaretesting.Utils.Graphe;
import me.martin.softwaretesting.Utils.Vertex;
import me.martin.softwaretesting.Utils.WeightedEdge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Metrics {

    public static Graphe buildCouplingGraph(Graphe callGraph) {
        Graphe g = new Graphe();
        ArrayList<String> classes = allClassOfGraph(callGraph);

        for (String c : classes) { g.addVertex(new Vertex(c)); }

        for(int i=0; i<classes.size(); i++){
            for (int j = i; j < classes.size(); j++) {
                String a = classes.get(i);
                String b = classes.get(j);

                if (!a.equals(b)) {
                    double weight = couplage(callGraph, a, b);
                    if (weight > 0) {
                        g.addEdge(new WeightedEdge(new Vertex(a), new Vertex(b), weight));
                    }
                }
            }
        }
        return g;
    }
    public static double couplage(Graphe graph, String classA, String classB) {
        assert graph.getListEdge().size() > 0 ;
        if (!(graphContainsClass(graph, classA) && graphContainsClass(graph, classB))) {
            return -1.0 ;
        }

        int countCalls = 0;
        for (Edge e : graph.getListEdge()) {
            String callerClass = e.getV1().getName().split("\\.")[0] ;

            for (Edge f : graph.getListEdge()) {
                String calledClass = f.getV2().getName().split("\\.")[0] ;

                if (callerClass.equalsIgnoreCase(classA) && calledClass.equalsIgnoreCase(classB)) {
                    countCalls++;
                }
                if (callerClass.equalsIgnoreCase(classB) && calledClass.equalsIgnoreCase(classA)) {
                    countCalls++;
                }
            }
        }
        // System.out.println(countCalls + " / " + graph.getListEdge().size());
        return (float)countCalls / (float)graph.getListEdge().size() ;
    }

    public static ArrayList<String> allClassOfGraph(Graphe g) {
        ArrayList<String> ret = new ArrayList<>();
        for (Edge e : g.getListEdge())  {
            String c1 = e.getV1().getName().split("\\.")[0];
            String c2 = e.getV2().getName().split("\\.")[0];

            if (! ret.contains(c1)) { ret.add(c1) ;}
            if (! ret.contains(c2)) { ret.add(c2) ;}
        }
        return ret;
    }
    public static boolean graphContainsClass(Graphe g, String className) {
        for (Vertex v : g.getListVertex()) {
            String[] vName = v.getName().split("\\.") ;
            //System.out.println(v.getName());
            if (vName[0].equalsIgnoreCase(className)) {
                return true;
            }
        }
        return false;
    }
}
