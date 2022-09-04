import org.example.foo.Finder;
import org.example.foo.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinderTest {

    private static String a =   "000\n"+
                                "000\n"+
                                "000",

                            b = "010\n"+
                                "010\n"+
                                "010",

                            c = "010\n"+
                                "101\n"+
                                "010",

                            d = "0707\n"+
                                "7070\n"+
                                "0707\n"+
                                "7070",

                            e = "700000\n"+
                                "077770\n"+
                                "077770\n"+
                                "077770\n"+
                                "077770\n"+
                                "000007",

                            f = "777000\n"+
                                "007000\n"+
                                "007000\n"+
                                "007000\n"+
                                "007000\n"+
                                "007777",

                            g = "000000\n"+
                                "000000\n"+
                                "000000\n"+
                                "000010\n"+
                                "000109\n"+
                                "001010";

    @Test
    public void sampleTests() {

        assertEquals(0,  Finder.pathFinder(a));
        assertEquals(2,  Finder.pathFinder(b));
        assertEquals(4,  Finder.pathFinder(c));
        assertEquals(42, Finder.pathFinder(d));
        assertEquals(14, Finder.pathFinder(e));
        assertEquals(0,  Finder.pathFinder(f));
        assertEquals(4,  Finder.pathFinder(g));
    }

}

// Previous code :

//    private static String a, b, c, d, e, f, g;
//    private static Node[][] gridB, gridE;
//    private static Node selectedNode;
//
//    @BeforeAll
//    static void setup() {
//
//        // Mazes
//        String a = "000\n"+
//                "000\n"+
//                "000",
//
//                b = "010\n"+
//                        "010\n"+
//                        "010",
//
//                c = "010\n"+
//                        "101\n"+
//                        "010",
//
//                d = "0707\n"+
//                        "7070\n"+
//                        "0707\n"+
//                        "7070",
//
//                e = "700000\n"+
//                        "077770\n"+
//                        "077770\n"+
//                        "077770\n"+
//                        "077770\n"+
//                        "000007",
//
//                f = "777000\n"+
//                        "007000\n"+
//                        "007000\n"+
//                        "007000\n"+
//                        "007000\n"+
//                        "007777",
//
//                g = "000000\n"+
//                        "000000\n"+
//                        "000000\n"+
//                        "000010\n"+
//                        "000109\n"+
//                        "001010";
//
//        gridE = Finder.toNodeArray(Finder.to2dim(e, "\n", ""));
//        gridB = Finder.toNodeArray(Finder.to2dim(b, "\n", ""));
//    }

// Check getNeighbours method
// Should retrieve neighbours while staying in the boundaries of the grid
//    @Test
//    void getNeighboursTest() {
//
//        selectedNode = new Node(true, new int[]{2, 2}, 2, 2);
//        Node[] correctNeighbours = {gridE[1][2], gridE[3][2], gridE[2][1], gridE[2][3]};
//
//        ArrayList<Node> neighBoorsList = Finder.getNeighbours(selectedNode, gridE);
//
//        assertThat(neighBoorsList).containsAll(Arrays.asList(correctNeighbours));
//        assertThat(neighBoorsList).doesNotContain(gridE[0][0]);
//
//        // Nodes on the edge should have 3 neighbours
//        selectedNode = new Node(true, new int[]{3, 5}, 5, 3);
//        assertThat(Finder.getNeighbours(selectedNode, gridE)).hasSize(3);
//
//        // and 2 for nodes in corners
//        selectedNode = new Node(true, new int[]{5, 0}, 0, 5);
//        assertThat(Finder.getNeighbours(selectedNode, gridE)).hasSize(2);
//
//
//    }

// Check if distances between two nodes correct
//    @Test
//    void getDistanceTest() {
//        Node nodeStart = gridE[0][0],
//                nodeA = gridE[1][3],
//                nodeB = gridE[3][5],
//                nodeC = gridE[5][1],
//                nodeEnd = gridE[5][5];
//
//        assertThat(Finder.getDistance(nodeStart, nodeEnd)).isEqualTo(10);
//        assertThat(Finder.getDistance(nodeA, nodeB)).isEqualTo(4);
//        assertThat(Finder.getDistance(nodeA, nodeC)).isEqualTo(6);
//        assertThat(Finder.getDistance(nodeC, nodeA)).isEqualTo(6);
//        assertThat(Finder.getDistance(nodeC, nodeB)).isEqualTo(6);
//
//    }