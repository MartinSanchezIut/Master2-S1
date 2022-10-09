package me.martin.p2Exo1.Visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.util.ArrayList;
import java.util.List;

public class ClassVisitor extends ASTVisitor {

    List<TypeDeclaration> classe = new ArrayList<>();

    @Override
    public boolean visit(TypeDeclaration node) {
        if (! node.isInterface()) {
            classe.add(node);
        }
        return super.visit(node);
    }

    public List<TypeDeclaration> getClasses(){
        return classe;
    }
}