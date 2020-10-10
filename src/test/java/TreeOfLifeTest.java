import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class TreeOfLifeTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void ishodnoe() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 0, new String[]{".+..", "..+.", ".+.."});
        String [] expected = {".+..", "..+.", ".+.."};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void first() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 1, new String[]{".+..", "..+.", ".+.."});
        String [] expected = {"++++", "++++", "++++"};
        Assert.assertThat(actual, is(expected));
    }


    @Test
    public void second() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 2, new String[]{".+..", "..+.", ".+.."});
        String [] expected = {"...+", "+...", "...+"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void third() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 3, new String[]{".+..", "..+.", ".+.."});
        String [] expected = {"++++", "++++", "++++"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void fourth() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 4, new String[]{".+..", "..+.", ".+.."});
        String [] expected = {".+..", "..+.", ".+.."};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void twelve() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 12, new String[]{".+..", "..+.", ".+.."});
        String [] expected = {".+..", "..+.", ".+.."};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void error1() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(6, 7, 24, new String[]{".......","...+...","....+..",".......","++.....","++....."});
        String [] expected = {".......","...+...","....+..",".......","++.....","++....."};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void errorStep2() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(6, 7, 2, new String[]{".......","...+...","....+..",".......","++.....","++....."});
        String [] expected = {"+++.+++","++...++","+++...+","..++.++","...++++","...++++"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void errorStep3() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(6, 7, 3, new String[]{".......","...+...","....+..",".......","++.....","++....."});
        String [] expected = {"+++++++","+++++++","+++++++","+++++++","+++++++","+++++++"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void errorStep4() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(6, 7, 4, new String[]{".......","...+...","....+..",".......","++.....","++....."});
        String [] expected = {".......","...+...","....+..",".......","++.....","++....."};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void simple() throws Exception {
        //1
        String [] actual = Level1.TreeOfLife(3,4, 6, new String[]{"....", ".++.", "...."});
        String [] expected = {"+..+", "....", "+..+"};
        Assert.assertThat(actual, is(expected));
    }



}