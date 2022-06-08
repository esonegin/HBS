import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

class balancedParenthesesTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }
    @Test
    public void one() throws Exception {
        //1
        String actual = BalancedParentheses.balancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void two() throws Exception {
        //1
        String actual = BalancedParentheses.balancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.balancedParentheses(2);
        expected = "(()) ()()";
        Assert.assertThat(actual, is(expected));

    }
    @Test
    public void three() throws Exception {
        //1
        String actual = BalancedParentheses.balancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.balancedParentheses(2);
        expected = "(()) ()()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.balancedParentheses(3);
        expected = "((())) (()()) ()(()) ()()() (())()";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void four() throws Exception {
        //1
        String actual = BalancedParentheses.balancedParentheses(1);
        String expected = "()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.balancedParentheses(2);
        expected = "(()) ()()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.balancedParentheses(3);
        expected = "((())) (()()) ()(()) ()()() (())()";
        Assert.assertThat(actual, is(expected));
        actual = BalancedParentheses.balancedParentheses(4);
        expected = "(((()))) ((()())) (()(())) (()()()) ()((())) ()(()()) ()()(()) ()()()() ((())()) ((()))() (()())() (())()()";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void five() throws Exception {
        //1
        String actual = BalancedParentheses.balancedParentheses(5);
        String expected = "((((())))) (((()()))) (((())())) (((()))()) (((())))() ((()(()))) ((()()())) ((()())()) ((()()))() ((())(())) ((())()()) ((())())() ((()))(()) ((()))()() (()((()))) (()(()())) (()(())()) (()(()))() (()()(())) (()()()()) (()()())() (()())(()) (()())()() (())((())) (())(()()) (())(())() (())()(()) (())()()() ()(((()))) ()((()())) ()((())()) ()((()))() ()(()(())) ()(()()()) ()(()())() ()(())(()) ()(())()() ()()((())) ()()(()()) ()()(())() ()()()(()) ()()()()()";
        Assert.assertThat(actual, is(expected));
    }
}