
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class SelectionSortTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void defTest() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{10, 1, 8, 7, 6, 3, 4, 3, 2, 9}),
                is(new int[]{1, 2, 3 ,3, 4, 6, 7, 8, 9, 10}));
    }
    @Test
    public void allZeroTest() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{0, 0, 0, 0, 0}),
                is(new int[]{0, 0, 0, 0, 0}));
    }
    @Test
    public void pogrLeft() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{1, 0, 0, 0, 0}),
                is(new int[]{0, 0, 0, 0, 1}));
    }
    @Test
    public void pogrRight() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{0, 0, 0, 0, 1}),
                is(new int[]{0, 0, 0, 0, 1}));
    }
    @Test
    public void tischaTest() {
        int[] tis = new int[100];
        for(int i = 0; i < tis.length; i++){
            tis[i] = i + 1;
        }
        tis[99] = 0;
        Assert.assertThat(SelectionSort.selectionSort(tis),
                is(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                        11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                        31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                        41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                        51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                        61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
                        71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                        81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                        91, 92, 93, 94, 95, 96, 97, 98, 99}));
    }
    @Test
    public void zeroTest() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{0}),
                is(new int[]{0}));
    }
    @Test
    public void dvaOdinakTest() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{2, 2}),
                is(new int[]{2, 2}));
    }
    @Test
    public void dvaRaznTest() {
        Assert.assertThat(SelectionSort.selectionSort(new int[]{3, 2}),
                is(new int[]{2, 3}));
    }
}