package me.martin.softwaretesting;


import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import me.martin.p2Exo2.Utils.Edge;
import me.martin.p2Exo2.Utils.Graphe;
import me.martin.p2Exo2.Utils.Vertex;
import me.martin.p2Exo2.Visitors.MethodVisitor;
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

public class Main extends JApplet {

    //  graphe d'appel: https://jgrapht.org/
    // https://quickchart.io/documentation/graphviz-api/
    /*
        Ajouter les appels de connstructeur ?? ConstructorInvocation SuperConstructorInvocation

     */

    public static void main(String[] args) throws IOException {
        CLI cli = CLI.init() ;


        Parser parser = new Parser().setMethodVisitor(new MethodVisitor());
        ArrayList<CompilationUnit> asts = parser.getAstFromFiles(cli.getJavaFiles()) ;


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
