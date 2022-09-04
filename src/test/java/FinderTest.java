import org.example.foo.Finder;
import org.example.foo.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinderTest {

    private static String a,b,c,d,e,f;
    private static Node[][] gridB, gridE;
    private static Node selectedNode;

    @BeforeAll
    static void setup() {

        // Mazes
        a = ".W.\n" +
            ".W.\n" +
            "...";

        b = ".W.\n" +
            ".W.\n" +
            "W..";

        c = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......";

        d = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            ".....W\n" +
            "....W.";

        e = "......\n" +
            "......\n" +
            "...W..\n" +
            ".WWWW.\n" +
            "......\n" +
            "......\n";

        f =     ".W...W\n" +
                ".W.W.W\n" +
                ".W.W.W\n" +
                ".W.W.W\n" +
                ".W.W.W\n" +
                "...W..\n";

        gridE = Finder.toNodeArray(Finder.to2dim(e, "\n", ""));
        gridB = Finder.toNodeArray(Finder.to2dim(b, "\n", ""));
    }

    // Check getNeighbours method
    // Should retrieve neighbours while staying in the boundaries of the grid
    @Test void getNeighboursTest() {

        selectedNode = new Node(true, new int[]{2,2}, 2, 2);
        Node[]correctNeighbours = {gridE[1][2], gridE[3][2], gridE[2][1], gridE[2][3]};

        ArrayList<Node> neighBoorsList = Finder.getNeighbours(selectedNode, gridE);

        assertThat(neighBoorsList).containsAll(Arrays.asList(correctNeighbours));
        assertThat(neighBoorsList).doesNotContain(gridE[0][0]);

        // Nodes on the edge should have 3 neighbours
        selectedNode = new Node(true, new int[]{3,5}, 5, 3);
        assertThat(Finder.getNeighbours(selectedNode, gridE)).hasSize(3);

        // and 2 for nodes in corners
        selectedNode = new Node(true, new int[]{5,0}, 0, 5);
        assertThat(Finder.getNeighbours(selectedNode, gridE)).hasSize(2);


    }

    // Check if distances between two nodes correct
    @Test void getDistanceTest() {
        Node    nodeStart = gridE[0][0],
                nodeA = gridE[1][3],
                nodeB = gridE[3][5],
                nodeC = gridE[5][1],
                nodeEnd = gridE[5][5];

        assertThat(Finder.getDistance(nodeStart, nodeEnd)).isEqualTo(10);
        assertThat(Finder.getDistance(nodeA, nodeB)).isEqualTo(4);
        assertThat(Finder.getDistance(nodeA, nodeC)).isEqualTo(6);
        assertThat(Finder.getDistance(nodeC, nodeA)).isEqualTo(6);
        assertThat(Finder.getDistance(nodeC, nodeB)).isEqualTo(6);

    }

    @Test
    public void sampleTests() {

        assertEquals(true,  Finder.pathFinder(a));
        assertEquals(false, Finder.pathFinder(b));
        assertEquals(true,  Finder.pathFinder(c));
        assertEquals(false, Finder.pathFinder(d));
        assertEquals(true, Finder.pathFinder(e));
        assertEquals(true, Finder.pathFinder(f));
    }
}

