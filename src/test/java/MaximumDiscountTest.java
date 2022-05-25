import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MaximumDiscountTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void defoltnieZnacheniya() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(7, new int[]{3, 400, 150, 100, 200, 350, 300});
        int expected = 450;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void triZnacheniya() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(3, new int[]{250, 400, 150});
        int expected = 150;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void dvaZnacheniya() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(2, new int[]{250, 400});
        int expected = 0;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void odnoZnachenie() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(1, new int[]{250});
        int expected = 0;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void chetireZnacheniya() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(4, new int[]{37500, 1, 4, 3});
        int expected = 3;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void vosemZnacheniy() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(8, new int[]{250, 400, 150, 100, 100, 200, 350, 300});
        int expected = 450;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void devyatZnacheniy() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(9, new int[]{250, 400, 150, 100, 100, 200, 350, 300, 700});
        int expected = 650;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void triOdinakovihZnacheniya() throws Exception {
        int actual = MaximumDiscount.MaximumDiscount(3, new int[]{250, 250, 250});
        int expected = 250;
        Assert.assertThat(actual, is(expected));
    }
}