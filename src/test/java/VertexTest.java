import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

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
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        Assert.assertThat(graph.vertex[0].Value, is(0));
        Assert.assertThat(graph.vertex[1].Value, is(1));
        Assert.assertThat(graph.vertex[2].Value, is(2));
        Assert.assertThat(graph.vertex[3].Value, is(3));
        Assert.assertThat(graph.vertex[4].Value, is(4));
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);
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
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        Assert.assertThat(graph.vertex[0].Value, is(0));
        Assert.assertThat(graph.vertex[1].Value, is(1));
        Assert.assertThat(graph.vertex[2].Value, is(2));
        Assert.assertThat(graph.vertex[3].Value, is(3));
        Assert.assertThat(graph.vertex[4].Value, is(4));

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
            graph.AddEdge(0, 1);
            graph.AddEdge(0, 2);
            graph.AddEdge(0, 3);
            graph.AddEdge(1, 3);
            graph.AddEdge(1, 4);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 3);
            graph.AddEdge(3, 4);
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
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(graph.IsEdge(0, 0), is(false));
            Assert.assertThat(graph.IsEdge(0, 1), is(false));
            Assert.assertThat(graph.IsEdge(0, 2), is(false));
            Assert.assertThat(graph.IsEdge(0, 3), is(false));
            Assert.assertThat(graph.IsEdge(0, 4), is(false));

            Assert.assertThat(graph.IsEdge(1, 0), is(false));
            Assert.assertThat(graph.IsEdge(1, 1), is(false));
            Assert.assertThat(graph.IsEdge(1, 2), is(false));
            Assert.assertThat(graph.IsEdge(1, 3), is(false));
            Assert.assertThat(graph.IsEdge(1, 4), is(false));

            Assert.assertThat(graph.IsEdge(2, 0), is(false));
            Assert.assertThat(graph.IsEdge(2, 1), is(false));
            Assert.assertThat(graph.IsEdge(2, 2), is(false));
            Assert.assertThat(graph.IsEdge(2, 3), is(false));
            Assert.assertThat(graph.IsEdge(2, 4), is(false));

            Assert.assertThat(graph.IsEdge(3, 0), is(false));
            Assert.assertThat(graph.IsEdge(3, 1), is(false));
            Assert.assertThat(graph.IsEdge(3, 2), is(false));
            Assert.assertThat(graph.IsEdge(3, 3), is(false));
            Assert.assertThat(graph.IsEdge(3, 4), is(false));

            Assert.assertThat(graph.IsEdge(4, 0), is(false));
            Assert.assertThat(graph.IsEdge(4, 1), is(false));
            Assert.assertThat(graph.IsEdge(4, 2), is(false));
            Assert.assertThat(graph.IsEdge(4, 3), is(false));
            Assert.assertThat(graph.IsEdge(4, 4), is(false));
        }
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);

        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(graph.IsEdge(0, 0), is(false));
            Assert.assertThat(graph.IsEdge(0, 1), is(true));
            Assert.assertThat(graph.IsEdge(0, 2), is(true));
            Assert.assertThat(graph.IsEdge(0, 3), is(true));
            Assert.assertThat(graph.IsEdge(0, 4), is(false));

            Assert.assertThat(graph.IsEdge(1, 0), is(true));
            Assert.assertThat(graph.IsEdge(1, 1), is(false));
            Assert.assertThat(graph.IsEdge(1, 2), is(false));
            Assert.assertThat(graph.IsEdge(1, 3), is(true));
            Assert.assertThat(graph.IsEdge(1, 4), is(true));

            Assert.assertThat(graph.IsEdge(2, 0), is(true));
            Assert.assertThat(graph.IsEdge(2, 1), is(false));
            Assert.assertThat(graph.IsEdge(2, 2), is(false));
            Assert.assertThat(graph.IsEdge(2, 3), is(true));
            Assert.assertThat(graph.IsEdge(2, 4), is(false));

            Assert.assertThat(graph.IsEdge(3, 0), is(true));
            Assert.assertThat(graph.IsEdge(3, 1), is(true));
            Assert.assertThat(graph.IsEdge(3, 2), is(true));
            Assert.assertThat(graph.IsEdge(3, 3), is(true));
            Assert.assertThat(graph.IsEdge(3, 4), is(true));

            Assert.assertThat(graph.IsEdge(4, 0), is(false));
            Assert.assertThat(graph.IsEdge(4, 1), is(true));
            Assert.assertThat(graph.IsEdge(4, 2), is(false));
            Assert.assertThat(graph.IsEdge(4, 3), is(true));
            Assert.assertThat(graph.IsEdge(4, 4), is(false));
        }
    }

    @Test
    public void defaultUnEdgeVertexAddTest() {
        SimpleGraph graph = new SimpleGraph(6);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);


        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);

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
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);


        graph.RemoveEdge(0, 1);
        Assert.assertThat(graph.m_adjacency[1][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(0));
        graph.RemoveEdge(0, 2);
        Assert.assertThat(graph.m_adjacency[2][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][2], is(0));
        graph.RemoveEdge(0, 3);
        Assert.assertThat(graph.m_adjacency[3][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][3], is(0));
        graph.RemoveEdge(1, 3);
        Assert.assertThat(graph.m_adjacency[1][3], is(0));
        Assert.assertThat(graph.m_adjacency[3][1], is(0));
        graph.RemoveEdge(1, 4);
        Assert.assertThat(graph.m_adjacency[1][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(0));
        graph.RemoveEdge(2, 3);
        Assert.assertThat(graph.m_adjacency[2][3], is(0));
        Assert.assertThat(graph.m_adjacency[3][2], is(0));
        graph.RemoveEdge(3, 4);
        Assert.assertThat(graph.m_adjacency[3][4], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(0));
    }

    @Test
    public void defaultRemoveVertexTest() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);

        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(1));
        Assert.assertThat(graph.m_adjacency[0][3], is(0));
        Assert.assertThat(graph.m_adjacency[0][4], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(1));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(1));
        Assert.assertThat(graph.m_adjacency[1][3], is(0));
        Assert.assertThat(graph.m_adjacency[1][4], is(1));

        Assert.assertThat(graph.m_adjacency[2][0], is(1));
        Assert.assertThat(graph.m_adjacency[2][1], is(1));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(1));
        Assert.assertThat(graph.m_adjacency[2][4], is(0));

        Assert.assertThat(graph.m_adjacency[3][0], is(0));
        Assert.assertThat(graph.m_adjacency[3][1], is(0));
        Assert.assertThat(graph.m_adjacency[3][2], is(1));
        Assert.assertThat(graph.m_adjacency[3][3], is(0));
        Assert.assertThat(graph.m_adjacency[3][4], is(1));

        Assert.assertThat(graph.m_adjacency[4][0], is(0));
        Assert.assertThat(graph.m_adjacency[4][1], is(1));
        Assert.assertThat(graph.m_adjacency[4][2], is(0));
        Assert.assertThat(graph.m_adjacency[4][3], is(1));
        Assert.assertThat(graph.m_adjacency[4][4], is(0));

        graph.RemoveVertex(1);
        Assert.assertThat(graph.m_adjacency[0][0], is(0));
        Assert.assertThat(graph.m_adjacency[0][1], is(1));
        Assert.assertThat(graph.m_adjacency[0][2], is(0));
        Assert.assertThat(graph.m_adjacency[0][3], is(0));

        Assert.assertThat(graph.m_adjacency[1][0], is(1));
        Assert.assertThat(graph.m_adjacency[1][1], is(0));
        Assert.assertThat(graph.m_adjacency[1][2], is(1));
        Assert.assertThat(graph.m_adjacency[1][3], is(0));

        Assert.assertThat(graph.m_adjacency[2][0], is(0));
        Assert.assertThat(graph.m_adjacency[2][1], is(1));
        Assert.assertThat(graph.m_adjacency[2][2], is(0));
        Assert.assertThat(graph.m_adjacency[2][3], is(1));

        Assert.assertThat(graph.m_adjacency[3][0], is(0));
        Assert.assertThat(graph.m_adjacency[3][1], is(0));
        Assert.assertThat(graph.m_adjacency[3][2], is(1));
        Assert.assertThat(graph.m_adjacency[3][3], is(0));
    }

    @Test
    public void defaultDepthTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 5);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.DepthFirstSearch(0, 6);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[6]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));

        ArrayList<Vertex> expected2 = new ArrayList<>();
        ArrayList<Vertex> actual2 = graph.DepthFirstSearch(1, 6);
        expected2.add(graph.vertex[1]);
        expected2.add(graph.vertex[4]);
        expected2.add(graph.vertex[6]);
        Assert.assertThat(actual2.get(0).Value, is(expected2.get(0).Value));
        Assert.assertThat(actual2.get(1).Value, is(expected2.get(1).Value));
        Assert.assertThat(actual2.get(2).Value, is(expected2.get(2).Value));

    }

    @Test
    public void betweenDepthTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 5);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.DepthFirstSearch(3, 6);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[6]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));
    }

    @Test
    public void twoVertexDepthTest() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddEdge(0, 1);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.DepthFirstSearch(0, 1);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
    }

    @Test
    public void unrelatedVertexDepthTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 5);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);
        ArrayList<Vertex> actual = graph.DepthFirstSearch(0, 3);
        Assert.assertThat(actual.size(), is(0));
    }

    @Test
    public void twoVertexQueueDepthTest() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddEdge(0, 1);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 1);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
    }

    @Test
    public void defaultVertexQueueDepthTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 5);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(3, 6);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[6]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));
    }

    @Test
    public void unrelatedVertexQueueTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 5);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 3);
        Assert.assertThat(actual.size(), is(0));
    }

    @Test
    public void twoVertexQueueTest() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddEdge(0, 1);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 1);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
    }

    @Test
    public void betweenQueueTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(1, 5);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(3, 6);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[6]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));
    }

    @Test
    public void Queue1To3WithoutEdgeTest() {
        SimpleGraph graph = new SimpleGraph(4);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        //graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(1, 3);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[2]);
        expected.add(graph.vertex[3]);

        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));
    }

    @Test
    public void Queue1To3WithEdgeTest() {
        SimpleGraph graph = new SimpleGraph(4);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(1, 3);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[2]);
        expected.add(graph.vertex[3]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
    }

    @Test
    public void Queue1To2Test() {
        SimpleGraph graph = new SimpleGraph(4);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(1, 2);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[2]);

        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
    }

    @Test
    public void circleQueueTest() {
        SimpleGraph graph = new SimpleGraph(6);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 5);


        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(3, 5);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[5]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));
    }

    @Test
    public void defaultQueueTest() {
        SimpleGraph graph = new SimpleGraph(8);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 7);
        graph.AddEdge(5, 6);
        graph.AddEdge(6, 7);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 4);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
    }

    @Test
    public void oneVertexCircleQueueTest() {
        SimpleGraph graph = new SimpleGraph(8);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 7);
        graph.AddEdge(5, 6);
        graph.AddEdge(6, 7);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(3, 3);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[3]);
        Assert.assertThat(actual.size(), is(2));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(0).Value));
    }

    @Test
    public void zeroToSevenQueueTest() {
        SimpleGraph graph = new SimpleGraph(8);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 7);
        graph.AddEdge(5, 6);
        graph.AddEdge(6, 7);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 7);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[7]);
        Assert.assertThat(actual.size(), is(4));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
        Assert.assertThat(actual.get(3).Value, is(expected.get(3).Value));
    }

    @Test
    public void oneToSevenQueueTest() {
        SimpleGraph graph = new SimpleGraph(8);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);

        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 1);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);

        Assert.assertThat(actual.size(), is(2));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
    }

    @Test
    public void oneToThreeQueueTest() {
        SimpleGraph graph = new SimpleGraph(8);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);

        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 4);
        graph.AddEdge(3, 4);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.BreadthFirstSearch(0, 3);
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[3]);

        Assert.assertThat(actual.size(), is(3));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
        Assert.assertThat(actual.get(2).Value, is(expected.get(2).Value));
    }

    @Test
    public void defaultWeakVerticesTest() {
        SimpleGraph graph = new SimpleGraph(9);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);
        graph.AddVertex(8);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 4);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 0);
        graph.AddEdge(5, 2);
        graph.AddEdge(5, 6);
        graph.AddEdge(5, 7);
        graph.AddEdge(7, 6);
        graph.AddEdge(7, 8);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.WeakVertices();
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[8]);
        Assert.assertThat(actual.size(), is(2));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));

    }

    @Test
    public void defaultWithoutWeakVerticesTest() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 2);
        graph.AddEdge(4, 5);
        graph.AddEdge(4, 6);
        graph.AddEdge(5, 6);

        ArrayList<Vertex> actual = graph.WeakVertices();
        Assert.assertThat(actual.size(), is(0));

    }

    @Test
    public void oneVertexWeakVerticesTest() {
        SimpleGraph graph = new SimpleGraph(4);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);
        graph.AddEdge(0, 3);
        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.WeakVertices();
        expected.add(graph.vertex[3]);
        Assert.assertThat(actual.size(), is(1));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
    }

    @Test
    public void zeroVertexWithTriangleWeakTest() {
        SimpleGraph graph = new SimpleGraph(3);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 2);

        ArrayList<Vertex> expected = new ArrayList<>();
        ArrayList<Vertex> actual = graph.WeakVertices();
        Assert.assertThat(actual.size(), is(0));
    }

    @Test
    public void twoVertexWeakTest() {
        SimpleGraph graph = new SimpleGraph(2);
        graph.AddVertex(0);
        graph.AddVertex(1);

        graph.AddEdge(0, 1);
        ArrayList<Vertex> expected = new ArrayList<>();
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        ArrayList<Vertex> actual = graph.WeakVertices();
        Assert.assertThat(actual.size(), is(2));
        Assert.assertThat(actual.get(0).Value, is(expected.get(0).Value));
        Assert.assertThat(actual.get(1).Value, is(expected.get(1).Value));
    }

    @Test
    public void overVertexWithoutEdgeWeakTest() {
        SimpleGraph graph = new SimpleGraph(1000);
        for (int i = 0; i < 1000; i++) {
            graph.AddVertex(i);
        }
        ArrayList<Vertex> expected = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            expected.add(graph.vertex[i]);
        }
        ArrayList<Vertex> actual = graph.WeakVertices();
        Assert.assertThat(actual.size(), is(1000));
        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(actual.get(i).Value, is(expected.get(i).Value));
        }
    }

    @Test
    public void overVertexWithEdgeWeakTest() {
        SimpleGraph graph = new SimpleGraph(1000);
        for (int i = 0; i < 1000; i++) {
            graph.AddVertex(i);
        }

        int i = 0;
        for (int k = 1; k < 1000; k++) {
            graph.AddEdge(i, k);
            i++;
        }
        ArrayList<Vertex> expected = new ArrayList<>();
        for (int j = 0; j < 1000; j++) {
            expected.add(graph.vertex[j]);
        }
        ArrayList<Vertex> actual = graph.WeakVertices();
        Assert.assertThat(actual.size(), is(1000));
        for (int l = 0; l < 1000; l++) {
            Assert.assertThat(actual.get(l).Value, is(expected.get(l).Value));
        }
    }
}