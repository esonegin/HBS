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
    public void ishodnoe1() throws Exception {
        //1
        Level1.TransformTransform(new int[]{1,2,1,7}, 4);
        boolean actual = Level1.TransformTransform(new int[]{1,2,1,7}, 4);;
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void ishodnoe() throws Exception {
        //1
        Level1.TransformTransform(new int[]{1,2,1,7,2,4,3,1,5,1,2,1,6,1,2}, 15);
        boolean actual = Level1.TransformTransform(new int[]{1,2,1,7,2,4,3,1,5,1,2,1,6,1,2}, 15);;
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }
}