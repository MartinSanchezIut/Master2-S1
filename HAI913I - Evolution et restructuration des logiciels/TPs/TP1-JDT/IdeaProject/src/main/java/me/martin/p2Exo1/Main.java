package me.martin.p2Exo1;

import me.martin.p2Exo1.Visitors.ClassVisitor;
import me.martin.p2Exo1.Visitors.MethodeVisitor;
import me.martin.p2Exo1.Visitors.PackageVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.IOException;
import java.util.ArrayList;

public class   Main {

    /*
            TO DO :

        CLI + exo 1

       graphe d'appel: https://jgrapht.org/


     */



    public static void main(String[] args) throws IOException {
       CLI cli = CLI.init() ;


        /**
         *          Parser and Visitors initialization
         */


        Parser parser = new Parser().setClassVisitor(new ClassVisitor())
                                    .setMethodVisitor(new MethodeVisitor())
                                    .setPackageVisitor(new PackageVisitor());

        ArrayList<CompilationUnit> asts = parser.getAstFromFiles(cli.getJavaFiles()) ;

        /**
         *          Using CLI
         */
        while (true) {
            cli.processInput(parser, cli.getInput());
            System.out.println("\n\n\n");
        }
    }
}
