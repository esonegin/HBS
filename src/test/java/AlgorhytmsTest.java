import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class AlgorhytmsTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void one() throws Exception {
        //1
        Algorhytms algorhytms = new Algorhytms(new int[]{15, 54, 10, 33, 2, 17, 1});
        String actual = algorhytms.fastSort();
        String expected = "1 2 10 15 17 33 54";
        Assert.assertThat(actual, is(expected));
    }
}