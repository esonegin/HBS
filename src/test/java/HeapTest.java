
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class HeapTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddTest() {

        int[] array = {12, 8, 4, 6, 2, 14, 10};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);

        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(12));
        Assert.assertThat(heap.HeapArray[2], is(10));
        Assert.assertThat(heap.HeapArray[3], is(8));
        Assert.assertThat(heap.HeapArray[4], is(6));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(2));
    }

    @Test
    public void errorAddTest() {

        int[] array = {12, 8, 4};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);

        Assert.assertThat(heap.HeapArray[0], is(12));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(4));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

    }

    @Test
    public void randAddTest() {

        int[] array = {8, 4, 12};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);

        Assert.assertThat(heap.HeapArray[0], is(12));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(4));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

    }

    @Test
    public void overDepthAddTest() {

        int[] array = {8, 4, 12, 43, 2};
        Heap heap = new Heap();
        heap.MakeHeap(array, 1);

        Assert.assertThat(heap.HeapArray[0], is(43));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(4));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));
    }

    @Test
    public void over2DepthAddTest() {

        int[] array = {8, 4, 12, 43, 2};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);

        Assert.assertThat(heap.HeapArray[0], is(43));
        Assert.assertThat(heap.HeapArray[1], is(12));
        Assert.assertThat(heap.HeapArray[2], is(8));
        Assert.assertThat(heap.HeapArray[3], is(4));
        Assert.assertThat(heap.HeapArray[4], is(2));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

    }

    @Test
    public void addOverTest() {
        
        Heap heap = new Heap();
        heap.HeapArray = new int[7];
        //heap.MakeHeap(array, 2);

        Assert.assertThat(heap.Add(12) == true, is(true));
        Assert.assertThat(heap.Add(8) == true, is(true));
        Assert.assertThat(heap.Add(4) == true, is(true));
        Assert.assertThat(heap.Add(6) == true, is(true));
        Assert.assertThat(heap.Add(2) == true, is(true));
        Assert.assertThat(heap.Add(14) == true, is(true));
        Assert.assertThat(heap.Add(10) == true, is(true));
        
        for(int i = 0; i < 1000; i++){
            Assert.assertThat(heap.Add(i) == false, is(true));
        }

        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(12));
        Assert.assertThat(heap.HeapArray[2], is(10));
        Assert.assertThat(heap.HeapArray[3], is(8));
        Assert.assertThat(heap.HeapArray[4], is(6));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(2));
    }

    @Test
    public void delMaxDefTEst() {

        int[] array = {12, 8, 4, 6, 2, 14, 10};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);

        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(12));
        Assert.assertThat(heap.HeapArray[2], is(10));
        Assert.assertThat(heap.HeapArray[3], is(8));
        Assert.assertThat(heap.HeapArray[4], is(6));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(2));
    }

    @Test
    public void getMaxDefTest() {

        int[] array = {12, 8, 4, 6, 2, 14, 10};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);

        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(12));
        Assert.assertThat(heap.HeapArray[2], is(10));
        Assert.assertThat(heap.HeapArray[3], is(8));
        Assert.assertThat(heap.HeapArray[4], is(6));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(2));

        Assert.assertThat(heap.GetMax(), is(14));
        Assert.assertThat(heap.HeapArray[0], is(12));
        Assert.assertThat(heap.HeapArray[1], is(10));
        Assert.assertThat(heap.HeapArray[2], is(8));
        Assert.assertThat(heap.HeapArray[3], is(6));
        Assert.assertThat(heap.HeapArray[4], is(4));
        Assert.assertThat(heap.HeapArray[5], is(2));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(12));
        Assert.assertThat(heap.HeapArray[0], is(10));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(6));
        Assert.assertThat(heap.HeapArray[3], is(4));
        Assert.assertThat(heap.HeapArray[4], is(2));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(10));
        Assert.assertThat(heap.HeapArray[0], is(8));
        Assert.assertThat(heap.HeapArray[1], is(6));
        Assert.assertThat(heap.HeapArray[2], is(4));
        Assert.assertThat(heap.HeapArray[3], is(2));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(8));
        Assert.assertThat(heap.HeapArray[0], is(6));
        Assert.assertThat(heap.HeapArray[1], is(4));
        Assert.assertThat(heap.HeapArray[2], is(2));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(6));
        Assert.assertThat(heap.HeapArray[0], is(4));
        Assert.assertThat(heap.HeapArray[1], is(2));
        Assert.assertThat(heap.HeapArray[2], is(0));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(4));
        Assert.assertThat(heap.HeapArray[0], is(2));
        Assert.assertThat(heap.HeapArray[1], is(0));
        Assert.assertThat(heap.HeapArray[2], is(0));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(2));
        Assert.assertThat(heap.HeapArray[0], is(0));
        Assert.assertThat(heap.HeapArray[1], is(0));
        Assert.assertThat(heap.HeapArray[2], is(0));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

        Assert.assertThat(heap.GetMax(), is(-1));
        Assert.assertThat(heap.HeapArray[0], is(0));
        Assert.assertThat(heap.HeapArray[1], is(0));
        Assert.assertThat(heap.HeapArray[2], is(0));
        Assert.assertThat(heap.HeapArray[3], is(0));
        Assert.assertThat(heap.HeapArray[4], is(0));
        Assert.assertThat(heap.HeapArray[5], is(0));
        Assert.assertThat(heap.HeapArray[6], is(0));

    }

    @Test
    public void errorDefTest() {

        int[] array = {110, 90, 40, 70, 80, 30, 10, 20, 50, 60, 65, 31, 29, 11, 9};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);

        Assert.assertThat(heap.HeapArray[0], is(110));
        Assert.assertThat(heap.HeapArray[1], is(90));
        Assert.assertThat(heap.HeapArray[2], is(40));
        Assert.assertThat(heap.HeapArray[3], is(70));

    }
}