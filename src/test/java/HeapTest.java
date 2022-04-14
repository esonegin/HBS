
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
        heap.MakeHeap(array, 3);

        Assert.assertThat(heap.HeapArray.length, is(7));
        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(12));
        Assert.assertThat(heap.HeapArray[3], is(6));
        Assert.assertThat(heap.HeapArray[4], is(2));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(10));

    }

    @Test
    public void defaultOver1DepthAddTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10, 11};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);
        Assert.assertThat(heap.HeapArray.length, is(3));
        Assert.assertThat(heap.HeapArray[0], is(12));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(4));
        Assert.assertThat(heap.Add(11), is(false));
        Assert.assertThat(heap.HeapArray.length, is(3));
    }

    @Test
    public void defaultOver2DepthAddTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10, 11};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);
        Assert.assertThat(heap.HeapArray.length, is(3));
        Assert.assertThat(heap.HeapArray[0], is(12));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(4));
        Assert.assertThat(heap.Add(11), is(false));
        Assert.assertThat(heap.HeapArray.length, is(3));
    }

    @Test
    public void defaultOver3DepthAddTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10, 11};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);
        Assert.assertThat(heap.HeapArray.length, is(7));
        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(12));
        Assert.assertThat(heap.HeapArray[3], is(6));
        Assert.assertThat(heap.HeapArray[4], is(2));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(10));
        Assert.assertThat(heap.Add(11), is(false));
        Assert.assertThat(heap.HeapArray.length, is(7));
    }

    @Test
    public void default3DepthAddTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10, 11};
        Heap heap = new Heap();
        heap.MakeHeap(array, 4);
        Assert.assertThat(heap.HeapArray.length, is(8));
        Assert.assertThat(heap.HeapArray[0], is(14));
        Assert.assertThat(heap.HeapArray[1], is(11));
        Assert.assertThat(heap.HeapArray[2], is(12));
        Assert.assertThat(heap.HeapArray[3], is(8));
        Assert.assertThat(heap.HeapArray[4], is(2));
        Assert.assertThat(heap.HeapArray[5], is(4));
        Assert.assertThat(heap.HeapArray[6], is(10));
        Assert.assertThat(heap.HeapArray[7], is(6));
        Assert.assertThat(heap.Add(11), is(false));
        Assert.assertThat(heap.HeapArray.length, is(8));
    }



    @Test
    public void everyStepUpAddTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);
        Assert.assertThat(heap.HeapArray[0], is(7));
        Assert.assertThat(heap.HeapArray[1], is(4));
        Assert.assertThat(heap.HeapArray[2], is(6));
        Assert.assertThat(heap.HeapArray[3], is(1));
        Assert.assertThat(heap.HeapArray[4], is(3));
        Assert.assertThat(heap.HeapArray[5], is(2));
        Assert.assertThat(heap.HeapArray[6], is(5));
    }

    @Test
    public void getMaxOverTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);
        Assert.assertThat(heap.HeapArray.length, is(3));
        Assert.assertThat(heap.HeapArray[0], is(12));
        Assert.assertThat(heap.HeapArray[1], is(8));
        Assert.assertThat(heap.HeapArray[2], is(4));

        Assert.assertThat(heap.GetMax(), is(12));
        Assert.assertThat(heap.HeapArray.length, is(2));
        Assert.assertThat(heap.HeapArray[0], is(8));
        Assert.assertThat(heap.HeapArray[1], is(4));

    }

    @Test
    public void getMaxEveryStepTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);

        Assert.assertThat(heap.HeapArray.length, is(7));
        Assert.assertThat(heap.HeapArray[0], is(7));
        Assert.assertThat(heap.HeapArray[1], is(4));
        Assert.assertThat(heap.HeapArray[2], is(6));
        Assert.assertThat(heap.HeapArray[3], is(1));
        Assert.assertThat(heap.HeapArray[4], is(3));
        Assert.assertThat(heap.HeapArray[5], is(2));
        Assert.assertThat(heap.HeapArray[6], is(5));

        Assert.assertThat(heap.GetMax(), is(7));
        Assert.assertThat(heap.HeapArray[0], is(6));
        Assert.assertThat(heap.HeapArray[1], is(4));
        Assert.assertThat(heap.HeapArray[2], is(5));
        Assert.assertThat(heap.HeapArray[3], is(1));
        Assert.assertThat(heap.HeapArray[4], is(3));
        Assert.assertThat(heap.HeapArray[5], is(2));
    }

    @Test
    public void getMaxEveryStepReverseTest() {
        int[] array = {7, 6, 5, 4, 3, 2, 1};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);
        Assert.assertThat(heap.HeapArray[0], is(7));
        Assert.assertThat(heap.HeapArray[1], is(6));
        Assert.assertThat(heap.HeapArray[2], is(5));
        Assert.assertThat(heap.HeapArray[3], is(4));
        Assert.assertThat(heap.HeapArray[4], is(3));
        Assert.assertThat(heap.HeapArray[5], is(2));
        Assert.assertThat(heap.HeapArray[6], is(1));
        Assert.assertThat(heap.GetMax(), is(7));
        Assert.assertThat(heap.HeapArray[0], is(6));
        Assert.assertThat(heap.HeapArray[1], is(4));
        Assert.assertThat(heap.HeapArray[2], is(5));
        Assert.assertThat(heap.HeapArray[3], is(1));
        Assert.assertThat(heap.HeapArray[4], is(3));
        Assert.assertThat(heap.HeapArray[5], is(2));
    }

    @Test
    public void getDifDefaultTest() {
        int[] array = {1, 1, 1, 1, 1, 1, 1};
        Heap heap = new Heap();
        heap.MakeHeap(array, 3);
        Assert.assertThat(heap.HeapArray.length, is(7));
        Assert.assertThat(heap.HeapArray[0], is(1));
        Assert.assertThat(heap.HeapArray[1], is(1));
        Assert.assertThat(heap.HeapArray[2], is(1));
        Assert.assertThat(heap.HeapArray[3], is(1));
        Assert.assertThat(heap.HeapArray[4], is(1));
        Assert.assertThat(heap.HeapArray[5], is(1));
        Assert.assertThat(heap.GetMax(), is(1));
        Assert.assertThat(heap.HeapArray.length, is(6));
        Assert.assertThat(heap.HeapArray[0], is(1));
        Assert.assertThat(heap.HeapArray[1], is(1));
        Assert.assertThat(heap.HeapArray[2], is(1));
        Assert.assertThat(heap.HeapArray[3], is(1));
        Assert.assertThat(heap.HeapArray[4], is(1));
    }

    @Test
    public void getMaxOverDepthStepTest() {
        int[] array = {1, 1, 1, 1, 1, 1, 1};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);
        Assert.assertThat(heap.HeapArray[0], is(1));
        Assert.assertThat(heap.HeapArray[1], is(1));
        Assert.assertThat(heap.HeapArray[2], is(1));
        Assert.assertThat(heap.GetMax(), is(1));
        Assert.assertThat(heap.HeapArray.length, is(2));
        Assert.assertThat(heap.HeapArray[0], is(1));
        Assert.assertThat(heap.HeapArray[1], is(1));
    }

    @Test
    public void det() {

        int[] array = {1, 2, 3, 4};
        Heap heap = new Heap();
        heap.MakeHeap(array, 2);
        Assert.assertThat(heap.HeapArray.length, is(3));
        Assert.assertThat(heap.HeapArray[0], is(3));
        Assert.assertThat(heap.HeapArray[1], is(1));
        Assert.assertThat(heap.HeapArray[2], is(2));

        Assert.assertThat(heap.GetMax(), is(3));
        Assert.assertThat(heap.HeapArray.length, is(2));
        Assert.assertThat(heap.HeapArray[0], is(2));
        Assert.assertThat(heap.HeapArray[1], is(1));

    }


}