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
    public void ishodnoe() throws Exception {
        //1
        MatrixTurn.MatrixTurn(new String[]{"123456", "234567", "345678", "456789"}, 4, 6, 1);
        String[] actual = MatrixTurn.Matrix;
        String[] expected = {"212345", "343456", "456767", "567898"};
        Assert.assertThat(actual, is(expected));
    }
}