package org.example;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

//        THE INPUT TEST FILE FROM THE TASK
        String inputFilePath = "src/main/resources/treeData.txt";

//        FILE WITH GENERATED PEAK NUMBERS FROM THE TREE
        String outputFilePath = "src/main/resources/output.txt";

//        LOGGER FOR ALL PROCESSES
        try {
            logger.info("Reading input file...");
            Tree tree = TreeStructure.readInputFile(inputFilePath);
            if (!tree.hasRoot()) {
                logger.severe("Root node (1) not found in the tree.");
                return;
            }
            logger.info("Finding special nodes...");
            List<Integer> specialNodes = tree.findSpecialNodes();
            logger.info("Writing output file...");
            TreeStructure.writeOutputFile(outputFilePath, specialNodes, tree);
            logger.info("Process completed successfully.");

            // Print the tree structure
            logger.info("Tree structure:");
            tree.printTree();

            // Verify special nodes
            logger.info("Verifying special nodes...");
            tree.verifySpecialNodes(specialNodes);

            // Print the full tree structure
//            logger.info("Full tree structure:");
//            tree.printFullTree();

        } catch (IOException e) {
            logger.severe("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
