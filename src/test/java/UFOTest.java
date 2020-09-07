import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        int[] actual = UFO.UFO(2, new int[]{1234, 1777}, true);
        int[] expected = {668, 1023};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void eightToTen() throws Exception {
        int[] actual = UFO.UFO(2, new int[]{1234, 1777}, false);
        int[] expected = {4660, 6007};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void sixToTenNull() throws Exception {
        int[] actual = UFO.UFO(2, new int[]{0, 0}, true);
        int[] expected = {0, 0};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void eightToTenNull() throws Exception {
        int[] actual = UFO.UFO(2, new int[]{0, 0}, false);
        int[] expected = {0, 0};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void eightToTenCifriRaznoyDlinni() throws Exception {
        int[] actual = UFO.UFO(4, new int[]{1, 12, 123, 1234, 12345, 654321}, false);
        int[] expected = {1, 18, 291, 4660, 74565, 6636321};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void sixToTenCifriRaznoyDlinni() throws Exception {
        int[] actual = UFO.UFO(4, new int[]{1, 12, 123, 1234, 12345, 654321}, true);
        int[] expected = {1, 10, 83, 668, 5349, 219345};
        Assert.assertThat(actual, is(expected));
    }


}