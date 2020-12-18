import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;



public class BracketsTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public <T> void balanceCheck() throws Exception {
        Brackets brackets = new Brackets();
        Assert.assertThat(brackets.balanceCheck(")"), is(false));
        Assert.assertThat(brackets.balanceCheck("("), is(false));
        Assert.assertThat(brackets.balanceCheck(")("), is(false));
        Assert.assertThat(brackets.balanceCheck("()"), is(true));
        Assert.assertThat(brackets.balanceCheck("((()))"), is(true));
        Assert.assertThat(brackets.balanceCheck("()((())())"), is(true));
        Assert.assertThat(brackets.balanceCheck("(()())()()"), is(true));
        Assert.assertThat(brackets.balanceCheck("((()(())))"), is(true));
        Assert.assertThat(brackets.balanceCheck("())("), is(false));
        Assert.assertThat(brackets.balanceCheck("))(("), is(false));
        Assert.assertThat(brackets.balanceCheck("((())"), is(false));
    }

}
