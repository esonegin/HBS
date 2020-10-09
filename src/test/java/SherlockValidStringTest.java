import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SherlockValidStringTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void first() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xyz");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void second() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xyzaa");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void third() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xxyyz");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void fourth() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xyzzz");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void fifth() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xxyyza");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void sixth() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xxyyzabc");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void seventh() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xy");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void eights() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xx");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void ninth() throws Exception {
        //1
        boolean actual = SherlockValidString.SherlockValidString("xxy");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }


}