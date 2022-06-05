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
        BigMinus bigMinus = new BigMinus("1234567891", "1");
        String expected = "1234567890";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void pervoeChisloMensheKorocheVtorogo() throws Exception {
        BigMinus bigMinus = new BigMinus("1", "321");
        String expected = "320";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void odinsimvolPolozhitelno() throws Exception {
        BigMinus bigMinus = new BigMinus("9", "2");
        String expected = "7";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void odinsimvolOtricatelno() throws Exception {
        BigMinus bigMinus = new BigMinus("2", "9");
        String expected = "7";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void zeroTest() throws Exception {
        BigMinus bigMinus = new BigMinus("0", "0");
        String expected = "0";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void zeroTestMalenkie() throws Exception {
        BigMinus bigMinus = new BigMinus("4", "4");
        String expected = "0";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void zeroTestBolshie() throws Exception {
        BigMinus bigMinus = new BigMinus("1234567890", "1234567890");
        String expected = "0";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void vichitanieIzNull() throws Exception {
        BigMinus bigMinus = new BigMinus("0", "4");
        String expected = "4";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void bigestPolozhitelnoe() throws Exception {
        BigMinus bigMinus = new BigMinus("10000000000000000", "13545642");
        String expected = "9999999986454358";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

    @Test
    public void bigest() throws Exception {
        BigMinus bigMinus = new BigMinus("13545642", "10000000000000000");
        String expected = "9999999986454358";
        Assert.assertThat(bigMinus.getDifference(), is(expected));
    }

}