package me.martin.partie2;

import me.martin.partie2.Visitors.ClassVisitor;
import me.martin.partie2.Visitors.MethodeVisitor;
import me.martin.partie2.Visitors.PackageVisitor;
import me.martin.partie2.Utils.Utils;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
         cli.processInput(parser, cli.getInput());

     System.out.print("Nombre de classes : ");         System.out.println(parser.getNumberOfClasses());
     System.out.print("Nombre de méthodes : ");        System.out.println(parser.getNumberOfMethods());
     System.out.print("Nombre de packages : ");        System.out.println(parser.getNumberOfPackages());
     System.out.print("Nombre de lignes de code : ");  System.out.println(parser.getNumberOfLines());


     System.out.print("Nombre moyen de méthodes par classe : "); System.out.println( parser.getNumberOfMethods() / parser.getNumberOfClasses());
     System.out.print("Nombre moyen de lignes par méthodes : "); System.out.println( parser.getNumberOfLines() / parser.getNumberOfMethods());


     System.out.print("Nombre moyen d'attributs par classe : "); System.out.println( parser.getNumberOfAttributes() / parser.getNumberOfClasses());


     System.out.println("TODO");

     System.out.println("10% de classes qui ont le plus de méthodes : ");
     System.out.println("10% de classes qui ont le plus d'attributs' : ");
     System.out.println("Classes qui ont le plus d'attribut et de méthodes : ");

     System.out.println("Classes de plus de x méthodes :");


     System.out.println("10% de méthodes qui ont le plus de lignes par classes : ");
     System.out.println("Le nombre maximal de paramettres de méthodes : ");

    }
}
