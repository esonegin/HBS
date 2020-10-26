import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class TransformTransformTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }
    @Test
    public void error2() throws Exception {
        //1
        boolean actual = Level1.TransformTransform(new Integer[]{3,2,1}, 3);
        //res = 58
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void error1() throws Exception {
        //1
        boolean actual = Level1.TransformTransform(new Integer[]{1,2,1,7,2,4,3,1,5,1,2,1,6,1,2}, 15);;
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

}