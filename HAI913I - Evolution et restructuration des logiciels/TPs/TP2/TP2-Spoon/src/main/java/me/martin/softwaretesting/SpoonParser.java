package me.martin.softwaretesting;

import me.martin.softwaretesting.Utils.Graph.Edge;
import me.martin.softwaretesting.Utils.Graph.Graphe;
import me.martin.softwaretesting.Utils.Graph.Vertex;
import me.martin.softwaretesting.Visitors.MethodCallVisitor;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.*;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.filter.TypeFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpoonParser {



    private ArrayList<CtModel> models;
    public SpoonParser(){ models = new ArrayList<>();}


    public ArrayList<CtModel> getAstFromFiles(ArrayList<File> files) throws IOException {
        ArrayList<CtModel> ret = new ArrayList<>() ;
        for (File fileEntry : files) {
            Launcher parser = new Launcher();
            parser.addInputResource(fileEntry.getPath());
            ret.add(parser.buildModel());
        }
        models.addAll(ret) ;
        return ret;
    }


    public Graphe buildCallGraph() {
        Graphe callGraph = new Graphe();

        for (CtModel ast : models) {
            for (CtType type : ast.getAllTypes()) {
                for (Object method : type.getMethods()) {
                    CtMethod p = (CtMethod) method;
                    String callerClass = type.getSimpleName();
                    String callerMethod = p.getSimpleName();

                    Vertex caller = new Vertex(callerClass+ "." + callerMethod);
                    callGraph.addVertex(caller);

                    p.filterChildren(new TypeFilter(CtInvocation.class)).forEach(inv->{
                        CtInvocation<?> invocation = (CtInvocation<?>) inv;

                        String calledClass = invocation.getExecutable().getDeclaringType().getSimpleName();
                        String calledMethod = invocation.getExecutable().getSimpleName();

                        Vertex called = new Vertex(calledClass+ "." + calledMethod);
                        callGraph.addVertex(called);

                        callGraph.addEdge(new Edge(caller, called));
                    });
                }
            }
        }

        return callGraph;
    }
}
