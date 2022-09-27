package me.martin.tp1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.internal.utils.FileUtil;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.*;

public class Parser {

        public static final String jrePath = "/usr/lib/jvm/jrt-fs.jar";
        // /home/e20180002097/Bureau/RestrucLogi/IdeaProject/src/main/resources/
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quel fichier voulez vous parser ? ");
            String fileName = scanner.nextLine();

            if (fileName.isEmpty()) { fileName = "src/main/resources/" ; }

            System.out.println("Parsing de : " + fileName);

            // read java files
            final File folder = new File(fileName);
            if (!folder.exists()) { System.exit(2); }

            ArrayList<File> javaFiles = new ArrayList<>();

            if (folder.isDirectory()) {
                javaFiles = listJavaFilesForFolder(folder);
            }else if(folder.isFile() && folder.canRead()) {
                javaFiles = new ArrayList<>() ;
                javaFiles.add(folder);
            }


            for (File fileEntry : javaFiles) {
                String content = FileUtils.readFileToString(fileEntry);

                CompilationUnit ast = parse(content.toCharArray());

                // Ici on à l'ast du fichier
                System.out.println("Traitement du fichier :  " + fileEntry.getName());
                ast.accept(new ASTVisitor() {
                    @Override
                    public boolean visit(TypeDeclaration node) {
                        System.out.println("\n-------------------");
                        System.out.println("Class name : " + node.getName());

                        String superclass = "" ;
                        if(node.getSuperclassType() != null) {
                            superclass = node.getSuperclassType().toString() ;
                        }else {
                            superclass = "Object" ;
                        }
                        System.out.println("Supers classes : " + superclass);


                        System.out.println("Attributes : ");
                        for(FieldDeclaration f : node.getFields()) {
                            System.out.println("    "+f.getType() );
                        }

                        System.out.println("Methods : ");
                        for(MethodDeclaration f : node.getMethods()) {
                            System.out.println("    "+f.getName() );
                        }
                        return true;
                    }

                });

            }
        }

        /***
         *  Return the list of all Java files inside the folder given as a parameter
         * @param folder File
         * @return ArrayList<File>
         */
        public static ArrayList<File> listJavaFilesForFolder(final File folder) {
            ArrayList<File> javaFiles = new ArrayList<File>();
            for (File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    javaFiles.addAll(listJavaFilesForFolder(fileEntry));
                } else if (fileEntry.getName().contains(".java")) {
                    javaFiles.add(fileEntry);
                }
            }
            return javaFiles;
        }

        /***
         *  Parse the program given as a parameter and return his ast
         * @param classSource
         * @return
         */
         private static CompilationUnit parse(char[] classSource) {
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

    }
