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
        String actual = BalancedParentheses.BalancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void two() throws Exception {
        //1
        String actual = BalancedParentheses.BalancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.BalancedParentheses(2);
        expected = "(()) ()()";
        Assert.assertThat(actual, is(expected));

    }
    @Test
    public void three() throws Exception {
        //1
        String actual = BalancedParentheses.BalancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.BalancedParentheses(2);
        expected = "(()) ()()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.BalancedParentheses(3);
        expected = "((())) (()()) ()(()) ()()() (())()";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void four() throws Exception {
        //1
        String actual = BalancedParentheses.BalancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.BalancedParentheses(2);
        expected = "(()) ()()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.BalancedParentheses(3);
        expected = "((())) (()()) ()(()) ()()() (())()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.BalancedParentheses(4);
        expected = "(((()))) ((()())) (()(())) (()()()) ()((())) ()(()()) ()()(()) ()()()() ((())()) ((()))() (()())() (())()()";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void five() throws Exception {
        //1
        String actual = BalancedParentheses.BalancedParentheses(5);
        String expected = "((((())))) (((()()))) (((())())) (((()))()) (((())))() ((()(()))) ((()()())) ((()())()) ((()()))() ((())(())) ((())()()) ((())())() ((()))(()) ((()))()() (()((()))) (()(()())) (()(())()) (()(()))() (()()(())) (()()()()) (()()())() (()())(()) (()())()() (())((())) (())(()()) (())(())() (())()(()) (())()()() ()(((()))) ()((()())) ()((())()) ()((()))() ()(()(())) ()(()()()) ()(()())() ()(())(()) ()(())()() ()()((())) ()()(()()) ()()(())() ()()()(()) ()()()()()";
        Assert.assertThat(actual, is(expected));
    }
}