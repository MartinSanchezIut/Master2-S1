package me.martin.softwaretesting;


import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import me.martin.softwaretesting.Utils.Edge;
import me.martin.softwaretesting.Utils.Graphe;
import me.martin.softwaretesting.Utils.Utils;
import me.martin.softwaretesting.Utils.Vertex;
import me.martin.softwaretesting.Visitors.ClassVisitor;
import me.martin.softwaretesting.Visitors.MethodVisitor;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.jgrapht.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.io.* ;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.dot.DOTExporter;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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


        Graphe callGraph = parser.buildCallGraph() ;

        System.out.println("Sommets du graphe : ");
        System.out.println(Arrays.toString(callGraph.getListVertex().toArray()));
        System.out.println("\nArretes du graphe : ");
        for (Edge e : callGraph.getListEdge()) {
            System.out.println(e);
        }


        System.out.println("\n\n\n");


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

    }
}
