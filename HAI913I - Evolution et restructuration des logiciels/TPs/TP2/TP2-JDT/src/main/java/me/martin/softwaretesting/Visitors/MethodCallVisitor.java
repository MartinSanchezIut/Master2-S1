package me.martin.softwaretesting.Visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;

import java.util.ArrayList;

public class MethodCallVisitor extends ASTVisitor {
    ArrayList<MethodInvocation> calledMethods = new ArrayList<>();
    ArrayList<SuperMethodInvocation> superMethods = new ArrayList<SuperMethodInvocation>();

    @Override
    public boolean visit(MethodInvocation node) {
        calledMethods.add(node);
        return super.visit(node);
    }

    @Override
    public boolean visit(SuperMethodInvocation node) {
        superMethods.add(node);
        return super.visit(node);
    }

    public ArrayList<MethodInvocation> getCalledMethods() {
        return calledMethods;
    }
    public ArrayList<SuperMethodInvocation> getSuperMethods() {
        return superMethods;
    }
}