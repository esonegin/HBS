import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BalancedParenthesesTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }
    @Test
    public void one() throws Exception {
        //1
        String actual = Level1.BalancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void two() throws Exception {
        //1
        String actual = Level1.BalancedParentheses(2);
        String expected = "()() (())";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void three() throws Exception {
        //1
        String actual = Level1.BalancedParentheses(3);
        String expected = "((())) (()()) ()()() (())() ()(())";
        Assert.assertThat(actual, is(expected));
    }
}