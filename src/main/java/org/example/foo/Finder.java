package org.example.foo;

import java.util.ArrayList;
import java.util.Collections;

public class Finder {

    public static ArrayList<Node> path;

    // Get distance between two points with one of the four cardinal directions (i.e. North, East, South, West) possible
    public static int getDistance(Node nodeA, Node nodeB) {
            return (Math.abs((nodeA.gridX - nodeB.gridX)) + Math.abs((nodeA.gridY - nodeB.gridY)));
    }

    public static ArrayList<Node> getNeighbours(Node node, Node[][] nodeArray) {
        ArrayList<Node> neighbours = new ArrayList<>();

        // Constants
        final int GRID_MAX_DEPTH_X = nodeArray[0].length - 1; // Each line have same size
        final int GRID_MAX_DEPTH_Y = nodeArray.length - 1;

        // Up
        if(node.gridY - 1 >= 0) neighbours.add(nodeArray[node.gridY - 1][node.gridX]);
        // Down
        if(node.gridY + 1 <= GRID_MAX_DEPTH_Y) neighbours.add(nodeArray[node.gridY + 1][node.gridX]);
        // Left
        if(node.gridX - 1 >= 0) neighbours.add(nodeArray[node.gridY][node.gridX - 1]);
        // Right
        if(node.gridX + 1 <= GRID_MAX_DEPTH_X) neighbours.add(nodeArray[node.gridY][node.gridX + 1]);

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
    public static int pathFinder(String maze) {

        // Variables
        String[][] mazeRepresentation = to2dim(maze, "\n", "");
        Node[][] nodeArray = toNodeArray(mazeRepresentation);

        Node mapStartNode = nodeArray[0][0];
        Node mapExitNode = nodeArray[nodeArray.length - 1][nodeArray[0].length - 1];

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
                retracePath(mapStartNode, mapExitNode);
                return path.size();
            }

            // Check for neighbours
            for (Node neighbour :
                    getNeighbours(currentNode, nodeArray)) {
                if (closedSet.contains(neighbour)) {
                    continue;
                }
                int newMovementCostToNeighbour = currentNode.gCost + getDistance(currentNode, neighbour);
                if(newMovementCostToNeighbour < neighbour.gCost || !openSet.contains(neighbour)) {
                    neighbour.gCost = newMovementCostToNeighbour;
                    neighbour.hCost = getDistance(neighbour, mapExitNode);
                    neighbour.parent = currentNode;

                        if(!openSet.contains(neighbour)) {
                            openSet.add(neighbour);
                        }
                }
            }

        }


        return -1;
    }


}
