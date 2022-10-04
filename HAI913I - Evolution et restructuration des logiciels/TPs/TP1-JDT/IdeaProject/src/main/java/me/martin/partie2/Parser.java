package me.martin.partie2;

import me.martin.partie2.Utils.Utils;
import me.martin.partie2.Visitors.ClassVisitor;
import me.martin.partie2.Visitors.MethodeVisitor;
import me.martin.partie2.Visitors.PackageVisitor;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Parser {


    /***
     *  Parse the program given as a parameter and return his ast
     * @param classSource
     * @return
     */
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




    private ClassVisitor classVisitor ;
    private MethodeVisitor methodVisitor ;
    private PackageVisitor packageVisitor ;
    private int nbOfLineOfCode ;

    public Parser() {
        classVisitor = new ClassVisitor();
        methodVisitor = new MethodeVisitor();
        packageVisitor = new PackageVisitor();
        nbOfLineOfCode = 0;
    }

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
            nbOfLineOfCode += Utils.getNumberOfLines(fileEntry.getAbsolutePath()) ;


            String content = FileUtils.readFileToString(fileEntry);

            CompilationUnit ast = Parser.parse(content.toCharArray());

            ret.add(ast);

            ast.accept(classVisitor);
            ast.accept(methodVisitor);
            ast.accept(packageVisitor);
        }
        return ret;
    }


    public int getNumberOfClasses() {
        return classVisitor.getClasses().size() ;
    }
    public int getNumberOfMethods() {
        return methodVisitor.getMethods().size() ;
    }
    public int getNumberOfPackages() {
        return packageVisitor.getPackages().size() ;
    }

    public int getNumberOfLines() { return nbOfLineOfCode; }

    public int getNumberOfAttributes() {
        int nbAttributesTotal = 0;
        for (TypeDeclaration m : classVisitor.getClasses()) { nbAttributesTotal =  m.getFields().length; }
        return nbAttributesTotal ;
    }

/*
        System.out.println("10% de classes qui ont le plus de méthodes : ");
        System.out.println("10% de classes qui ont le plus d'attributs' : ");
        System.out.println("Classes qui ont le plus d'attribut et de méthodes : ");

        System.out.println("Classes de plus de x méthodes :");


        System.out.println("10% de méthodes qui ont le plus de lignes par classes : ");
        System.out.println("Le nombre maximal de paramettres de méthodes : ");
*/




    public Parser setClassVisitor(ClassVisitor classVisitor) {
        this.classVisitor = classVisitor; return this;
    }
    public Parser setMethodVisitor(MethodeVisitor methodVisitor) {
        this.methodVisitor = methodVisitor; return this;
    }
    public Parser setPackageVisitor(PackageVisitor packageVisitor) {
        this.packageVisitor = packageVisitor; return this;
    }
}
