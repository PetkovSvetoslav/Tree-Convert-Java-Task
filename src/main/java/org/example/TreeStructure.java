package org.example;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class TreeStructure {
    private static final Logger logger = Logger.getLogger(TreeStructure.class.getName());

    public static Tree readInputFile(String filePath) throws IOException {
        Tree tree = new Tree();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int number = Integer.parseInt(parts[0]);
                int parentNumber = Integer.parseInt(parts[1]);
                String info = parts[2];
                tree.addNode(number, parentNumber, info);
            }
        }
        logger.info("Finished reading input file.");
        return tree;
    }

    public static void writeOutputFile(String filePath, List<Integer> specialNodes, Tree tree) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int number : specialNodes) {
                TreeNode node = tree.nodes.get(number);
                int depth = tree.getDepth(node);
                bw.write(number + "," + depth);
                bw.newLine();
                logger.info("Wrote node: " + number + ", depth: " + depth);
            }
        }
        logger.info("Finished writing output file.");
    }
}
