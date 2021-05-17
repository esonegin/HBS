
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;


public class CalcTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void stringInArrayDefTest() {
        Calc calc = new Calc();

        Assert.assertThat(calc.stringInArray("1 + 2")[0], is("1"));
        Assert.assertThat(calc.stringInArray("1 + 2")[1], is("+"));
        Assert.assertThat(calc.stringInArray("1 + 2")[2], is("2"));
    }

    @Test
    public void elementGenDefTest() {
        Calc calc = new Calc();
        calc.elementGen(calc.stringInArray("1 + 2"));
        Assert.assertThat(calc.first, is(1));
        Assert.assertThat(calc.operation, is("+"));
        Assert.assertThat(calc.second, is(2));
    }

    @Test
    public void elementGenErrorTest() throws NullPointerException {
        Calc calc = new Calc();
        try {
            calc.elementGen(calc.stringInArray("11 + 2"));
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException thrown) {
            Assert.assertEquals("Одно из чисел не в диапазоне 0-10", thrown.getMessage());
        }

        try {
            calc.elementGen(calc.stringInArray("2 + 11"));
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException thrown) {
            Assert.assertEquals("Одно из чисел не в диапазоне 0-10", thrown.getMessage());
        }

        try {
            calc.elementGen(calc.stringInArray("-2 + 10"));
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException thrown) {
            Assert.assertEquals("Одно из чисел не в диапазоне 0-10", thrown.getMessage());
        }

        try {
            calc.elementGen(calc.stringInArray("2 & 10"));
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException thrown) {
            Assert.assertEquals("Данная операция невозможна", thrown.getMessage());
        }
    }

    @Test
    public void stringInArrayRomainTest() {
        Calc calc = new Calc();

        Assert.assertThat(calc.stringInArray("I + V")[0], is("I"));
        Assert.assertThat(calc.stringInArray("I + V")[1], is("+"));
        Assert.assertThat(calc.stringInArray("I + V")[2], is("V"));
    }

    @Test
    public void elementGenRomainTest() {
        Calc calc = new Calc();
        calc.elementGen(calc.stringInArray("I + V"));
        Assert.assertThat(calc.first, is(1));
        Assert.assertThat(calc.operation, is("+"));
        Assert.assertThat(calc.second, is(5));
    }

    @Test
    public void elementGenRomainMaxTest() {
        Calc calc = new Calc();
        calc.elementGen(calc.stringInArray("IX * IX"));
        Assert.assertThat(calc.first, is(9));
        Assert.assertThat(calc.operation, is("*"));
        Assert.assertThat(calc.second, is(9));

        //LXXXI
    }

    @Test
    public void elementGenRomainSixTest() {
        Calc calc = new Calc();
        calc.elementGen(calc.stringInArray("VI * VI"));
        Assert.assertThat(calc.first, is(6));
        Assert.assertThat(calc.operation, is("*"));
        Assert.assertThat(calc.second, is(6));

        //XXXVI
    }
}