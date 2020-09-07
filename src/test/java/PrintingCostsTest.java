import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class PrintingCostsTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void simvolyIzInstrukcii() throws Exception {
        int actual = PrintingCosts.PrintingCosts("X ^}1=");
        int expected = 76;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void simvolyNeIzInstrukcii() throws Exception {
        int actual = PrintingCosts.PrintingCosts("йЦук");
        int expected = 92;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void simvolyIziNeIzInstrukcii() throws Exception {
        int actual = PrintingCosts.PrintingCosts("йЦX");
        int expected = 64;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void probeli() throws Exception {
        int actual = PrintingCosts.PrintingCosts("   ");
        int expected = 0;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void empty() throws Exception {
        int actual = PrintingCosts.PrintingCosts("");
        int expected = 0;
        Assert.assertThat(actual, is(expected));
    }
}