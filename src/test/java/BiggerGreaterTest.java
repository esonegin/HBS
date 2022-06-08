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
    public void firstRus() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("ая");
        String expected = "яа";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void firstEng() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("za");
        String expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void firstEng2() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("az");
        String expected = "za";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void firstEng3() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("cibk");
        String expected = "cikb";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void second() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("fff");
        String expected = "";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void third() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("нклм");
        String expected = "нкмл";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void fourth() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("вибк");
        String expected = "викб";
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void fifth() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("вкиб");
        String expected = "ибвк";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void eng() throws Exception {
        //1
        String actual = BiggerGreater.biggerGreater("ab");
        String expected = "ba";
        Assert.assertThat(actual, is(expected));
    }



}