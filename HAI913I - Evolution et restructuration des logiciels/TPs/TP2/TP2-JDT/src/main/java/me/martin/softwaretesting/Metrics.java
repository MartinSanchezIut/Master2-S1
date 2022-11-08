package me.martin.softwaretesting;

import me.martin.softwaretesting.Utils.Graph.Edge;
import me.martin.softwaretesting.Utils.Graph.Graphe;
import me.martin.softwaretesting.Utils.Graph.Vertex;
import me.martin.softwaretesting.Utils.Graph.WeightedEdge;
import me.martin.softwaretesting.Utils.Tree.Leaf;
import me.martin.softwaretesting.Utils.Tree.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Metrics {

    public static ArrayList<Vertex> createCluster(double cp, Graphe cgraphe, Node cTree) {
        ArrayList<Vertex> ret = new ArrayList<>() ;
        int max = cgraphe.getListVertex().size() / 2 ;

        for (Node child : cTree.getChilds()) {
            // Est-ce que j'ai la possibilité de créer un cluser ?
            if ((couplageMoyen(child.getLeafs(), cgraphe) >= cp) && ret.size() < max)  {
                StringBuilder sb = new StringBuilder() ;
                sb.append("(") ;
                for (Leaf l : child.getLeafs()) {
                    sb.append(" ") ;
                    sb.append(l.toString()) ;
                    sb.append(" +") ;
                }
                sb.deleteCharAt(sb.length()-1) ;
                sb.append(")") ;

                ret.add(new Vertex(sb.toString())) ;
            }else {
                ArrayList<Vertex> childClusters = createCluster(cp, cgraphe, child);
                if (ret.size() + childClusters.size() < max) { ret.addAll(childClusters) ; }
            }
        }
        return ret;
    }


    public static Node buildClusteringTree(Graphe couplingGraph) {
        Node ret = new Node();

        ArrayList<Vertex> classes = new ArrayList<>();
        for (Vertex v : couplingGraph.getListVertex()) {
            classes.add(new Vertex(v.getName())) ;
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for (Edge v : couplingGraph.getListEdge()) {
            edges.add(new Edge(v.getV1(), v.getV2() )) ;
        }

        ArrayList<Leaf> nodes = new ArrayList<>();

        boolean exit = false;
        while ((classes.size() > 1) && !exit) {
            Edge winner = getMostCoupledClasses(edges);
            if (winner == null) { exit = true; continue; }
            edges.remove(winner);

            Vertex c3 = new Vertex("(" + winner.getV1().getName() + " " + winner.getV2().getName() + ")") ;

            edges = clusterify(winner.getV1(), winner.getV2(), c3, edges) ;

            classes.remove(winner.getV1()) ;
            classes.remove(winner.getV2());
            classes.add(c3) ;

            Leaf l1 = new Leaf(winner.getV1().getName()) ;
            Leaf l2 = new Leaf(winner.getV2().getName()) ;
            Leaf l = new Leaf(c3.getName()) ;


            for (Leaf leaf : nodes) {
                if (leaf.toString().equalsIgnoreCase(winner.getV1().getName())) { l1 = leaf; }
                if (leaf.toString().equalsIgnoreCase(winner.getV2().getName())) { l2 = leaf; }
            }
            if (nodes.contains(l1)) { nodes.remove(l1); }
            if (nodes.contains(l2)) { nodes.remove(l2); }

            l.addChild(l1); l.addChild(l2);
            nodes.add(l) ;
        }
        /*
        System.out.println("Vertices : "+ classes.size());
        for (Vertex v : classes) { System.out.println(v); }

        System.out.println("Edges : ");
        for (Edge v : edges) { System.out.println(v); }

        System.out.println("Leaf : " + nodes.size());
        for (Leaf v : nodes) { System.out.println(v); }
        */

        for (Leaf l : nodes) { ret.addChild(l); }
        return ret;
    }

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

    public static Edge getMostCoupledClasses(ArrayList<Edge> edges) {
        if (edges.isEmpty()) { return null; }
        double max = edges.get(0).getWeight() ;
        Edge v = edges.get(0);
        for (Edge e : edges) {
            if (e.getWeight() > max) {
                max = e.getWeight();
                v = e;
            }
        }
        // System.out.println("Most coupled : " + v);
        return v;
    }

    public static ArrayList<Edge> clusterify(Vertex v1, Vertex v2, Vertex v3, ArrayList<Edge> edges) {
        ArrayList<Edge> ret = new ArrayList<>() ;
        ArrayList<Edge> listEdges = new ArrayList<>(edges) ;

        for (Edge e : listEdges) {
            if (e.getV1().getName().equalsIgnoreCase(v1.getName())) {e.setV1(v3);}
            if (e.getV1().getName().equalsIgnoreCase(v2.getName())) {e.setV1(v3);}
            if (e.getV2().getName().equalsIgnoreCase(v1.getName())) {e.setV1(v3);}
            if (e.getV2().getName().equalsIgnoreCase(v2.getName())) {e.setV1(v3);}

            if (!ret.contains(e)) {ret.add(e);}
        }
        return ret;
    }


    public static double couplageMoyen(ArrayList<Leaf> leafs, Graphe cgraph) {
        double sum = 0.0 ;
        int nbCouples = 0;
        for (Leaf l1 : leafs) {
            for (Leaf l2 : leafs) {
                if (! l1.equals(l2)) {
                    sum += couplage(cgraph, l1.toString(), l2.toString()) ;
                    nbCouples += 1;
                }
            }
        }
        return sum / nbCouples;
    }
}
