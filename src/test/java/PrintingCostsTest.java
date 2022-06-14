import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class PrintingCostsTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void simvolyIzInstrukcii() throws Exception {
        PrintingCosts pr = new PrintingCosts("X ^}1=");
        Assert.assertEquals(pr.calculatingPrintingCosts(), 76);
    }

    @Test
    public void simvolyNeIzInstrukcii() throws Exception {
        PrintingCosts pr = new PrintingCosts("йЦук");
        Assert.assertEquals(pr.calculatingPrintingCosts(), 92);
    }

    @Test
    public void simvolyIziNeIzInstrukcii() throws Exception {
        PrintingCosts pr = new PrintingCosts("йЦX");
        Assert.assertEquals(pr.calculatingPrintingCosts(), 64);
    }

    @Test
    public void probeli() throws Exception {
        PrintingCosts pr = new PrintingCosts("   ");
        Assert.assertEquals(pr.calculatingPrintingCosts(), 0);
    }

    @Test
    public void empty() throws Exception {
        PrintingCosts pr = new PrintingCosts("");
        Assert.assertEquals(pr.calculatingPrintingCosts(), 0);
    }
}