package me.martin.softwaretesting;


import me.martin.softwaretesting.Utils.Graph.Edge;
import me.martin.softwaretesting.Utils.Graph.Graphe;
import me.martin.softwaretesting.Utils.Graph.Vertex;
import me.martin.softwaretesting.Visitors.ClassVisitor;
import me.martin.softwaretesting.Visitors.MethodCallVisitor;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Parser {
    public static final String jrePath = "/usr/lib/jvm/jrt-fs.jar";
    public static CompilationUnit parse(char[] classSource) {
        ASTParser parser = ASTParser.newParser(AST.JLS4); // java +1.6
        parser.setResolveBindings(true);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        parser.setBindingsRecovery(true);

        Map options = JavaCore.getOptions();
        parser.setCompilerOptions(options);

        parser.setUnitName("");

        String[] sources = { "src/" };
        String[] classpath = {jrePath};

        parser.setEnvironment(classpath, sources, new String[] { "UTF-8"}, true);
        parser.setSource(classSource);

        return (CompilationUnit) parser.createAST(null); // create and parse
    }




    private ClassVisitor methodVisitor ;

    public Parser() {         methodVisitor = new ClassVisitor();    }
    public Parser setMethodVisitor(ClassVisitor methodVisitor) {         this.methodVisitor = methodVisitor; return this;    }
    /**
     * Generate asts for the list of file given, accept the visitors
     * @param files
     * @return list of asts
     * @throws IOException
     */
    public ArrayList<CompilationUnit> getAstFromFiles(ArrayList<File> files) throws IOException {
        ArrayList<CompilationUnit> ret = new ArrayList<>() ;
        for (File fileEntry : files) {
            // Recupérer les lignes du fichier


            String content = FileUtils.readFileToString(fileEntry);

            CompilationUnit ast = parse(content.toCharArray());

            ret.add(ast);

            ast.accept(methodVisitor);
        }
        return ret;
    }

/*
    Pour chaque classe: recup méthodes: recup appels
 */
    public Graphe buildCallGraph() {
        Graphe callGraph = new Graphe();
        for (TypeDeclaration c : methodVisitor.getMethods()){

            for(MethodDeclaration m : c.getMethods()) {
                String vertexName = c.getName().toString()+ "." + m.getName().getFullyQualifiedName() ;
                Vertex caller = new Vertex(vertexName);
                callGraph.addVertex(caller);

                MethodCallVisitor mcv = new MethodCallVisitor();
                m.accept(mcv);

                for (MethodInvocation i : mcv.getCalledMethods()) {
                    Vertex called = new Vertex(i.getExpression().resolveTypeBinding().getName() + "." + i.getName().getFullyQualifiedName()) ;
                    callGraph.addVertex(called);
                    callGraph.addEdge(new Edge(caller, called));
                }

                for (SuperMethodInvocation i : mcv.getSuperMethods()) {
                    Vertex called = new Vertex(i.getName().getFullyQualifiedName()) ;
                    callGraph.addVertex(called);
                    callGraph.addEdge(new Edge(caller, called));
                }
            }
        }
        return callGraph;
    }


}
