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
        LineAnalysis analysis = new LineAnalysis("*..*..*..*..*..*..*");
        Assert.assertThat(analysis.getAnalyze(), is(true));
    }

    @Test
    public void defoltnieZnacheniyaSecond() throws Exception {
        LineAnalysis analysis = new LineAnalysis("*");
        Assert.assertThat(analysis.getAnalyze(), is(true));
    }

    @Test
    public void defoltnieZnacheniyaThird() throws Exception {
        LineAnalysis analysis = new LineAnalysis("***");
        Assert.assertThat(analysis.getAnalyze(), is(true));
    }

    @Test
    public void defoltnieZnacheniyaFourth() throws Exception {
        LineAnalysis analysis = new LineAnalysis("*.......*.......*");
        Assert.assertThat(analysis.getAnalyze(), is(true));
    }

    @Test
    public void defoltnieZnacheniyaSixth() throws Exception {
        LineAnalysis analysis = new LineAnalysis("**");
        Assert.assertThat(analysis.getAnalyze(), is(true));
    }

    @Test
    public void defoltnieZnacheniyaSevnth() throws Exception {
        LineAnalysis analysis = new LineAnalysis("*.*");
        Assert.assertThat(analysis.getAnalyze(), is(true));
    }

    @Test
    public void defoltniOshbkaFirst() throws Exception {
        LineAnalysis analysis = new LineAnalysis("*..*...*..*..*..*..*");
        Assert.assertThat(analysis.getAnalyze(), is(false));
    }

    @Test
    public void defoltniOshbkaSecond() throws Exception {
        LineAnalysis analysis = new LineAnalysis("*..*..*..*..*..**..*");
        Assert.assertThat(analysis.getAnalyze(), is(false));
    }

    @Test
    public void perviyNeZvezdaDva() throws Exception {
        LineAnalysis analysis = new LineAnalysis(".*");
        Assert.assertThat(analysis.getAnalyze(), is(false));
    }

    @Test
    public void posledniyNeZvezdaDva() throws Exception {
        LineAnalysis analysis = new LineAnalysis("*.");
        Assert.assertThat(analysis.getAnalyze(), is(false));
    }

    @Test
    public void posledniyAndPerviyNeZvezdaTri() throws Exception {
        LineAnalysis analysis = new LineAnalysis(".*.");
        Assert.assertThat(analysis.getAnalyze(), is(false));
    }
}