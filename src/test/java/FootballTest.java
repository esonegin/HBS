import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class FootballTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void firstvar() throws Exception {
        //1
        Boolean actual = Level1.Football(new int[]{1, 3, 2}, 3);
        Boolean expected = true;
        Assert.assertThat(actual, is(expected));
        actual = Level1.Football(new int[]{1, 7, 5, 3, 9}, 5);
        expected = true;
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void secondvar() throws Exception {
        //1
        Boolean actual = Level1.Football(new int[]{3, 2, 1}, 3);
        Boolean expected = true;
        Assert.assertThat(actual, is(expected));
        actual = Level1.Football(new int[]{1, 4, 3, 2, 5}, 5);
        expected = true;
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void notvar() throws Exception {
        //1
        Boolean actual = Level1.Football(new int[]{9, 5, 3, 7, 1}, 5);
        Boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void onetwovar() throws Exception {
        //1
        Boolean actual = Level1.Football(new int[]{9}, 1);
        Boolean expected = true;
        Assert.assertThat(actual, is(expected));
        actual = Level1.Football(new int[]{3, 2}, 2);
        expected = true;
        Assert.assertThat(actual, is(expected));
    }
}