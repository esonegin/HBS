import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BigMinusTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void pervoeChisloBolsheDlinneeVtorogo() throws Exception {
        String actual = BigMinus.BigMinus("1234567891", "1");
        String expected = "1234567890";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void pervoeChisloMensheKorocheVtorogo() throws Exception {
        String actual = BigMinus.BigMinus("1", "321");
        String expected = "320";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void odinsimvolPolozhitelno() throws Exception {
        String actual = BigMinus.BigMinus("9", "2");
        String expected = "7";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void odinsimvolOtricatelno() throws Exception {
        String actual = BigMinus.BigMinus("2", "9");
        String expected = "7";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void zeroTest() throws Exception {
        String actual = BigMinus.BigMinus("0", "0");
        String expected = "0";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void zeroTestMalenkie() throws Exception {
        String actual = BigMinus.BigMinus("4", "4");
        String expected = "0";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void zeroTestBolshie() throws Exception {
        String actual = BigMinus.BigMinus("1234567890", "1234567890");
        String expected = "0";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void vichitanieIzNull() throws Exception {
        String actual = BigMinus.BigMinus("0", "4");
        String expected = "4";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void bigestPolozhitelnoe() throws Exception {
        String actual = BigMinus.BigMinus("10000000000000000", "13545642");
        String expected = "9999999986454358";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void bigest() throws Exception {
        String actual = BigMinus.BigMinus("13545642", "10000000000000000");
        String expected = "9999999986454358";
        Assert.assertThat(actual, is(expected));
    }

}