
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
        Assert.assertThat(graph.vertex[1].Value, is(1));
        Assert.assertThat(graph.vertex[2].Value, is(1));
        Assert.assertThat(graph.vertex[3].Value, is(1));
        Assert.assertThat(graph.vertex[4].Value, is(1));
       /* int[] array = {12, 8, 4, 6, 2, 14, 10};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);

        Assert.assertThat(heap.HeapArray.length, is(7));
        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(12));
        Assert.assertThat(heap.HeapArray[3], is(6));
        Assert.assertThat(heap.HeapArray[4], is(2));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(10));*/

    }
}