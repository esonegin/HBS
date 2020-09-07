import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class UnmannedTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void defoltnieZnacheniya() throws Exception {
        int actual = Unmanned.Unmanned(10,2, new int[][]{{3, 5, 5}, {5, 2, 2}});
        int expected = 12;
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void odinSvetoforKrasniy() throws Exception {
        int actual = Unmanned.Unmanned(3,1, new int[][]{{2, 3, 1}});
        int expected = 4;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void odinSvetoforZeleniy() throws Exception {
        int actual = Unmanned.Unmanned(3,1, new int[][]{{2, 2, 1}});
        int expected = 3;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void perviyZeleniyVtoroyKrasniy() throws Exception {
        int actual = Unmanned.Unmanned(8,2, new int[][]{{3, 3, 1}, {6, 4, 1}});
        int expected = 11;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void bezSvetoforov() throws Exception {
        int actual = Unmanned.Unmanned(8,0, new int[][]{});
        int expected = 8;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void dvaKrasnyh() throws Exception {
        int actual = Unmanned.Unmanned(10,2, new int[][]{{3,6,2},{6,2,2}});
        int expected = 14;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void perviyKrasniyVtoroyZeleniy() throws Exception {
        int actual = Unmanned.Unmanned(10,2, new int[][]{{3,2,2},{6,1,3}});
        int expected = 10;
        Assert.assertThat(actual, is(expected));
    }

}