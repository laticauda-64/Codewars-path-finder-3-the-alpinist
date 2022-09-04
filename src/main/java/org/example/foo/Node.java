package org.example.foo;

// Node definition
public class Node {

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
