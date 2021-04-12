
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AlgorithmsDataStructures2Test {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(array);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
