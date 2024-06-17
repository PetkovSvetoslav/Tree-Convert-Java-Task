package org.example;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int number;
    String info;
    TreeNode parent;
    List<TreeNode> children;

    public TreeNode(int number, String info) {
        this.number = number;
        this.info = info;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
        child.parent = this;
    }

    public void printTree(String prefix) {
        System.out.println(prefix + number);
        for (TreeNode child : children) {
            child.printTree(prefix + "  ");
        }
    }
}
