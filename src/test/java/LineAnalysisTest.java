import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LineAnalysisTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void defoltnieZnacheniyaFirst() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*..*..*..*..*..*..*");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltnieZnacheniyaSecond() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltnieZnacheniyaThird() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("***");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltnieZnacheniyaFourth() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*.......*.......*");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltnieZnacheniyaFifth() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*.......*.......*");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltnieZnacheniyaSixth() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("**");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltnieZnacheniyaSevnth() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*.*");
        boolean expected = true;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltniOshbkaFirst() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*..*...*..*..*..*..*");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void defoltniOshbkaSecond() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*..*..*..*..*..**..*");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void perviyNeZvezdaDva() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis(".*");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void posledniyNeZvezdaDva() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis("*.");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void posledniyAndPerviyNeZvezdaTri() throws Exception {
        boolean actual = LineAnalysis.LineAnalysis(".*.");
        boolean expected = false;
        Assert.assertThat(actual, is(expected));
    }
}