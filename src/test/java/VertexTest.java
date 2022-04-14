
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class VertexTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddTest() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        Assert.assertThat(graph.vertex[0].Value, is(1));
        Assert.assertThat(graph.vertex[1].Value, is(2));
        Assert.assertThat(graph.vertex[2].Value, is(3));
        Assert.assertThat(graph.vertex[3].Value, is(4));
        Assert.assertThat(graph.vertex[4].Value, is(5));
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 5);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 4);
        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(1));
        Assert.assertThat(graph.m_adjacency[0][3], is(1));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(1));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(0));
        Assert.assertThat(graph.m_adjacency[1][3], is(1));
        Assert.assertThat(graph.m_adjacency[1][4], is(1));

        Assert.assertThat(graph.m_adjacency[2][0], is(1));
        Assert.assertThat(graph.m_adjacency[2][1], is(0));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(1));
        Assert.assertThat(graph.m_adjacency[2][4], is(0));

        Assert.assertThat(graph.m_adjacency[3][0], is(1));
        Assert.assertThat(graph.m_adjacency[3][1], is(1));
        Assert.assertThat(graph.m_adjacency[3][2], is(1));
        Assert.assertThat(graph.m_adjacency[3][3], is(1));
        Assert.assertThat(graph.m_adjacency[3][4], is(1));

        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(1));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(1));
        Assert.assertThat(graph.m_adjacency[4][4], is(0));
    }

    @Test
    public void overAddVertexAddTest() {
        SimpleGraph graph = new SimpleGraph(5);
        for (int i = 0; i < 1000; i++) {
            graph.AddVertex(1);
            graph.AddVertex(2);
            graph.AddVertex(3);
            graph.AddVertex(4);
            graph.AddVertex(5);
        }
        Assert.assertThat(graph.vertex[0].Value, is(1));
        Assert.assertThat(graph.vertex[1].Value, is(2));
        Assert.assertThat(graph.vertex[2].Value, is(3));
        Assert.assertThat(graph.vertex[3].Value, is(4));
        Assert.assertThat(graph.vertex[4].Value, is(5));
    }

    @Test
    public void overAddEdgeAddTest() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        Assert.assertThat(graph.vertex[0].Value, is(1));
        Assert.assertThat(graph.vertex[1].Value, is(2));
        Assert.assertThat(graph.vertex[2].Value, is(3));
        Assert.assertThat(graph.vertex[3].Value, is(4));
        Assert.assertThat(graph.vertex[4].Value, is(5));

        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(0));
        Assert.assertThat(graph.m_adjacency[0][2], is(0));
        Assert.assertThat(graph.m_adjacency[0][3], is(0));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(0));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(0));
        Assert.assertThat(graph.m_adjacency[1][3], is(0));
        Assert.assertThat(graph.m_adjacency[1][4], is(0));

        Assert.assertThat(graph.m_adjacency[2][0], is(0));
        Assert.assertThat(graph.m_adjacency[2][1], is(0));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(0));
        Assert.assertThat(graph.m_adjacency[2][4], is(0));

        Assert.assertThat(graph.m_adjacency[3][0], is(0));
        Assert.assertThat(graph.m_adjacency[3][1], is(0));
        Assert.assertThat(graph.m_adjacency[3][2], is(0));
        Assert.assertThat(graph.m_adjacency[3][3], is(0));
        Assert.assertThat(graph.m_adjacency[3][4], is(0));

        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(0));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(0));
        Assert.assertThat(graph.m_adjacency[4][4], is(0));
        for (int i = 0; i < 1000; i++) {
            graph.AddEdge(1, 2);
            graph.AddEdge(1, 4);
            graph.AddEdge(1, 3);
            graph.AddEdge(2, 5);
            graph.AddEdge(2, 4);
            graph.AddEdge(3, 4);
            graph.AddEdge(4, 5);
            graph.AddEdge(4, 4);
        }
        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(1));
        Assert.assertThat(graph.m_adjacency[0][3], is(1));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(1));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(0));
        Assert.assertThat(graph.m_adjacency[1][3], is(1));
        Assert.assertThat(graph.m_adjacency[1][4], is(1));

        Assert.assertThat(graph.m_adjacency[2][0], is(1));
        Assert.assertThat(graph.m_adjacency[2][1], is(0));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(1));
        Assert.assertThat(graph.m_adjacency[2][4], is(0));

        Assert.assertThat(graph.m_adjacency[3][0], is(1));
        Assert.assertThat(graph.m_adjacency[3][1], is(1));
        Assert.assertThat(graph.m_adjacency[3][2], is(1));
        Assert.assertThat(graph.m_adjacency[3][3], is(1));
        Assert.assertThat(graph.m_adjacency[3][4], is(1));

        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(1));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(1));
        Assert.assertThat(graph.m_adjacency[4][4], is(0));
    }

    @Test
    public void defaultIsEdgeTest() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 5);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 4);

        for(int i = 0; i < 1000; i++) {
            Assert.assertThat(graph.IsEdge(1, 1), is(false));
            Assert.assertThat(graph.IsEdge(1, 2), is(true));
            Assert.assertThat(graph.IsEdge(1, 3), is(true));
            Assert.assertThat(graph.IsEdge(1, 4), is(true));
            Assert.assertThat(graph.IsEdge(1, 5), is(false));

            Assert.assertThat(graph.IsEdge(2, 1), is(true));
            Assert.assertThat(graph.IsEdge(2, 2), is(false));
            Assert.assertThat(graph.IsEdge(2, 3), is(false));
            Assert.assertThat(graph.IsEdge(2, 4), is(true));
            Assert.assertThat(graph.IsEdge(2, 5), is(true));

            Assert.assertThat(graph.IsEdge(3, 1), is(true));
            Assert.assertThat(graph.IsEdge(3, 2), is(false));
            Assert.assertThat(graph.IsEdge(3, 3), is(false));
            Assert.assertThat(graph.IsEdge(3, 4), is(true));
            Assert.assertThat(graph.IsEdge(3, 5), is(false));

            Assert.assertThat(graph.IsEdge(4, 1), is(true));
            Assert.assertThat(graph.IsEdge(4, 2), is(true));
            Assert.assertThat(graph.IsEdge(4, 3), is(true));
            Assert.assertThat(graph.IsEdge(4, 4), is(true));
            Assert.assertThat(graph.IsEdge(4, 5), is(true));

            Assert.assertThat(graph.IsEdge(5, 1), is(false));
            Assert.assertThat(graph.IsEdge(5, 2), is(true));
            Assert.assertThat(graph.IsEdge(5, 3), is(false));
            Assert.assertThat(graph.IsEdge(5, 4), is(true));
            Assert.assertThat(graph.IsEdge(5, 5), is(false));
        }
    }

    @Test
    public void defaultUnEdgeVertexAddTest() {
        SimpleGraph graph = new SimpleGraph(6);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);


        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 5);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 4);

        graph.AddVertex(6);

        Assert.assertThat(graph.vertex.length, is(6));

        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(1));
        Assert.assertThat(graph.m_adjacency[0][3], is(1));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));
        Assert.assertThat(graph.m_adjacency[0][5], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(1));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(0));
        Assert.assertThat(graph.m_adjacency[1][3], is(1));
        Assert.assertThat(graph.m_adjacency[1][4], is(1));
        Assert.assertThat(graph.m_adjacency[1][5], is(0));

        Assert.assertThat(graph.m_adjacency[2][0], is(1));
        Assert.assertThat(graph.m_adjacency[2][1], is(0));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(1));
        Assert.assertThat(graph.m_adjacency[2][4], is(0));
        Assert.assertThat(graph.m_adjacency[2][5], is(0));

        Assert.assertThat(graph.m_adjacency[3][0], is(1));
        Assert.assertThat(graph.m_adjacency[3][1], is(1));
        Assert.assertThat(graph.m_adjacency[3][2], is(1));
        Assert.assertThat(graph.m_adjacency[3][3], is(1));
        Assert.assertThat(graph.m_adjacency[3][4], is(1));
        Assert.assertThat(graph.m_adjacency[3][5], is(0));

        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(1));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(1));
        Assert.assertThat(graph.m_adjacency[4][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][5], is(0));

    }

    @Test
    public void defaultRemoveEdgeAddTest() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);

        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 5);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 4);

        Assert.assertThat(graph.vertex[0].Value, is(1));
        Assert.assertThat(graph.vertex[1].Value, is(2));
        Assert.assertThat(graph.vertex[2].Value, is(3));
        Assert.assertThat(graph.vertex[3].Value, is(4));
        Assert.assertThat(graph.vertex[4].Value, is(5));


        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(1));
        Assert.assertThat(graph.m_adjacency[0][3], is(1));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(1));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(0));
        Assert.assertThat(graph.m_adjacency[1][3], is(1));
        Assert.assertThat(graph.m_adjacency[1][4], is(1));

        Assert.assertThat(graph.m_adjacency[2][0], is(1));
        Assert.assertThat(graph.m_adjacency[2][1], is(0));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(1));
        Assert.assertThat(graph.m_adjacency[2][4], is(0));

        Assert.assertThat(graph.m_adjacency[3][0], is(1));
        Assert.assertThat(graph.m_adjacency[3][1], is(1));
        Assert.assertThat(graph.m_adjacency[3][2], is(1));
        Assert.assertThat(graph.m_adjacency[3][3], is(1));
        Assert.assertThat(graph.m_adjacency[3][4], is(1));

        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(1));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(1));
        Assert.assertThat(graph.m_adjacency[4][4], is(0));

        graph.RemoveEdge(2, 1);
        Assert.assertThat(graph.m_adjacency[1][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(0));
        graph.RemoveEdge(3, 1);
        Assert.assertThat(graph.m_adjacency[2][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][2], is(0));
        graph.RemoveEdge(4, 1);
        Assert.assertThat(graph.m_adjacency[3][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][3], is(0));

        graph.RemoveEdge(1, 5);
        Assert.assertThat(graph.m_adjacency[0][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        graph.RemoveEdge(2, 5);
        Assert.assertThat(graph.m_adjacency[1][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(0));
        graph.RemoveEdge(3, 5);
        Assert.assertThat(graph.m_adjacency[2][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        graph.RemoveEdge(4, 5);
        Assert.assertThat(graph.m_adjacency[3][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(0));
        graph.RemoveEdge(5, 5);
        Assert.assertThat(graph.m_adjacency[4][4], is(0));
    }

    @Test
    public void defaultRemoveVertexTest() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);

        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 5);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 4);

        graph.RemoveVertex(1);
        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(1));
        Assert.assertThat(graph.m_adjacency[0][3], is(1));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));

    }
}