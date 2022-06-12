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
        MaximumDiscount prices = new MaximumDiscount(7, new int[]{3, 400, 150, 100, 200, 350, 300});
        Assert.assertThat(prices.getMaxDiscount(), is(400));
    }

    @Test
    public void triZnacheniya() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(3, new int[]{250, 400, 150});
        Assert.assertThat(prices.getMaxDiscount(), is(150));
    }

    @Test
    public void dvaZnacheniya() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(2, new int[]{250, 400});
        Assert.assertThat(prices.getMaxDiscount(), is(0));
    }

    @Test
    public void odnoZnachenie() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(1, new int[]{250});
        Assert.assertThat(prices.getMaxDiscount(), is(0));
    }

    @Test
    public void chetireZnacheniya() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(4, new int[]{37500, 1, 4, 3});
        Assert.assertThat(prices.getMaxDiscount(), is(3));
    }

    @Test
    public void vosemZnacheniy() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(8, new int[]{250, 400, 150, 100, 100, 200, 350, 300});
        Assert.assertThat(prices.getMaxDiscount(), is(450));
    }

    @Test
    public void devyatZnacheniy() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(9, new int[]{250, 400, 150, 100, 100, 200, 350, 300, 700});
        Assert.assertThat(prices.getMaxDiscount(), is(650));
    }

    @Test
    public void triOdinakovihZnacheniya() throws Exception {
        MaximumDiscount prices = new MaximumDiscount(3, new int[]{250, 250, 250});
        Assert.assertThat(prices.getMaxDiscount(), is(250));
    }
}