import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BiggerGreaterTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void first() throws Exception {
        //1
        String actual = Level1.BiggerGreater("ая");
        String expected = "яа";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void second() throws Exception {
        //1
        String actual = Level1.BiggerGreater("fff");
        String expected = "";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void third() throws Exception {
        //1
        String actual = Level1.BiggerGreater("нклм");
        String expected = "нкмл";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void fourth() throws Exception {
        //1
        String actual = Level1.BiggerGreater("вибк");
        String expected = "викб";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void fifth() throws Exception {
        //1
        String actual = Level1.BiggerGreater("вкиб");
        String expected = "ибвк";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void eng() throws Exception {
        //1
        String actual = Level1.BiggerGreater("ab");
        String expected = "ba";
        Assert.assertThat(actual, is(expected));
    }



}