import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;

public class UFOTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void sixToTen() throws Exception {
        TreeSet actual = UFO.UFO(2, new int[]{1234, 1777}, true);
        TreeSet expected = new TreeSet<>();
        expected.add(668);
        expected.add(1023);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void eightToTen() throws Exception {
        TreeSet actual = UFO.UFO(2, new int[]{1234, 1777}, false);
        TreeSet expected = new TreeSet<>();
        expected.add(4660);
        expected.add(6007);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sixToTenNull() throws Exception {
        TreeSet actual = UFO.UFO(2, new int[]{0, 0}, true);
        TreeSet expected = new TreeSet<>();
        expected.add(0);
        expected.add(0);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void eightToTenNull() throws Exception {
        TreeSet actual = UFO.UFO(2, new int[]{0, 0}, false);
        TreeSet expected = new TreeSet<>();
        expected.add(0);
        expected.add(0);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void eightToTenCifriRaznoyDlinni() throws Exception {
        TreeSet actual = UFO.UFO(4, new int[]{1, 12, 123, 1234, 12345, 654321}, false);
        TreeSet expected = new TreeSet<>();
        expected.add(1);
        expected.add(18);
        expected.add(291);
        expected.add(4660);
        expected.add(74565);
        expected.add(6636321);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sixToTenCifriRaznoyDlinni() throws Exception {
        TreeSet actual = UFO.UFO(4, new int[]{1, 12, 123, 1234, 12345, 654321}, true);
        TreeSet expected = new TreeSet<>();
        expected.add(1);
        expected.add(10);
        expected.add(83);
        expected.add(668);
        expected.add(5349);
        expected.add(219345);
        Assert.assertEquals(actual, expected);
    }
}