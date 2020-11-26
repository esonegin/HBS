import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class KeymakerTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void one() throws Exception {
        //1
        String actual = Keymaker.Keymaker(1);
        String expected = "1";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void two() throws Exception {
        //1
        String actual = Keymaker.Keymaker(2);
        String expected = "10";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void three() throws Exception {
        //1
        String actual = Keymaker.Keymaker(3);
        String expected = "100";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void four() throws Exception {
        //1
        String actual = Keymaker.Keymaker(4);
        String expected = "1001";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void five() throws Exception {
        //1
        String actual = Keymaker.Keymaker(5);
        String expected = "10010";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void six() throws Exception {
        //1
        String actual = Keymaker.Keymaker(6);
        String expected = "100100";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void seven() throws Exception {
        //1
        String actual = Keymaker.Keymaker(7);
        String expected = "1001000";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void eight() throws Exception {
        //1
        String actual = Keymaker.Keymaker(8);
        String expected = "10010000";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void nine() throws Exception {
        //1
        String actual = Keymaker.Keymaker(9);
        String expected = "100100001";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void ten() throws Exception {
        //1
        String actual = Keymaker.Keymaker(10);
        String expected = "1001000010";
        Assert.assertThat(actual, is(expected));
    }
}
