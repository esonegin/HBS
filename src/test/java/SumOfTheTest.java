import org.junit.*;

import static org.hamcrest.CoreMatchers.is;

public class SumOfTheTest {

    @BeforeClass
    public static void globalSetUp() { }

    @Before
    public void setUp() { }

    @Test
    public void searchSum45() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{10, -25, -45, -35, 5});
        Assert.assertThat(sumofthe.getSum(), is(-45));
    }

    @Test
    public void searchSum90() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{100, -50, 10, -25, 90, 90, -35});
        Assert.assertThat(sumofthe.getSum(), is(90));
    }

    @Test
    public void searchSumTwoNull() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{0, 0});
        Assert.assertThat(sumofthe.getSum(), is(0));
    }

    @Test
    public void searchSumNullPlusOtricatelnoe() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{0, -789});
        Assert.assertThat(sumofthe.getSum(), is(-789));
    }

    @Test
    public void searchSumOtricatelnoePlusNull() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{-789, 0});
        Assert.assertThat(sumofthe.getSum(), is(-789));
    }

    @Test
    public void searchSumPolozhitelnoePlusNull() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{789, 0});
        Assert.assertThat(sumofthe.getSum(), is(789));
    }

    @Test
    public void searchSumNullPlusPolozhitelnoe() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{0, 789});
        Assert.assertThat(sumofthe.getSum(), is(789));
    }

    @Test
    public void searchSumThreeChisla() throws Exception {
        SumOfThe sumofthe = new SumOfThe(new int[]{2, 4, 2});
        Assert.assertThat(sumofthe.getSum(), is(4));
    }
}
