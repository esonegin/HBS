
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
                is(new int[]{1, 2, 3, 3, 4, 6, 7, 8, 9, 10}));
    }
}