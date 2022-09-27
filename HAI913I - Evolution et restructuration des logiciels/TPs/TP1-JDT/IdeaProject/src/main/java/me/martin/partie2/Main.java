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


    public static void main(String[] args) throws IOException {
        /**
         *          GUI
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel fichier voulez vous parser ? ");
        String fileName = scanner.nextLine();

        if (fileName.isEmpty()) { fileName = "src/main/resources/PP.java" ; }

        System.out.println("Parsing de : " + fileName + "\n\n");
        final File folder = new File(fileName);
        if (!folder.exists()) { System.exit(2); }

        ArrayList<File> javaFiles = new ArrayList<>();

        if (folder.isDirectory()) {
            javaFiles = Utils.listJavaFilesForFolder(folder);
        }else if(folder.isFile() && folder.canRead()) {
            javaFiles = new ArrayList<>() ;
            javaFiles.add(folder);
        }

        /**
         *          Visitors initialization
         */

        ClassVisitor classes = new ClassVisitor();
        MethodeVisitor methods = new MethodeVisitor();
        PackageVisitor packages = new PackageVisitor();
        int nbOfLineOfCode = 0;
        /**
         *          Parsing all files
         */
        for (File fileEntry : javaFiles) {
            String content = FileUtils.readFileToString(fileEntry);

            CompilationUnit ast = Parser.parse(content.toCharArray());

            nbOfLineOfCode += Utils.getNumberOfLines(fileEntry.getAbsolutePath()) ;
            ast.accept(classes);
            ast.accept(methods);
            ast.accept(packages);
        }



        /**
         *          Printing result
         */
        System.out.print("Nombre de classes : ");         System.out.println(classes.getClasses().size());
        System.out.print("Nombre de lignes de code : "); System.out.println(nbOfLineOfCode);
        System.out.print("Nombre de méthodes : ");         System.out.println(methods.getMethods().size());
        System.out.print("Nombre de packages : ");    System.out.println(packages.getPackages().size());


        System.out.print("Nombre moyen de méthodes par classe : "); System.out.println( methods.getMethods().size() / classes.getClasses().size());
        System.out.print("Nombre moyen de lignes par méthodes : "); System.out.println( Utils.getNumberOfLines(fileName) / methods.getMethods().size());

        int nbAttributesTotal = 0;
        for (TypeDeclaration m : classes.getClasses()) { nbAttributesTotal =  m.getFields().length; }
        System.out.print("Nombre moyen d'attributs par classe : "); System.out.println( nbAttributesTotal / classes.getClasses().size());



        System.out.println("10% de classes qui ont le plus de méthodes : ");
        System.out.println("10% de classes qui ont le plus d'attributs' : ");
        System.out.println("Classes qui ont le plus d'attribut et de méthodes : ");

        System.out.println("Classes de plus de x méthodes :");


        System.out.println("10% de méthodes qui ont le plus de lignes par classes : ");
        System.out.println("Le nombre maximal de paramettres de méthodes : ");





    }


}
