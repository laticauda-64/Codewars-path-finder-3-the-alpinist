package org.example.foo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Node definition
class Node {

    public boolean walkable;
    public int[] gridPosition;
    public int gridX;
    public int gridY;

    public int gCost;
    public int hCost;
    public Node parent;

    // Constructor
    public Node(boolean walkable, int[] gridPosition, int gridX, int gridY) {
        this.walkable = walkable;
        this.gridPosition = gridPosition;
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public int fCost() {
        return gCost + hCost;
    }
}

public class Finder {

    public static ArrayList<Node> path;

    // Path reconstruct
    public static void retracePath(Node startNode, Node endNode) {
        ArrayList<Node> path = new ArrayList<>();
        Node currentNode = endNode;

        while (currentNode != startNode) {
            path.add(currentNode);
            currentNode = currentNode.parent;
        }
        Collections.reverse(path);

        Finder.path = path;
    }

    // Convert String maze into 2D array
    public static String [][] to2dim (String source, String outerdelim, String innerdelim) {
        // outerdelim may be a group of characters
        String [] sOuter = source.split ("[" + outerdelim + "]");
        int size = sOuter.length;
        // one dimension of the array has to be known on declaration:
        String [][] result = new String [size][];
        int count = 0;
        for (String line : sOuter)
        {
            result [count] = line.split (innerdelim);
            ++count;
        }
        return result;
    }

    // Convert String 2D array to Nodes 2D array
    public static Node [][] toNodeArray (String [][] source) {
        Node[][] result = new Node[source.length][source[0].length];

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                result[i][j] = new Node((source[i][j].equals(".")) ? true : false, new int[]{j,i}, j, i);
            }
        }
        return result;
    }



    // Main function
    public static boolean pathFinder(String maze) {
        // Variables
        String[][] mazeRepresentation = to2dim(maze, "\n", "");
        Node[][] nodeArray = toNodeArray(mazeRepresentation);

        Node mapStartNode = nodeArray[0][0];
        Node mapExitNode = nodeArray[nodeArray.length - 1][nodeArray[0].length - 1];


        // For debugging purpose
        System.out.println(Arrays.deepToString(mazeRepresentation));

        // TODO: Build a search algo


        return false;
    }


}
