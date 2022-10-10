package me.martin.p2Exo2;


import me.martin.p2Exo2.Utils.Edge;
import me.martin.p2Exo2.Utils.Graphe;
import me.martin.p2Exo2.Visitors.MethodVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JApplet {

    //  graphe d'appel: https://jgrapht.org/
    // https://quickchart.io/documentation/graphviz-api/
    /*
        Ajouter les appels de connstructeur ?? ConstructorInvocation SuperConstructorInvocation

     */
    private static final long serialVersionUID = 2202072534703043194L;
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
    private JGraphXAdapter<String, DefaultEdge> jgxAdapter;

    public static void main(String[] args) throws IOException {
        CLI cli = CLI.init() ;


        Parser parser = new Parser().setMethodVisitor(new MethodVisitor());
        ArrayList<CompilationUnit> asts = parser.getAstFromFiles(cli.getJavaFiles()) ;


        Graphe callGraph = parser.buildCallGraph() ;

        for (Edge e : callGraph.getListEdge()) {
            System.out.println(e);
        }

        JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



    @Override
    public void init(){
        // create a JGraphT graph
        ListenableGraph<String, DefaultEdge> g = new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));

        // create a visualization using JGraph, via an adapter
        jgxAdapter = new JGraphXAdapter<>(g);

        setPreferredSize(DEFAULT_SIZE);
        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.setConnectable(false);
        component.getGraph().setAllowDanglingEdges(false);
        getContentPane().add(component);
        resize(DEFAULT_SIZE);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add some sample data (graph manipulated via JGraphX)
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v1);
        g.addEdge(v4, v3);

        // positioning via jgraphx layouts
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

        // center the circle
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);

        layout.execute(jgxAdapter.getDefaultParent());
    }
}
