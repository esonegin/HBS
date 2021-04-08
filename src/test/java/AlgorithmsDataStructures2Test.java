
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class AlgorithmsDataStructures2Test {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddTest() {
        AlgorithmsDataStructures2 tree = new AlgorithmsDataStructures2();
        int[] array = new int[]{12, 8, 4, 6, 2, 14, 10};


        for (int i = 0; i < array.length; i++) {
            System.out.println(tree.GenerateBBSTArray(array)[i]);
        }
    }
}
