package me.martin.softwaretesting;


import me.martin.softwaretesting.Utils.Graph.Edge;
import me.martin.softwaretesting.Utils.Graph.Graphe;
import me.martin.softwaretesting.Utils.Graph.Vertex;
import me.martin.softwaretesting.Utils.Tree.Node;
import me.martin.softwaretesting.Utils.Utils;
import me.martin.softwaretesting.Visitors.ClassVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.*;
import java.util.*;

import static guru.nidi.graphviz.model.Factory.graph;

public class Main  {

    public static void main(String[] args) throws IOException {
        ArrayList<File> javaFiles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String fileName = "src/main/resources/PP.java";


        final File folder = new File(fileName);
        if (!folder.exists()) {
            System.err.println("File to parse not found");
            System.exit(2);
        }
        if (folder.isDirectory()) {
            javaFiles = Utils.listJavaFilesForFolder(folder);
        } else if (folder.isFile() && folder.canRead()) {
            javaFiles = new ArrayList<>();
            javaFiles.add(folder);
        }


        //System.out.println("Quel parser utiliser ?");
        //System.out.println("0 - JDT");
        //System.out.println("1 - Spoon");
        int val = 1 ; //sc.nextInt();
        if (val == 0) {
            Parser parser = new Parser().setMethodVisitor(new ClassVisitor());
            ArrayList<CompilationUnit> asts = parser.getAstFromFiles(javaFiles);

            Graphe callGraph = parser.buildCallGraph() ;
            Graphe cGraph = Metrics.buildCouplingGraph(callGraph);
            Node tree = Metrics.buildClusteringTree(cGraph);

            handleChoice(callGraph,cGraph,tree);
        }


        if (val == 1) {
            SpoonParser sParser = new SpoonParser();
            sParser.getAstFromFiles(javaFiles);

            Graphe callGraph = sParser.buildCallGraph() ;
            Graphe cGraph = Metrics.buildCouplingGraph(callGraph);
            Node tree = Metrics.buildClusteringTree(cGraph);

            handleChoice(callGraph,cGraph,tree);
        }
        System.exit(0);

    }
    public static void printOption() {
        System.out.println("Que voulez vous afficher ?");
        System.out.println("1 - Graphe d'appel");
        System.out.println("2 - Graphe de couplage");
        System.out.println("3 - Arbre de clusturing");
        System.out.println("4 - Les modules");
    }

    public static void handleChoice(Graphe callGraph, Graphe cGraph, Node tree) {
        Scanner sc = new Scanner(System.in) ;
        boolean exit = false;
        while(!exit) {
            System.out.println("\n\n\n");
            printOption();
            int val = sc.nextInt();

            if (val == 1) {
                System.out.println("Sommets du graphe : ");
                System.out.println(Arrays.toString(callGraph.getListVertex().toArray()));
                System.out.println("\nArretes du graphe : ");
                for (Edge e : callGraph.getListEdge()) {
                    System.out.println(e);
                }
            }
            else if (val == 2) {
                System.out.println("Sommets du graphe : ");
                System.out.println(Arrays.toString(cGraph.getListVertex().toArray()));
                System.out.println(cGraph.getListVertex().size());
                System.out.println("\nArretes du graphe : " + cGraph.getListEdge().size());
                for (Edge e : cGraph.getListEdge()) {
                    System.out.println(e);
                }
            }
            else if (val == 3) {
                System.out.println("Clustering tree: ");
                System.out.println(tree);
            }
            else if (val == 4) {
                System.out.println("Clusters : ");
                for (Vertex e : Metrics.createCluster(0.5, cGraph, tree)) {
                    System.out.println(e);
                }
            }
            else {
                exit = true;
            }
        }
    }
}