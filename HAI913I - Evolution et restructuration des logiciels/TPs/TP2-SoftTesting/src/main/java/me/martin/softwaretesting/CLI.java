package me.martin.softwaretesting;



import me.martin.softwaretesting.Utils.Utils;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    private Scanner sc ;
    private ArrayList<File> javaFiles ;

    public static CLI init() {         return new CLI() ;     }

    public CLI() {
        sc = new Scanner(System.in);
        javaFiles = new ArrayList<>() ;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("=-=-                TP 1: Graphe d'appel               -=-=");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        selectFileToParse();
    }

    public void selectFileToParse() {
        System.out.println("De quel programme voulez vous obtenir le graphe d'appel ? (src/main/resources/PP.java)");

        String fileName = sc.nextLine();
        if (fileName.isEmpty()) { fileName = "src/main/resources/PP.java" ; }

        System.out.println("Parsing de : " + fileName + "\n\n");
        final File folder = new File(fileName);
        if (!folder.exists()) { System.exit(2); }

        if (folder.isDirectory()) {
            javaFiles = Utils.listJavaFilesForFolder(folder);
        }else if(folder.isFile() && folder.canRead()) {
            javaFiles = new ArrayList<>() ;
            javaFiles.add(folder);
        }
    }




    public ArrayList<File> getJavaFiles() {
        return javaFiles;
    }
}

