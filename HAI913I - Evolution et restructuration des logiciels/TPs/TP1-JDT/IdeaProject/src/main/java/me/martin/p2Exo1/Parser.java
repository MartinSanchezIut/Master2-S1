package me.martin.p2Exo1;

import me.martin.p2Exo1.Utils.Method;
import me.martin.p2Exo1.Utils.Utils;
import me.martin.p2Exo1.Visitors.ClassVisitor;
import me.martin.p2Exo1.Visitors.MethodeVisitor;
import me.martin.p2Exo1.Visitors.PackageVisitor;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public List<TypeDeclaration> top10ClassesMostMethods() {
        ArrayList<TypeDeclaration> ret = new ArrayList<>();

        ArrayList<TypeDeclaration> allClasses = new ArrayList<>(classVisitor.getClasses());

        allClasses.sort(new Comparator<TypeDeclaration>() {
            @Override
            public int compare(TypeDeclaration o1, TypeDeclaration o2) {
                if (o1.getMethods().length == o2.getMethods().length)
                    return 0;
                else if (o1.getMethods().length < o2.getMethods().length)
                    return 1;
                else
                    return -1;
            }
        });
        int tenPercent = ((int) (0.1 * allClasses.size())) ;
        for (int i=0; i<= tenPercent; i++) {
            ret.add(allClasses.get(i)) ;
        }
        return ret;
    }

    public List<TypeDeclaration> top10ClassesMostAttriute() {
        ArrayList<TypeDeclaration> ret = new ArrayList<>();

        ArrayList<TypeDeclaration> allClasses = new ArrayList<>(classVisitor.getClasses());
        allClasses.sort(new Comparator<TypeDeclaration>() {
            @Override
            public int compare(TypeDeclaration o1, TypeDeclaration o2) {
                if (o1.getFields().length == o2.getFields().length)
                    return 0;
                else if (o1.getFields().length < o2.getFields().length)
                    return 1;
                else
                    return -1;
            }
        });
        int tenPercent = ((int) (0.1 * allClasses.size())) ;
        for (int i=0; i<= tenPercent; i++) {
            ret.add(allClasses.get(i)) ;
        }
        return ret;
    }

    public List<TypeDeclaration> moreThanXMethods(int x) {
        ArrayList<TypeDeclaration> ret = new ArrayList<>();
        ArrayList<TypeDeclaration> allClasses = new ArrayList<>(classVisitor.getClasses());

        for (TypeDeclaration c : allClasses) {
            if (c.getMethods().length >= x) {
                ret.add(c);
            }
        }
        return ret;
    }


    public List<Method> methodesWithMostLinesPerClass() {
        ArrayList<Method> ret = new ArrayList<>();

        for(TypeDeclaration c : classVisitor.getClasses()) {
            ArrayList<MethodDeclaration> allMethods = new ArrayList<>(List.of(c.getMethods()));
            allMethods.sort(new Comparator<MethodDeclaration>() {
                @Override
                public int compare(MethodDeclaration o1, MethodDeclaration o2) {
                    return Integer.compare(o2.getBody().getLength(), o1.getBody().getLength());
                }
            });

            if (! allMethods.isEmpty()) {
                int tenPercent = ((int) (0.1 * allMethods.size()));
                for (int i = 0; i <= tenPercent; i++) {
                    ret.add(new Method(allMethods.get(i).getName().toString(), c.getName().toString()));
                }
            }
        }


        return ret;
    }

    public Method mostParameterMethod() {
        Method ret = null;

        int max = -1;
        for (TypeDeclaration c : classVisitor.getClasses()) {
            for(MethodDeclaration m : c.getMethods()) {
                if (m.parameters().size() > max) {
                    ret = new Method(m.getName().toString(), c.getName().toString());
                    max = m.parameters().size();
                }
            }
        }
        return ret;
    }




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
