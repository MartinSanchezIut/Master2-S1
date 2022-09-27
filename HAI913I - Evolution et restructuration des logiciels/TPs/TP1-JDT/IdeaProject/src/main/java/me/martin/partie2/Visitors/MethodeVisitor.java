package me.martin.partie2.Visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.util.ArrayList;

public class MethodeVisitor extends ASTVisitor {
    ArrayList<MethodDeclaration> methodes = new ArrayList<>();

    @Override
    public boolean visit(MethodDeclaration node) {
        methodes.add(node);
        return super.visit(node);
    }

    public ArrayList<MethodDeclaration> getMethods() {
        return methodes;
    }
}
