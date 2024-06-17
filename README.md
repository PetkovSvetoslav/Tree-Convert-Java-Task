# Tree-Convert-Java-Task

The Structure of the Project

Overview
This project reads a tree structure from a text file, processes the data to rebuild the tree,
identifies special nodes based on specific conditions, and writes the results to an output file.
The project also includes detailed logging to aid in debugging and verification of the tree structure.

Requirements
 - Java 17 or higher
 - Logging library (java.util.logging)

project
│
├── src
│   └── main
│       ├── java
│       │   ├── TreeNode.java
│       │   ├── Tree.java
│       │   ├── TreeStructure.java
│       │   └── Main.java
│       └── resources
│           ├── treeData.txt
│           └── output.txt
│
└── README.md
└── output.txt
└── theTask.txt


Classes:

TreeNode
Represents a node in the tree with properties for the node number, parent, children, and additional information.

Tree
Manages the collection of TreeNode instances and provides methods to add nodes, find special nodes, print the tree structure, and verify the special nodes.

TreeStructure
Handles reading from the input file and writing to the output file.

Main
Contains the main method to run the project, orchestrating the reading, processing, and writing steps.

Usage:

Step 1: Prepare the Input File
Ensure that treeData.txt is located in the src/main/resources/ directory. This file should contain lines formatted as:
<number of node>,<number of parent node>,<additional info>

Step 2: Compile the Project
Compile the Java project using your preferred IDE or the command line.

Step 3: Run the Project
Run the Main class. The project will:

   1. Read the input file to build the tree structure.
   2. Identify special nodes that meet the condition (nodes with at least one child and all their children are leaves).
   3. Write the special nodes and their depths to output.txt.
   4. Print the full tree structure to the console.

Example Main.java Output:
INFO: Reading input file...
INFO: Finding special nodes...
INFO: Writing output file...
INFO: Process completed successfully.
INFO: Tree structure:
INFO: Full tree structure:
...
INFO: Verifying special nodes...
INFO: Node X meets the condition.
INFO: Verification completed.

Full Tree Structure
The full tree structure will be printed to the console with each node and its hierarchical relationships.

Step 4: Verify Output
Check the output.txt file in the src/main/resources/ directory to ensure it contains the correct special nodes and their depths.

Example output.txt
274,3
120,3
96,2
94,2
89,3
78,3
15,3
6,4

Logging

The project uses java.util.logging for detailed logging of the processing steps. 
Logs include information about adding nodes, verifying special nodes, and potential issues.

Acknowledgments

  - Developed using Java and the java.util.logging library.
  - Created on IntelliJ IDEA community edition.
