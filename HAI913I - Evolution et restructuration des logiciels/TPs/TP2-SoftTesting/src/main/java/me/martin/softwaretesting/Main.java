package me.martin.softwaretesting;


import me.martin.softwaretesting.Utils.Graph.Edge;
import me.martin.softwaretesting.Utils.Graph.Graphe;
import me.martin.softwaretesting.Utils.Tree.Node;
import me.martin.softwaretesting.Utils.Utils;
import me.martin.softwaretesting.Visitors.ClassVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.*;
import java.util.*;

import static guru.nidi.graphviz.model.Factory.graph;

public class Main  {
/*

        TODO :
        Dans le parser : classe de la méthodes appellé (called)
        parametres (types / noms) des méthodes






 */
    public static void main(String[] args) throws IOException {
        ArrayList<File> javaFiles = new ArrayList<>();
        String fileName = "src/main/resources/PP.java";

        final File folder = new File(fileName);
        if (!folder.exists()) { System.err.println("File to parse not found"); System.exit(2); }
        if (folder.isDirectory()) {
            javaFiles = Utils.listJavaFilesForFolder(folder);
        }else if(folder.isFile() && folder.canRead()) {
            javaFiles = new ArrayList<>() ;
            javaFiles.add(folder);
        }

        Parser parser = new Parser().setMethodVisitor(new ClassVisitor());
        ArrayList<CompilationUnit> asts = parser.getAstFromFiles(javaFiles) ;

        /*
        Graphe callGraph = parser.buildCallGraph() ;
        System.out.println("CallGraph: ");
        System.out.println("Sommets du graphe : ");
        System.out.println(Arrays.toString(callGraph.getListVertex().toArray()));
        System.out.println("\nArretes du graphe : ");
        for (Edge e : callGraph.getListEdge()) {
            System.out.println(e);
        }


        System.out.println("\n\n\n");
        */
        Graphe callGraph = parser.buildCallGraph() ;

        System.out.println("Couplage(PPeq, PPExpr) = " + Metrics.couplage(callGraph, "PPEq", "PPExpr"));

        Graphe cGraph = Metrics.buildCouplingGraph(callGraph);
        System.out.println("Coupling graphe: ");
        System.out.println("Sommets du graphe : ");
        System.out.println(Arrays.toString(cGraph.getListVertex().toArray()));
        System.out.println(cGraph.getListVertex().size());
        System.out.println("\nArretes du graphe : " + cGraph.getListEdge().size());
        for (Edge e : cGraph.getListEdge()) {
            System.out.println(e);
        }

        System.out.println("\n\n\n");


        Node tree = Metrics.buildClusteringTree(cGraph);
        System.out.println("Clustering tree: ");
        System.out.println(tree);

        /*

        Graph<Vertex, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        for ( Vertex v : callGraph.getListVertex()) { g.addVertex(v); }
        for ( Edge e : callGraph.getListEdge()) { g.addEdge(e.getV1() , e.getV2()); }

        DOTExporter<Vertex, DefaultEdge> exporter = new DOTExporter<>();
        exporter.setVertexAttributeProvider((v) -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(v.toString()));
            return map;
        });
        Writer writer = new StringWriter();
        exporter.exportGraph(g, writer);

        File file = new File("src/main/resources/img/graph_" + System.nanoTime()  + ".png");

        System.out.println("Graphe exporté au format png dans : " + file.getPath());
        String urlString = "https://quickchart.io/graphviz?format=png" + "&graph=" + writer.toString().replace("\n", "") ;

        MutableGraph grest = new guru.nidi.graphviz.parse.Parser().read(writer.toString());
        Graphviz.fromGraph(grest).render(Format.PNG).toFile(file);

        System.out.println("En cas de non fonctionnement, ouvrez cet url dans un navigateur.");
        System.out.println(urlString);
        */
    }
}