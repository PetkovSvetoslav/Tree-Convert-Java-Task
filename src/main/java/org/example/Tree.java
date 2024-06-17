package org.example;

import java.util.*;
import java.util.logging.Logger;

public class Tree {
    private static final Logger logger = Logger.getLogger(Tree.class.getName());
    Map<Integer, TreeNode> nodes;

    public Tree() {
        this.nodes = new HashMap<>();
    }

    public void addNode(int number, int parentNumber, String info) {
        if (!nodes.containsKey(number)) {
            nodes.put(number, new TreeNode(number, info));
        }
        TreeNode node = nodes.get(number);

        if (parentNumber != 0) {
            if (!nodes.containsKey(parentNumber)) {
                nodes.put(parentNumber, new TreeNode(parentNumber, ""));
            }
            TreeNode parentNode = nodes.get(parentNumber);
            parentNode.addChild(node);
        }
        logger.info("Added node: " + number + ", parent: " + parentNumber);
    }

    public List<Integer> findSpecialNodes() {
        List<Integer> specialNodes = new ArrayList<>();
        for (TreeNode node : nodes.values()) {
            if (!node.children.isEmpty()) {
                boolean allChildrenAreLeaves = true;
                for (TreeNode child : node.children) {
                    if (!child.children.isEmpty()) {
                        allChildrenAreLeaves = false;
                        break;
                    }
                }
                if (allChildrenAreLeaves) {
                    specialNodes.add(node.number);
                }
            }
        }
        Collections.sort(specialNodes, Collections.reverseOrder());
        return specialNodes;
    }

    public int getDepth(TreeNode node) {
        int depth = 0;
        while (node.parent != null) {
            node = node.parent;
            depth += 1;
        }
        return depth;
    }

    public void printTree() {
        if (nodes.containsKey(1)) {
            nodes.get(1).printTree("");
        } else {
            logger.severe("Root node not found!");
        }
    }

    public void verifySpecialNodes(List<Integer> specialNodes) {
        for (int number : specialNodes) {
            TreeNode node = nodes.get(number);
            logger.info("Verifying node: " + number);
            boolean allChildrenAreLeaves = true;
            for (TreeNode child : node.children) {
                if (!child.children.isEmpty()) {
                    allChildrenAreLeaves = false;
                    break;
                }
            }
            if (node.children.isEmpty() || !allChildrenAreLeaves) {
                logger.warning("Node " + number + " does not meet the condition! It has children or non-leaf children.");
            } else {
                logger.info("Node " + number + " meets the condition.");
            }
        }
        logger.info("Verification completed.");
    }

    public boolean hasRoot() {
        return nodes.containsKey(1);
    }

//    PRINT FULL TREE
public void printFullTree() {
    for (TreeNode node : nodes.values()) {
        if (node.parent == null) {
            printSubTree(node, "");
        }
    }
}

    private void printSubTree(TreeNode node, String prefix) {
        logger.info(prefix + node.number);
        for (TreeNode child : node.children) {
            printSubTree(child, prefix + "  ");
        }
    }
}
