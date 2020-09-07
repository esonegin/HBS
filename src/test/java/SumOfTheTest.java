import org.junit.*;

public class SumOfTheTest {

    @BeforeClass
    public static void globalSetUp() { }

    @Before
    public void setUp() { }

    @Test
    public void searchSum45() throws Exception {
        int dlinna = 5;
        int[] svodka = {10, -25, -45, -35, 5};
        int result = -45;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSum90() throws Exception {
        int dlinna = 7;
        int[] svodka = {100, -50, 10, -25, 90, 90, -35};
        int result = 90;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSumTwoNull() throws Exception {
        int dlinna = 2;
        int[] svodka = {0, 0};
        int result = 0;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSumNullPlusOtricatelnoe() throws Exception {
        int dlinna = 2;
        int[] svodka = {0, -789};
        int result = -789;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSumOtricatelnoePlusNull() throws Exception {
        int dlinna = 2;
        int[] svodka = {-789, 0};
        int result = -789;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSumPolozhitelnoePlusNull() throws Exception {
        int dlinna = 2;
        int[] svodka = {789, 0};
        int result = 789;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSumNullPlusPolozhitelnoe() throws Exception {
        int dlinna = 2;
        int[] svodka = {0, 789};
        int result = 789;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }

    @Test
    public void searchSumThreeChisla() throws Exception {
        int dlinna = 3;
        int[] svodka = {2, 4, 2};
        int result = 4;
        Assert.assertTrue(SumOfThe.SumOfThe(dlinna, svodka) == result);
    }


}
