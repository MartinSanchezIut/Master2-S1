package me.martin.softwaretesting.Visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.util.ArrayList;

public class ClassVisitor extends ASTVisitor {
    ArrayList<TypeDeclaration> classes = new ArrayList<>();

    @Override
    public boolean visit(TypeDeclaration node) {
        classes.add(node);
        return super.visit(node);
    }

    public ArrayList<TypeDeclaration> getMethods() {
        return classes;
    }
}
