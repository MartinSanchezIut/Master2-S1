package me.martin.p2Exo1;

import me.martin.p2Exo1.Utils.Method;
import me.martin.p2Exo1.Utils.Utils;
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
        System.out.println("=-=-        TP 1: Statistiques de l'application        -=-=");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        selectFileToParse();
    }

    public void selectFileToParse() {
        System.out.println("Quel fichier voulez vous parser ? (src/main/resources/PP.java)");

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

    public int getInput() {
        System.out.println("Que voulez vous ?");
        System.out.println("-1: Exit");
        System.out.println("0: Toutes les informations");
        System.out.println("1: Nombre de classes de l’application.");
        System.out.println("2: Nombre de lignes de code de l’application.");
        System.out.println("3: Nombre total de méthodes de l’application.");
        System.out.println("4: Nombre total de packages de l’application.");
        System.out.println("5: Nombre moyen de méthodes par classe.");
        System.out.println("6: Nombre moyen de lignes de code par méthode.");
        System.out.println("7: Nombre moyen d’attributs par classe.");
        System.out.println("8: Les 10% des classes qui possèdent le plus grand nombre de méthodes.");
        System.out.println("9: Les 10% des classes qui possèdent le plus grand nombre d’attributs.");
        System.out.println("10: Les classes qui font partie en même temps des deux catégories précédentes.");
        System.out.println("11: Les classes qui possèdent plus de X méthodes (la valeur de X est donnée).");
        System.out.println("12: Les 10% des méthodes qui possèdent le plus grand nombre de lignes de code (par classe).");
        System.out.println("13: Le nombre maximal de paramètres par rapport à toutes les méthodes de l’application.");

        return sc.nextInt() ;
    }



    public void processInput(Parser parser, int input) {
        switch(input) {
            case 0:
                System.out.print("Nombre de classes : ");         System.out.println(parser.getNumberOfClasses());
                System.out.print("Nombre de méthodes : ");        System.out.println(parser.getNumberOfMethods());
                System.out.print("Nombre de packages : ");        System.out.println(parser.getNumberOfPackages());
                System.out.print("Nombre de lignes de code : ");  System.out.println(parser.getNumberOfLines());
                System.out.print("Nombre moyen de méthodes par classe : "); System.out.println( parser.getNumberOfMethods() / parser.getNumberOfClasses());
                System.out.print("Nombre moyen de lignes par méthodes : "); System.out.println( parser.getNumberOfLines() / parser.getNumberOfMethods());
                System.out.print("Nombre moyen d'attributs par classe : "); System.out.println( parser.getNumberOfAttributes() / parser.getNumberOfClasses());
                System.out.println("10% de classes qui ont le plus de méthodes : ");
                for (TypeDeclaration c : parser.top10ClassesMostMethods()) {
                    System.out.println(c.getName() + " : " + c.getMethods().length + " methodes.");

                }
                System.out.println("10% de classes qui ont le plus d'attributs' : ");
                for (TypeDeclaration c : parser.top10ClassesMostAttriute()) {
                    System.out.println(c.getName() + " : " + c.getFields().length + " attributs.");
                }
                System.out.println("Classes qui ont le plus d'attribut et de méthodes : ");
                for (TypeDeclaration c : parser.top10ClassesMostMethods()) {
                    if (parser.top10ClassesMostAttriute().contains(c)) {
                        System.out.println(c.getName() + " : " + c.getMethods().length + " methodes " + c.getFields().length + " attributs.");
                    }
                }

                System.out.println("Classes de plus de x méthodes :  (10 par defaut)");
                for (TypeDeclaration c : parser.moreThanXMethods(10)) {
                    System.out.println(c.getName() + " : " + c.getMethods().length + " methodes.");
                }

                System.out.println("10% de méthodes qui ont le plus de lignes par classes : ");
                for (Method c : parser.methodesWithMostLinesPerClass()) {
                    System.out.println(c.getName() + " de la classe: " + c.getClasse());
                }
                System.out.print("Le nombre maximal de paramettres de méthodes : ");      System.out.println(parser.mostParameterMethod().getName() + " de la classe: " + parser.mostParameterMethod().getClasse());

                break;
            case 1:
                System.out.print("Nombre de classes : ");         System.out.println(parser.getNumberOfClasses());
                break;
            case 2:
                System.out.print("Nombre de lignes de code : ");  System.out.println(parser.getNumberOfLines());
                break;
            case 3:
                System.out.print("Nombre de méthodes : ");        System.out.println(parser.getNumberOfMethods());
                break;
            case 4:
                System.out.print("Nombre de packages : ");        System.out.println(parser.getNumberOfPackages());
                break;
            case 5:
                System.out.print("Nombre moyen de méthodes par classe : "); System.out.println( parser.getNumberOfMethods() / parser.getNumberOfClasses());
                break;
            case 6:
                System.out.print("Nombre moyen de lignes par méthodes : "); System.out.println( parser.getNumberOfLines() / parser.getNumberOfMethods());
                break;
            case 7:
                System.out.print("Nombre moyen d'attributs par classe : "); System.out.println( parser.getNumberOfAttributes() / parser.getNumberOfClasses());
                break;
            case 8:
                System.out.println("10% de classes qui ont le plus de méthodes : ");
                for (TypeDeclaration c : parser.top10ClassesMostMethods()) {
                    System.out.println(c.getName() + " : " + c.getMethods().length + " methodes.");
                }
                break;
            case 9:
                System.out.println("10% de classes qui ont le plus d'attributs' : ");
                for (TypeDeclaration c : parser.top10ClassesMostAttriute()) {
                    System.out.println(c.getName() + " : " + c.getFields().length + " attributs.");
                }
                break;
            case 10:
                System.out.println("Classes qui ont le plus d'attribut et de méthodes : ");
                for (TypeDeclaration c : parser.top10ClassesMostMethods()) {
                    if (parser.top10ClassesMostAttriute().contains(c)) {
                        System.out.println(c.getName() + " : " + c.getMethods().length + " methodes " + c.getFields().length + " attributs.");
                    }
                }
                break;
            case 11:
                System.out.println("Classes de plus de x méthodes :  (10 par defaut)");
                int x = sc.nextInt();
                for (TypeDeclaration c : parser.moreThanXMethods(x)) {
                    System.out.println(c.getName() + " : " + c.getMethods().length + " methodes.");
                }
                break;
            case 12:
                for (Method c : parser.methodesWithMostLinesPerClass()) {
                    System.out.println(c.getName() + " de la classe: " + c.getClasse());
                }
                break;
            case 13:
                System.out.print("Le nombre maximal de paramettres de méthodes : ");
                System.out.println(parser.mostParameterMethod().getName() + " de la classe: " + parser.mostParameterMethod().getClasse());
                break;
            default:
                System.out.println("Au revoir !");
                System.exit(0);
        }

    }

    public ArrayList<File> getJavaFiles() {
        return javaFiles;
    }
}
