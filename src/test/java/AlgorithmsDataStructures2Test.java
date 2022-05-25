
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
        int[] array = {12, 8, 4, 6, 2, 14, 10};
        int[] result = AlgorithmsDataStructures2.generateBBSTArray(array);


        Assert.assertThat(result[0], is(8));
        Assert.assertThat(result[1], is(4));
        Assert.assertThat(result[2], is(12));
        Assert.assertThat(result[3], is(2));
        Assert.assertThat(result[4], is(6));
        Assert.assertThat(result[5], is(10));
        Assert.assertThat(result[6], is(14));


    }
}
