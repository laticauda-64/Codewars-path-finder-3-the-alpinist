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

    public ArrayList<Node> getNeighbours(Node node, Node[][] nodeArray) {
        ArrayList<Node> neighbours = new ArrayList<>();

        // Get neighbours while staying in the boundaries of the grid

        // Up
        if(node.gridY - 1 >= 0) neighbours.add(nodeArray[node.gridX][node.gridY - 1]);
        // Down
        if(node.gridY + 1 <= nodeArray.length) neighbours.add(nodeArray[node.gridX][node.gridY + 1]);
        // Left
        if(node.gridX - 1 >= 0) neighbours.add(nodeArray[node.gridX - 1][node.gridY]);
        // Right
        if(node.gridX + 1 <= nodeArray[0].length) neighbours.add(nodeArray[node.gridX + 1][node.gridY]);

        return neighbours;
    }

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

        ArrayList<Node> openSet = new ArrayList<>();
        ArrayList<Node> closedSet = new ArrayList<>();
        openSet.add(mapStartNode);

        while(openSet.size() > 0) {
            // Put starting node in the openSet
            Node currentNode = openSet.get(0);
            // Check for node with the lower fCost, if equality check for the lowest hCost
            for (int i = 1; i < openSet.size(); i++) {
                if(openSet.get(i).fCost() < currentNode.fCost() || openSet.get(i).fCost() == currentNode.fCost() && openSet.get(i).hCost < currentNode.hCost) {
                    currentNode = openSet.get(i);
                }
            }

            openSet.remove(currentNode);
            closedSet.add(currentNode);

            // Check if we find the exit
            if (currentNode == mapExitNode) {
                break;
            }

            // Check for neighbours

        }


        return false;
    }


}
