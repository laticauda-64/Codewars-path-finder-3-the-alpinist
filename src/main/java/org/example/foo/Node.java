package org.example.foo;

// Node definition
public class Node {

    public int[] gridPosition;
    public int gridX;
    public int gridY;

    public int climbCost;
    public int gCost;
    public int hCost;
    public Node parent;

    // Constructor
    public Node(int climbCost, int[] gridPosition, int gridX, int gridY) {
        this.climbCost = climbCost;
        this.gridPosition = gridPosition;
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public int fCost() {
        return gCost + hCost;
    }
}
