package me.martin.softwaretesting.Utils.Tree;

import java.util.ArrayList;

public class Node {

    ArrayList<Node> childs;

    public Node() {
        this.childs = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Node c : childs) {
            sb.append(c.toString()).append(" ");
        }
        sb.append(" )");
        return sb.toString();
    }

    public void addChild(Node child) {
        childs.add(child) ;
    }
    public void addAllChild(ArrayList<Node> child) {
        childs.addAll(child) ;
    }
    public ArrayList<Node> getChilds() {
        return childs;
    }
}
